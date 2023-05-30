package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Wand extends Item{
    public Wand(int amount, Cell cell) {
        super(amount, cell);
    }

    @Override
    public String getTileName() {
        return "wand";
    }
}
