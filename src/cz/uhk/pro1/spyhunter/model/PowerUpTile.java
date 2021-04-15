package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class PowerUpTile implements Tile {


    @Override
    public void drawTile(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,Tile.SIZE,Tile.SIZE);
    }

    @Override
    public void actionOnCollision(Game game) {
        // TODO
    }

    @Override
    public String toString() {
        return "@";
    }
}
