package prakhar17.developer.fightgame.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Sprite {
    private BufferedImage[] enemyImages;

    public Enemy(BufferedImage[] enemyImages) throws Exception {
        this.enemyImages = enemyImages;
        x = GW - 250;
        currentMove = WALK;
        index = 0;
        speed = -15;
    }

    @Override
    public void printSprite(Graphics pen) {
        if (index >= enemyImages.length - 1) { //Excluding last image
            index = 0;
        }
        pen.drawImage(enemyImages[index], x, y, w, h, null);
        index++;
        move();
    }
}