package prakhar17.developer.fightgame.sprites;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements GameConstants {
    private int x, y, w, h;
    BufferedImage bi;
    private int speed;
    private BufferedImage walkImages[] = new BufferedImage[4];
    private int index = 0;

    public Player() throws Exception {
        x = 100;
        y = FLOOR;
        w = 150;
        h = 150;
        bi = ImageIO.read(Player.class.getResource("sprite.gif"));
        speed = 0;
        loadWalk();
    }

    private void loadWalk() {
        walkImages[0] = bi.getSubimage(211, 5, 24, 44);
        walkImages[1] = bi.getSubimage(235, 2, 18, 49);
        walkImages[2] = bi.getSubimage(258, 2, 23, 48);
        walkImages[3] = bi.getSubimage(284, 5, 20, 46);
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

    private BufferedImage showWalkPlayer() {
        if (index > 3) index = 0;
        BufferedImage img = walkImages[index];
        index++;
        return img;
    }

    public void paintPlayer(Graphics pen) {
        pen.drawImage(showWalkPlayer(), x, y, w, h, null);
    }
}
