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
        Cell cell = this.getCell();
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean keyExists = checkIfItemExists("goldKey");
        if (nextCell.getType() == CellType.CLOSEDDOOR && keyExists) {
            nextCell.setType(CellType.OPENEDDOOR);
            for (Item item : items) {
                if (item instanceof Key) {
                    items.remove(item);
                    break;
                }
            }

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
                items.forEach(i -> System.out.println(i.getAmount()));
                System.out.println("Length of the set: " + items.size());
                System.out.println("First one picked up");
            } else {
                for (int i = 0; i < items.size()-1; i++){
                    if(items.get(i).getTileName() == itemTileName){
                        items.get(i).setAmount(items.get(i).getAmount() + 1);
                        break;
                    }
                }
            }

            if(cellType == CellType.SOCKS) {
                getCell().setType(CellType.WATER);
            } else {
                getCell().setType(CellType.FLOOR);
            }
        }
    }

    public int getItem(String itemTileName) {
        Optional<Item> item = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), itemTileName))
                .findFirst();
        return item.map(Item::getAmount).orElse(0);
    }
}