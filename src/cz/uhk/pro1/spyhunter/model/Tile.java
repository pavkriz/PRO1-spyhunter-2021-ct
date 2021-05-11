package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public interface Tile {


    /**
     * Vykresli dlazdici na herni plochu
     */
    public void drawTile(Graphics g, int x, int y);

    /**
     * Provede zmenu herniho stavu v pripade, ze doslo ke kolizi auta s danou dlazdici
     */
    public void actionOnCollision(Game game);

    /**
     * Vrati reprezentaci dane dlazdice formou jednoho znaku
     * @return znak
     */
    public String toString();
}
