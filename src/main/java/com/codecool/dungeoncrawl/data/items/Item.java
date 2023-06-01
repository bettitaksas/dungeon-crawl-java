package com.codecool.dungeoncrawl.data.items;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Item implements Drawable {

    private int amount;

    public Item(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
