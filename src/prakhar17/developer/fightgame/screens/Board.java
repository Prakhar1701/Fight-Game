package prakhar17.developer.fightgame.screens;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements GameConstants {

    public Board() {}

    @Override
    public void paintComponent(Graphics pen) { //Automatically Called //Part Of Life Cycle
        super.paintComponent(pen); //Clean
        printBG(pen);
    }

    private void printBG(Graphics pen) {
        pen.setColor(Color.red);
        pen.fillRect(0, 0, GW, GH);
        System.out.println("prakhar");
    }
}
