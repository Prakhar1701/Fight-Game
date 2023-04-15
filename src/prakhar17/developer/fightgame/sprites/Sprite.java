package prakhar17.developer.fightgame.sprites;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Sprite implements GameConstants {

    protected int x, y, w, h;
    protected BufferedImage bi;
    protected int speed;
    protected int currentMove;
    protected int index;

    public BufferedImage getSpriteImage() {
        return bi;
    }

    public Sprite() throws IOException {
        bi = ImageIO.read(Player.class.getResource("sprite.gif"));
        w = 150;
        h = 150;
        y = FLOOR - h;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(int currentMove) {
        this.currentMove = currentMove;
        index = 0;
    }

    public void move() {
        x = x + speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void printSprite(Graphics pen);
}
