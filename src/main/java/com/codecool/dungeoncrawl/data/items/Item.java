package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Item implements Drawable {
    private int amount;
    //private Cell cell;

    public Item(int amount /*Cell cell*/) {
        this.amount = amount;
        //this.cell = cell;
        //this.cell.setItem(this);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //public Cell getCell() {
        //return cell;
    //}

}
