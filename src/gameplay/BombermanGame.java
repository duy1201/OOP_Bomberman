package gameplay;

import entities.*;
import graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import loadmap.LoadMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    public static int WIDTH = 31;
    public static int HEIGHT = 13;
    public static String[] map;
    public static int time = 18000;
    public static Bomber player1;
    private static GraphicsContext gc;
    private int level = 1;
    private List<Brick> brickObjects = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private Canvas canvas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        createMap("res/levels/Level1.txt");
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        stage.setResizable(false);
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
                // update();
              /*  if (time == 18000) {
                    levelText.setText("LEVEL " + level);
                }*/
                // timeText.setText("TIME " + time/60);
                --time;
            }
        };
        timer.start();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    player1.goNorth = true;
                    break;
                case DOWN:
                    player1.goSouth = true;
                    break;
                case LEFT:
                    player1.goWest = true;
                    break;
                case RIGHT:
                    player1.goEast = true;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:
                    player1.goNorth = false;
                    break;
                case DOWN:
                    player1.goSouth = false;
                    break;
                case LEFT:
                    player1.goWest = false;
                    break;
                case RIGHT:
                    player1.goEast = false;
                    break;
            }
        });
    }


    public void createMap(String input) {
        map = LoadMap.loadMap(input);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                Entity objectEntity;
                if (map[j].charAt(i) == '#') {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                    stillObjects.add(object);
                } else if (map[j].charAt(i) == '*') {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    objectEntity = new Brick(i, j, Sprite.brick.getFxImage());
                    brickObjects.add((Brick) objectEntity);
                } else if (map[j].charAt(i) == 'p') {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    objectEntity = new Bomber(i, j, Sprite.player_right.getFxImage());
                    player1 = (Bomber) objectEntity;
                    //startX = i; startY = j;
                } else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                }
            }
        }
    }

    public void update() {
        player1.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        stillObjects.forEach(g -> g.render(gc));
        brickObjects.forEach(g -> g.render(gc));
        player1.render(gc);
    }
}
