package prakhar17.developer.fightgame.sprites;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements GameConstants {
    private int x, y, w, h;
    BufferedImage bi;
    private int speed;
    private BufferedImage walkImages[] = new BufferedImage[2];
    private BufferedImage kickImages[] = new BufferedImage[3];
    private int index = 0;
    private int currentMove = WALK;
    private int force;
    private boolean isJumping;

    public Player() throws Exception {
        w = 150;
        h = 150;
        x = 100;
        y = FLOOR - h;

        bi = ImageIO.read(Player.class.getResource("sprite.gif"));

        speed = 0;
        force = 0;

        loadWalk();
        loadKick();
    }

    private void loadWalk() {
        walkImages[0] = bi.getSubimage(211, 5, 24, 44);
        walkImages[1] = bi.getSubimage(235, 2, 18, 49);
    }

    private void loadKick() {
        kickImages[0] = bi.getSubimage(211, 50, 37, 45);
        kickImages[1] = bi.getSubimage(250, 52, 27, 40);
        kickImages[2] = bi.getSubimage(276, 56, 23, 37);
    }

    public void jump() {
        if (!isJumping) {
            force = -13;
            y = y + force;
            isJumping = true;
        }
    }

    public void fall() {
        if (y >= (FLOOR - h)) {
            isJumping = false;
            return;
        }
        force = force + GRAVITY;
        y = y + force;
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

    public int getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(int currentMove) {
        this.currentMove = currentMove;
        index = 0;
    }

    private BufferedImage showWalkPlayer() {
        if (index > 1) index = 0;

//        try {
//            Thread.sleep(40);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        BufferedImage img = walkImages[index];
        index++;
        return img;
    }

    private BufferedImage showPlayerKick() {
        if (index > 2) {
            index = 0;
            currentMove = WALK;
        }
        BufferedImage img = kickImages[index];
        index++;
        return img;
    }

    public void paintPlayer(Graphics pen) {
        if (currentMove == WALK) {
            pen.drawImage(showWalkPlayer(), x, y, w, h, null);
        } else if (currentMove == KICK) {
            pen.drawImage(showPlayerKick(), x, y, w, h, null);
        }
    }
}
