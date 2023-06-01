package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Scuba;
import com.codecool.dungeoncrawl.data.items.Socks;
import com.codecool.dungeoncrawl.data.items.Wand;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left implements KeyHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().move(-1, 0);
            map.getPlayer().pickItemUp(CellType.WAND, "wand", new Wand(1));
            map.getPlayer().pickItemUp(CellType.GOLDKEY, "goldKey", new Key(1));
            map.getPlayer().pickItemUp(CellType.SCUBA, "scuba", new Scuba(1));
            map.getPlayer().pickItemUp(CellType.SOCKS, "socks", new Socks(1));
            map.getPlayer().fight(-1, 0);
            map.getPlayer().openDoor(-1, 0);
            map.getDementor().randomMove();
        }
    }
}
