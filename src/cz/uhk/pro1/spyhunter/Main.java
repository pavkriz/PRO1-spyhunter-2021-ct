package cz.uhk.pro1.spyhunter;

import cz.uhk.pro1.spyhunter.model.Game;
import cz.uhk.pro1.spyhunter.model.NonRoadTile;
import cz.uhk.pro1.spyhunter.model.RoadTile;
import cz.uhk.pro1.spyhunter.model.Tile;

public class Main {
    public static void main(String[] args) {

        NonRoadTile nonRoadTile = new NonRoadTile();
        RoadTile roadTile = new RoadTile();
        Game game = new Game();
        for(int i = 0; i <game.getRadky();++i)
        {
            for(int j = 0; j < game.getSloupce();++j)
            {
                if(j==0||j==game.getSloupce()-1)    // j = sloupec
                {
                    game.setTileOnMap(i,j,nonRoadTile);
                }
                else
                {
                    game.setTileOnMap(i,j,roadTile);
                }
            }
        }

        Tile[][]map = game.getMap();

        for(int i = 0; i <game.getRadky();++i)
        {
            for(int j = 0; j < game.getSloupce();++j)
            {
                System.out.print(map[i][j].toString());
            }
            System.out.println();
        }
    }
}
