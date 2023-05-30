package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Octopus extends Actor{
    public Octopus(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "octopus";
    }
}
