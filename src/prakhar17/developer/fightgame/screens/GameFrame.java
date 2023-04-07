package prakhar17.developer.fightgame.screens;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.swing.*;

public class GameFrame extends JFrame implements GameConstants {

    public GameFrame() {
        setSize(GW, GH);
        setTitle(TITLE);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();
		add(board);
        setVisible(true);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
    }

}
