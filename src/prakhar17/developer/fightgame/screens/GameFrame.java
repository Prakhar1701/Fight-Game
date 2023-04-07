package prakhar17.developer.fightgame.screens;

import javax.swing.JFrame;

import prakhar17.developer.fightgame.utils.GameConstants;

public class GameFrame extends JFrame implements GameConstants{

	public GameFrame() {
		setSize(GW,GH);
		setTitle(TITLE);
		setLocationRelativeTo(null); 
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
	}

}
