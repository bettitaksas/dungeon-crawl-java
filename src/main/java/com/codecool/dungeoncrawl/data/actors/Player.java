package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.*;


import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Player extends Actor {

    private Set<Item> items = new HashSet<>();
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

    public void openDoor(int dx, int dy) {
        Cell cell = this.getCell();
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean keyExists = false;
        int keyAmount;
        for (Item item : items) {
            if (item instanceof Key) {
                keyExists = true;
                keyAmount = item.getAmount();
                break;
            }
        }
        if (nextCell.getType() == CellType.CLOSEDDOOR && keyExists == true /*&& keyAmount > 0*/) {
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

    //tárolhatóság
    public void pickItemUp() {

        ////KISZERVEZNI!!
        if (getCell().getType() == CellType.WAND) {
            System.out.println("WAND!!!");

            Cell cell = this.getCell();
            cell.getActor().setHealth(cell.getActor().getHealth() + 100);

            // check if wand item already exists in the list
            boolean wandExists = false;
            for (Item item : items) {
                if (item instanceof Wand) {
                    wandExists = true;
                    break;
                }
            }

            if (!wandExists) {
                Item wand = new Wand(1);
                // If wand item doesn't exist, add it to the list
                items.add(wand);
                items.forEach(i -> System.out.println(i.getAmount()));
                System.out.println("Length of the set: " + items.size());
                System.out.println("First one picked up");
            } else {
                // if wand item exists, increment its amount
                for (Item item : items) {
                    if (item instanceof Wand) {
                        item.setAmount(item.getAmount() + 1);
                        break;
                    }
                }
                System.out.println("Another one picked up");
                System.out.println("Length of the set: " + items.size());
            }

            // change the field to floor
            getCell().setType(CellType.FLOOR);
        }


        if (getCell().getType() == CellType.GOLDKEY) {
            System.out.println("GOLDKEY!!!");

            // check if wand item already exists in the list
            boolean goldKeyExists = false;
            for (Item item : items) {
                if (item instanceof Key) {
                    goldKeyExists = true;
                    break;
                }
            }

            if (!goldKeyExists) {
                Item key = new Key(1);
                // If wand item doesn't exist, add it to the list
                items.add(key);
                items.forEach(i -> System.out.println(i.getAmount()));
                System.out.println("Length of the set: " + items.size());
                System.out.println("First one picked up");
            } else {
                // if wand item exists, increment its amount
                for (Item item : items) {
                    if (item instanceof Key) {
                        item.setAmount(item.getAmount() + 1);
                        break;
                    }
                }
                System.out.println("Another one picked up");
                System.out.println("Length of the set: " + items.size());
            }

            // change the field to floor
            getCell().setType(CellType.FLOOR);
        }

        if (getCell().getType() == CellType.SCUBA) {
            System.out.println("SCUBA!!!");

            // check if wand item already exists in the list
            boolean scubaExists = false;
            for (Item item : items) {
                if (item instanceof Scuba) {
                    scubaExists = true;
                    break;
                }
            }

            if (!scubaExists) {
                Item scuba = new Scuba(1);
                // If wand item doesn't exist, add it to the list
                items.add(scuba);
                items.forEach(i -> System.out.println(i.getAmount()));
                System.out.println("Length of the set: " + items.size());
                System.out.println("First one picked up");
            } else {
                // if wand item exists, increment its amount
                for (Item item : items) {
                    if (item instanceof Scuba) {
                        item.setAmount(item.getAmount() + 1);
                        break;
                    }
                }
                System.out.println("Another one picked up");
                System.out.println("Length of the set: " + items.size());
            }

            // change the field to floor
            getCell().setType(CellType.FLOOR);
        }


        if (getCell().getType() == CellType.SOCKS) {
            System.out.println("SOCKS!!!");
            System.out.println("Doby is a free elf!!!!!!!");


            // check if wand item already exists in the list
            boolean sockExists = false;
            for (Item item : items) {
                if (item instanceof Socks) {
                    sockExists = true;
                    break;
                }
            }

            if (!sockExists) {
                Item socks = new Socks(1);
                // If wand item doesn't exist, add it to the list
                items.add(socks);
                items.forEach(i -> System.out.println(i.getAmount()));
                System.out.println("Length of the set: " + items.size());
                System.out.println("First " + socks.getTileName() + " picked up");
            } else if (sockExists) {
                // if wand item exists, increment its amount
                for (Item item : items) {
                    if (item instanceof Socks) {
                        item.setAmount(item.getAmount() + 1);
                        break;
                    }
                }
                System.out.println("Another one picked up");
                System.out.println("Length of the set: " + items.size());
            }

            // change the field to floor
            getCell().setType(CellType.WATER);
        }
    }

    public int getItem(String itemTileName) {
        Optional<Item> item = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), itemTileName))
                .findFirst();
        return item.map(Item::getAmount).orElse(0);
    }
}