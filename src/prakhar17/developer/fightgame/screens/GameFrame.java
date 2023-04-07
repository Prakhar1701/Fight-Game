package prakhar17.developer.fightgame.screens;

import prakhar17.developer.fightgame.utils.GameConstants;

import javax.swing.*;

public class GameFrame extends JFrame implements GameConstants {

    public GameFrame() throws Exception {
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
        try {
            GameFrame frame = new GameFrame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
