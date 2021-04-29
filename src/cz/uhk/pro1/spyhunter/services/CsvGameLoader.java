package cz.uhk.pro1.spyhunter.services;

import cz.uhk.pro1.spyhunter.model.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class CsvGameLoader {
    // 0 rows count
    // 1 cols count
    // 2 window width pixels
    // 3 window height pixels
    // 4 timer interval ms
    // 5 car movement pixels
    // 6 car start x
    // 7 car start y
    // 8 map shift pixels per frame
    // 9 tile size pixels

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

            Image nonRoadTileImage = loadImage(nonRoadUrl);
            Tile nonRoadTile = new NonRoadTile(nonRoadTileImage);
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

            int startX = poleHlavickaInt[6];
            int startY = poleHlavickaInt[7];

            game.setCar(new Car(startX,startY, carUrl));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return game;
    }

    private Image loadImage(String url) throws IOException {
        return ImageIO.read(new URL(url));
    }
}
