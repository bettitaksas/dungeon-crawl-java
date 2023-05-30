package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Basiliscus extends Actor{
    public Basiliscus(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "basiliscus";
    }
}
