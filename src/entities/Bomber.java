package entities;

import gameplay.BombermanGame;
import graphics.Sprite;
import javafx.scene.image.Image;


public class Bomber extends Entity {
    public boolean goNorth;
    public boolean goSouth;
    public boolean goWest;
    public boolean goEast;
    private int east, west, north, south;
    private int speed = 1;
    private int sizeOfBoom = 2;
    private int lengthOfBoom = 1;
    private int heart = 3;

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public int getSizeOfBoom() {
        return sizeOfBoom;
    }

    public void setSizeOfBoom(int sizeOfBoom) {
        this.sizeOfBoom = sizeOfBoom;
    }

    public int getLocationX() {
        return (x + 11) / Sprite.SCALED_SIZE;
    }

    public int getLocationY() {
        return (y + 16) / Sprite.SCALED_SIZE;
    }

    public int getLengthOfBoom() {
        return lengthOfBoom;
    }

    public void setLengthOfBoom(int lengthOfBoom) {
        this.lengthOfBoom = lengthOfBoom;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public void goEast() {
        east++;
        west = 0;
        north = 0;
        south = 0;
        //boolean inBoom = checkInBoom();
        boolean checkImg = false;
        x += speed;
        if (y % Sprite.SCALED_SIZE == 0) {
            int X = (x + 24) / Sprite.SCALED_SIZE;
            int Y = y / Sprite.SCALED_SIZE;
            if (BombermanGame.map[Y].charAt(X) == '#'
                    || BombermanGame.map[Y].charAt(X) == '*'
                    || BombermanGame.map[Y].charAt(X) == 'B') {
                if (BombermanGame.map[Y].charAt(X) == 'B') {

                } else {
                    checkImg = true;
                    x = X * Sprite.SCALED_SIZE - 24;
                }
            }
        } else {
            int X = (x + 24) / Sprite.SCALED_SIZE;
            int Y1 = (y + 5) / Sprite.SCALED_SIZE;
            int Y2 = y / Sprite.SCALED_SIZE;
            int Y3 = (y + 27) / Sprite.SCALED_SIZE;
            int Y4 = (y + 32) / Sprite.SCALED_SIZE;
            if (BombermanGame.map[Y2].charAt(X) == '#'
                    || BombermanGame.map[Y2].charAt(X) == '*'
                    || BombermanGame.map[Y2].charAt(X) == 'B') {
                if (BombermanGame.map[Y2].charAt(X) == 'B') {

                } else if (BombermanGame.map[Y1].charAt(X) != '#'
                        && BombermanGame.map[Y1].charAt(X) != '*'
                        && BombermanGame.map[Y1].charAt(X) != 'B') {
                    y = Y1 * Sprite.SCALED_SIZE;
                } else {
                    checkImg = true;
                    x = X * Sprite.SCALED_SIZE - 24;
                }
            } else if (BombermanGame.map[Y4].charAt(X) == '#'
                    || BombermanGame.map[Y4].charAt(X) == '*'
                    || BombermanGame.map[Y4].charAt(X) == 'B') {
                if (BombermanGame.map[Y4].charAt(X) == 'B') {

                } else if (BombermanGame.map[Y3].charAt(X) != '#'
                        && BombermanGame.map[Y3].charAt(X) != '*'
                        && BombermanGame.map[Y3].charAt(X) != 'B') {
                    y = Y3 * Sprite.SCALED_SIZE;
                } else {
                    x = X * Sprite.SCALED_SIZE - 24;
                }
            }
        }
        if (checkImg) {
            img = Sprite.player_right.getFxImage();
        } else {
            img = Sprite.movingSprite(Sprite.player_right_1,
                    Sprite.player_right_2, east, 30).getFxImage();
        }
    }

    public void goWest() {
        east = 0;
        west++;
        north = 0;
        south = 0;
        //boolean inBoom = checkInBoom();
        boolean checkImg = false;
        x -= speed;
        if (y % Sprite.SCALED_SIZE == 0) {
            int X = x / Sprite.SCALED_SIZE;
            int Y = y / Sprite.SCALED_SIZE;
            if (BombermanGame.map[Y].charAt(X) == '#'
                    || BombermanGame.map[Y].charAt(X) == '*'
                    || BombermanGame.map[Y].charAt(X) == 'B') {
                if (BombermanGame.map[Y].charAt(X) == 'B') {

                } else {
                    checkImg = true;
                    x = (X + 1) * Sprite.SCALED_SIZE;
                }
            }
        } else {
            int X = x / Sprite.SCALED_SIZE;
            int Y1 = (y + 5) / Sprite.SCALED_SIZE;
            int Y2 = y / Sprite.SCALED_SIZE;
            int Y3 = (y + 27) / Sprite.SCALED_SIZE;
            int Y4 = (y + 32) / Sprite.SCALED_SIZE;
            if (BombermanGame.map[Y2].charAt(X) == '#'
                    || BombermanGame.map[Y2].charAt(X) == '*'
                    || BombermanGame.map[Y2].charAt(X) == 'B') {
                if (BombermanGame.map[Y2].charAt(X) == 'B') {

                } else if (BombermanGame.map[Y1].charAt(X) != '#'
                        && BombermanGame.map[Y1].charAt(X) != '*'
                        && BombermanGame.map[Y1].charAt(X) != 'B') {
                    y = Y1 * Sprite.SCALED_SIZE;
                } else {
                    checkImg = true;
                    x = (X + 1) * Sprite.SCALED_SIZE;
                }
            } else if (BombermanGame.map[Y4].charAt(X) == '#'
                    || BombermanGame.map[Y4].charAt(X) == '*'
                    || BombermanGame.map[Y4].charAt(X) == 'B') {
                if (BombermanGame.map[Y4].charAt(X) == 'B') {

                } else if (BombermanGame.map[Y3].charAt(X) != '#'
                        && BombermanGame.map[Y3].charAt(X) != '*'
                        && BombermanGame.map[Y3].charAt(X) != 'B') {
                    y = Y3 * Sprite.SCALED_SIZE;
                } else {
                    x = (X + 1) * Sprite.SCALED_SIZE;
                }
            }
        }
        if (checkImg) {
            img = Sprite.player_left.getFxImage();
        } else {
            img = Sprite.movingSprite(Sprite.player_left_1,
                    Sprite.player_left_2, west, 30).getFxImage();
        }
    }

    public void goNorth() {
        east = 0;
        west = 0;
        north++;
        south = 0;
        //boolean inBoom = checkInBoom();
        boolean checkImg = false;
        y -= speed;
        int X1 = x / Sprite.SCALED_SIZE;
        int X2 = (x + 23) / Sprite.SCALED_SIZE;
        int Y = y / Sprite.SCALED_SIZE;
        if (BombermanGame.map[Y].charAt(X1) == '#'
                || BombermanGame.map[Y].charAt(X1) == '*'
                || BombermanGame.map[Y].charAt(X1) == 'B'
                || BombermanGame.map[Y].charAt(X2) == '#'
                || BombermanGame.map[Y].charAt(X2) == '*'
                || BombermanGame.map[Y].charAt(X2) == 'B') {
            if ((BombermanGame.map[Y].charAt(X1) == 'B' || BombermanGame.map[Y].charAt(X2) == 'B')
            ) {

            } else {
                y = (Y + 1) * Sprite.SCALED_SIZE;
                checkImg = true;
            }
        }
        if (checkImg) {
            img = Sprite.player_up.getFxImage();
        } else {
            img = Sprite.movingSprite(Sprite.player_up_1,
                    Sprite.player_up_2, north, 30).getFxImage();
        }
    }

    public void goSouth() {
        east = 0;
        west = 0;
        north = 0;
        south++;
        //boolean inBoom = checkInBoom();
        boolean checkImg = false;
        y += speed;
        int X1 = x / Sprite.SCALED_SIZE;
        int X2 = (x + 23) / Sprite.SCALED_SIZE;
        int Y = (y + 32) / Sprite.SCALED_SIZE;
        if (BombermanGame.map[Y].charAt(X1) == '#'
                || BombermanGame.map[Y].charAt(X1) == '*'
                || BombermanGame.map[Y].charAt(X1) == 'B'
                || BombermanGame.map[Y].charAt(X2) == '#'
                || BombermanGame.map[Y].charAt(X2) == '*'
                || BombermanGame.map[Y].charAt(X2) == 'B') {
            if ((BombermanGame.map[Y].charAt(X1) == 'B' || BombermanGame.map[Y].charAt(X2) == 'B')) {

            } else {
                y = Y * Sprite.SCALED_SIZE - 32;
                checkImg = true;
            }
        }
        if (checkImg) {
            img = Sprite.player_down.getFxImage();
        } else {
            img = Sprite.movingSprite(Sprite.player_down_1,
                    Sprite.player_down_2, south, 30).getFxImage();
        }
    }

    @Override
    public void update() {
        if (goEast) {
            goEast();
        } else if (goWest) {
            goWest();
        } else if (goNorth) {
            goNorth();
        } else if (goSouth) {
            goSouth();
        } else {
            if (east > 0) img = Sprite.player_right.getFxImage();
            else if (west > 0) img = Sprite.player_left.getFxImage();
            else if (north > 0) img = Sprite.player_up.getFxImage();
            else if (south > 0) img = Sprite.player_down.getFxImage();
        }
    }
}
