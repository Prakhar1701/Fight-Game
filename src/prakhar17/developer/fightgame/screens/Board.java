package prakhar17.developer.fightgame.screens;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel implements GameConstants {
    BufferedImage backgroundImage;

    public Board() {
        loadBackgroundImage();
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(Board.class.getResource("night_war_background.jpeg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to load background...");
            System.out.println(e);
            System.exit(0);
        }
    }

    @Override
    public void paintComponent(Graphics pen) { //Automatically Called //Part Of Life Cycle
        super.paintComponent(pen); //Clean
        printBG(pen);
    }

    private void printBG(Graphics pen) {
        pen.drawImage(backgroundImage, 0, 0, GW, GH, null);
    }
}
