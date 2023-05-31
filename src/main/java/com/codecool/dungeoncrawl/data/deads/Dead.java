package com.codecool.dungeoncrawl.data.deads;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Dead implements Drawable {
    private Cell cell;

    public Dead(Cell cell) {
        this.cell = cell;
    }

}
