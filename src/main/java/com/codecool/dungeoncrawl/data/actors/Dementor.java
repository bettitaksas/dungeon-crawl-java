package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Dementor extends Actor {
    public Dementor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "dementor";
    }
}
