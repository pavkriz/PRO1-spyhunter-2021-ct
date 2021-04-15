package cz.uhk.pro1.spyhunter.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Car {
    private int x;
    private int y;
    private Image image;

    public Car(int startX, int startY){
        x = startX;
        y = startY;
        try {
            image = ImageIO.read(new URL("https://lide.uhk.cz/fim/ucitel/krizpa1/pro2/spyhunter/car2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveCar(int dX){
        x = x+dX;
    }

    public void draw(Graphics g){
        g.drawImage(image, x, y, null);
    }

    public boolean collidesWithTile(int tileX, int tileY) {
        Rectangle rectCar = new Rectangle(x , y, image.getWidth(null), image.getHeight(null));
        Rectangle rectTile = new Rectangle(tileX, tileY, Tile.SIZE, Tile.SIZE);
        return rectCar.intersects(rectTile);
    }
}
