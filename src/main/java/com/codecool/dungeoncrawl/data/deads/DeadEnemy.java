package com.codecool.dungeoncrawl.data.deads;

import com.codecool.dungeoncrawl.data.Cell;

public class DeadEnemy extends Dead {

    public DeadEnemy(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "deadEnemy";
    }
}
