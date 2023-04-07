package prakhar17.developer.fightgame.sprites;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements GameConstants {
    private int x, y, w, h;
    BufferedImage bi;

    public Player() throws Exception {
        x = 100;
        y = FLOOR;
        w = 150;
        h = 150;
        bi = ImageIO.read(Player.class.getResource("sprite.gif"));
    }

    private BufferedImage showPlayer() {
        return bi.getSubimage(211, 5, 24, 44);
    }

    public void paintPlayer(Graphics pen) {
        pen.drawImage(showPlayer(), x, y, w, h, null);
    }
}
