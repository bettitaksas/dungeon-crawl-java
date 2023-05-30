package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashSet;
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
    public void pickItemUp(){

        if (getCell().getType() == CellType.WAND) {
            System.out.println("WAND!!!");

            //change the field to floor
            getCell().setType(CellType.FLOOR);
        }

    }
}
