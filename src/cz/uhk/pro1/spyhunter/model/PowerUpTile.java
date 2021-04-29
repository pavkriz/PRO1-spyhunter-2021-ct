package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class PowerUpTile implements Tile {

    boolean active = true;


    @Override
    public void drawTile(Graphics g, int x, int y) {
        if (active) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(x,y,Tile.SIZE,Tile.SIZE);
    }

    @Override
    public void actionOnCollision(Game game) {
        if (active) {
            game.setScore(game.getScore() + 10);  // pridat skore
            //game.setElapsedY(game.getElapsedY() + 100); // teleportovat o nekolik pixelu dale
            active = false;
            //game.setNormalTickShift(2);
        }
    }

    @Override
    public String toString() {
        return "@";
    }


    public void reactivatePowerUp()
    {
        this.active = true;
    }
}
