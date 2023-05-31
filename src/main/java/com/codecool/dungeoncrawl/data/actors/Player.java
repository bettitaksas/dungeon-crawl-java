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

    //tárolhatóság
    public void pickItemUp() {

        ////KISZERVEZNI!!
        if (getCell().getType() == CellType.WAND) {
            System.out.println("WAND!!!");

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


        if (getCell().getType() == CellType.EGG) {
            System.out.println("EGG!!!");

            // check if wand item already exists in the list
            boolean eggExists = false;
            for (Item item : items) {
                if (item instanceof Egg) {
                    eggExists = true;
                    break;
                }
            }

            if (!eggExists) {
                Item egg = new Egg(1);
                // If wand item doesn't exist, add it to the list
                items.add(egg);
                items.forEach(i -> System.out.println(i.getAmount()));
                System.out.println("Length of the set: " + items.size());
                System.out.println("First " + egg.getTileName() + " picked up");
            } else {
                // if wand item exists, increment its amount
                for (Item item : items) {
                    if (item instanceof Egg) {
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

/*    public int getWand() {
        return items.stream().filter(i -> Objects.equals(i.getTileName(), "wand")).findFirst().get().getAmount();
    }*/

    //KISZERVEZNI!!!
    public int getWand() {
        Optional<Item> wandItem = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), "wand"))
                .findFirst();

        if (wandItem.isPresent()) {
            return wandItem.get().getAmount();
        } else {
            // handle the case when "wand" item is not found
            return 0; // or any other appropriate value
        }
    }

    public int getKey() {
        Optional<Item> keyItem = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), "goldKey"))
                .findFirst();

        if (keyItem.isPresent()) {
            return keyItem.get().getAmount();
        } else {
            // handle the case when "wand" item is not found
            return 0; // or any other appropriate value
        }
    }

    public int getScuba() {
        Optional<Item> scubaItem = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), "scuba"))
                .findFirst();

        if(scubaItem.isPresent()) {
            return scubaItem.get().getAmount();
        } else {
            //handle the case when "scuba" item is not found
            return 0; //or any other appropriate value
        }
    }

    public int getEgg() {
        Optional<Item> eggItem = items.stream()
                .filter(i -> Objects.equals(i.getTileName(), "egg"))
                .findFirst();

        if(eggItem.isPresent()) {
            return eggItem.get().getAmount();
        } else {
            return 0;
        }
    }

}
