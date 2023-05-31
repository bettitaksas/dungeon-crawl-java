package com.codecool.dungeoncrawl.data.deads;

import com.codecool.dungeoncrawl.data.Cell;

public class deadEnemy extends Dead {

    public deadEnemy(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "deadEnemy";
    }
}
