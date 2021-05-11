package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class PowerUpTile extends AbstractTile  {
    public PowerUpTile(Image image, Image imageRoad)
    {
        super(image);
        powerUpTileRoad = imageRoad;
    }
    Image powerUpTileRoad;
    boolean active = true;


    @Override
    public void drawTile(Graphics g, int x, int y) {
        if (active) {
            //g.drawImage(image, x, y, null);
            super.drawTile(g, x, y);
        } else {
            g.drawImage(powerUpTileRoad, x , y, null);
        }
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
