package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class RoadTile implements Tile {
    @Override
    public void drawTile(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,Tile.SIZE,Tile.SIZE);
    }

    @Override
    public void actionOnCollision(Game game) {
        //ok, nic se nedeje, kdyz "narazime" do policka "silnice"
    }

    @Override
    public String toString()
    {
        return " ";
    }
}
