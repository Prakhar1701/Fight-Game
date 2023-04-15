package prakhar17.developer.fightgame.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Sprite {

    private BufferedImage walkImages[] = new BufferedImage[2];
    private BufferedImage kickImages[] = new BufferedImage[3];
    private int force;
    private boolean isJumping;

    public Player() throws Exception {
//        super();
        x = 100;
        speed = 0;
        force = 0;
        currentMove = WALK;
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


    private BufferedImage showWalkPlayer() {
        if (index > 1) index = 0;

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

    @Override
    public void printSprite(Graphics pen) {
        if (currentMove == WALK) {
            pen.drawImage(showWalkPlayer(), x, y, w, h, null);
        } else if (currentMove == KICK) {
            pen.drawImage(showPlayerKick(), x, y, w, h, null);
        }
    }
}
