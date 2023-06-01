package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.deads.Dead;
import com.codecool.dungeoncrawl.data.deads.deadEnemy;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() != CellType.WALL && nextCell.getType() != CellType.MONSTER  &&
                nextCell.getType() != CellType.DEADENEMY && nextCell.getType() !=CellType.CLOSEDDOOR &&
                (nextCell.getActor() == null)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }
    public void randomMove() {
        int randomDx = (int) (Math.random() * 3) - 1;
        int randomDy = (int) (Math.random() * 3) - 1;
        Cell nextCell = cell.getNeighbor(randomDx, randomDy);
        if (nextCell.getActor() == null) {
            move(randomDx, randomDy);
        }



      /*  Cell randomCell = cell.getRandomOtherCell();
        if(randomCell.getType() == CellType.FLOOR && randomCell.getActor() == null) {
            cell.setActor(null);
            randomCell.setActor(this);
            cell = randomCell;
        }*/
    }

    public void die(){
        cell.setActor(null);
        cell.setType(CellType.DEADENEMY);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}