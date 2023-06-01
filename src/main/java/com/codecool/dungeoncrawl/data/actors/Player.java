package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.*;


import java.util.*;

public class Player extends Actor {

    private List<Item> items = new ArrayList<>();
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

    private boolean checkIfItemExists(String itemTileName) {
        for (Item item : items) {
            if (item.getTileName().equals(itemTileName)) {
                return true;
            }
        }
        return false;
    }

    public void openDoor(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean keyExists = checkIfItemExists("goldKey");
        if (nextCell.getType() == CellType.CLOSEDDOOR && keyExists) {
            nextCell.setType(CellType.OPENEDDOOR);
            removeKeyItem();
        }
    }

    public void fight(int dx, int dy) {
        int damagePlayer = 5;
        int damageEnemy = 2;
        int gratisHealth = 10;
        Actor player = cell.getActor();
        Cell nextCell = cell.getNeighbor(dx, dy);
        Actor enemy = nextCell.getActor();

        if (nextCell.getType() == CellType.FLOOR && nextCell.getActor() != null) {
            enemy.setHealth(enemy.getHealth() - damagePlayer);
            player.setHealth(player.getHealth() - damageEnemy);

            if(enemy.getHealth() <= 0){
                enemy.die();
                player.setHealth(player.getHealth() + gratisHealth);
            }
            if(player.getHealth() <= 0){
                player.die();
            }
        }
    }

    public void pickItemUp(CellType cellType, String itemTileName, Item itemToPickUp) {

        if (getCell().getType() == cellType) {

            if (cellType == CellType.WAND){
                cell.getActor().setHealth(cell.getActor().getHealth() + 100);
            }

            boolean itemExists = checkIfItemExists(itemTileName);

            if (!itemExists) {
                items.add(itemToPickUp);
            } else {

                increaseItemAmount(itemTileName);
            }
            setCellTypeBasedOnCellType(cellType);
        }
    }

    private void removeKeyItem() {
        for (Item item : items) {
            if (item instanceof Key) {
                items.remove(item);
                break;
            }
        }
    }

    private void setCellTypeBasedOnCellType(CellType cellType) {
        if (cellType == CellType.SOCKS) {
            getCell().setType(CellType.WATER);
        } else {
            getCell().setType(CellType.FLOOR);
        }
    }

    private void increaseItemAmount(String itemTileName) {
        for (Item item : items) {
            if (item.getTileName().equals(itemTileName)) {
                item.setAmount(item.getAmount() + 1);
                break;
            }
        }
    }

    public int getItem(String itemTileName) {
        Optional<Item> item = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), itemTileName))
                .findFirst();
        return item.map(Item::getAmount).orElse(0);
    }

    public int getSocks() {
        Optional<Item> socksItem = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), "socks"))
                .findFirst();

        if(socksItem.isPresent()) {
            return socksItem.get().getAmount();
        } else {
            return 0;
        }
    }
}