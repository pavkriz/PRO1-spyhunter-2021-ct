package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public abstract class AbstractTile implements Tile {
    private Image image;


    public AbstractTile(Image image) {
        this.image = image;
    }

    @Override
    public void drawTile(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }
}
