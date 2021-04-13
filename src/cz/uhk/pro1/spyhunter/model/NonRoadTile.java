package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class NonRoadTile implements Tile {

    @Override
    public void drawTile(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillRect(x,y,Tile.SIZE,Tile.SIZE);
    }

    @Override
    public void actionOnCollision(Game game) {
        game.setGameOver(true);
    }

    @Override
    public String toString()
    {
        return "x";
    }
}
