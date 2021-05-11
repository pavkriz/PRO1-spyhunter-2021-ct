package cz.uhk.pro1.spyhunter.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Car {
    private int x;
    private int y;
    private Image image;

    public Car(int startX, int startY, String textureURL) {
        x = startX;
        y = startY;
        try {
            image = ImageIO.read(new URL(textureURL));
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

    public boolean collidesWithTile(int tileX, int tileY, int tileSize) {
        Rectangle rectCar = new Rectangle(x , y, image.getWidth(null), image.getHeight(null));
        Rectangle rectTile = new Rectangle(tileX, tileY, tileSize, tileSize);
        return rectCar.intersects(rectTile);
    }
}
