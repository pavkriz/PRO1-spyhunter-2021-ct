package cz.uhk.pro1.spyhunter.services;

import cz.uhk.pro1.spyhunter.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvGameLoader {
    // rows count
    // cols count
    // window width pixels
    // window height pixels
    // timer interval ms
    // car movement pixels
    // car start x
    // car start y
    // map shift pixels per frame
    // tile size pixels

    public Game loadGame() {
        Game game = new Game();

        try (BufferedReader br = new BufferedReader(new FileReader("map.csv"))) {
            String line = br.readLine();
            String pole[] = line.split(";");
            int poleHlavickaInt[] = new int[pole.length];
            for (int i = 0; i < pole.length; i++){
                poleHlavickaInt[i] = Integer.parseInt(pole[i]);
            }

            line = br.readLine();
            String carUrl = line.split(";")[0];

            line = br.readLine();
            String nonRoadUrl = line.split(";")[0];

            line = br.readLine();
            String roadURL = line.split(";")[0];

            line = br.readLine();
            String powerUpTileUrl = line.split(";")[0];


            Tile nonRoadTile = new NonRoadTile();
            Tile powerUpTile = new PowerUpTile();
            Tile roadTile = new RoadTile();

            for (int i = 0 ; i < poleHlavickaInt[0]; i++){
                line = br.readLine();
                String poleCharu[] = line.split(";");

                for (int j = 0; j < poleHlavickaInt[1]; j++){
                    if (poleCharu[j].equals("#")){
                        game.setTileOnMap(i,j, nonRoadTile);
                    }else if(poleCharu[j].equals("@")){
                        game.setTileOnMap(i,j, powerUpTile);
                    }else{
                        game.setTileOnMap(i,j, roadTile);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return game;
    }
}
