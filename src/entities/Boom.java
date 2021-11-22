package entities;

import gameplay.BombermanGame;
import graphics.Sprite;
import javafx.scene.image.Image;

public class Boom extends Entity{
    private int timing;

    public Boom(int x, int y, Image img) {
        super(x, y, img);
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public int getTiming() {
        return timing;
    }

    @Override
    public void update() {
        timing++;
        if (timing >= 190) {
            img = Sprite.bomb_exploded2.getFxImage();
        } else if (timing >= 185) {
            img = Sprite.bomb_exploded1.getFxImage();
        } else if (timing >= 180) {
            img = Sprite.bomb_exploded.getFxImage();
            //if (timing == 180) Sound.play("BOM_11_M");
        } else if (timing % 30 == 0) {
            img = Sprite.bomb.getFxImage();
        } else if (timing % 30 == 10) {
            img = Sprite.bomb_1.getFxImage();
        } else if (timing % 30 == 20) {
            img = Sprite.bomb_2.getFxImage();
        }
        if (timing == 1) {
            int X = x / Sprite.SCALED_SIZE;
            int Y = y / Sprite.SCALED_SIZE;
            BombermanGame.map[Y] = BombermanGame.map[Y].substring(0, X) + "B"
                    + BombermanGame.map[Y].substring(X + 1);
        }
        if (timing == 189) {
            int X = x / Sprite.SCALED_SIZE;
            int Y = y / Sprite.SCALED_SIZE;
            BombermanGame.map[Y] = BombermanGame.map[Y].substring(0, X) + " "
                    + BombermanGame.map[Y].substring(X + 1);
        }
    }
}
