package prakhar17.developer.fightgame.screens;

import prakhar17.developer.fightgame.sprites.Enemy;
import prakhar17.developer.fightgame.sprites.Player;
import prakhar17.developer.fightgame.utils.EnemyTypeCoordinates;
import prakhar17.developer.fightgame.utils.GameConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel implements GameConstants {
    BufferedImage backgroundImage;
    BufferedImage partOfImage;
    private Player player;
    private Enemy enemy;
    private Timer timer;

    public Board() throws Exception {
        loadBackgroundImage();

        player = new Player();

        enemy = new Enemy(EnemyTypeCoordinates.handAttackEnemy);
        EnemyTypeCoordinates.loadHandAttackEnemy(enemy.getSpriteImage());
        EnemyTypeCoordinates.loadBatAttackEnemy(enemy.getSpriteImage());
        EnemyTypeCoordinates.loadKnifeAttackEnemy(enemy.getSpriteImage());

        setFocusable(true);
        bindEvents();
        gameLoop();
    }

    private void gameLoop() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                player.fall();
            }
        });
        timer.start();
    }

    private void bindEvents() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setSpeed(-7);
                    player.move();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setSpeed(7);
                    player.move();
                } else if (e.getKeyCode() == KeyEvent.VK_K) {
                    player.setCurrentMove(KICK);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    player.jump();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.setSpeed(0);
            }
        });
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(Board.class.getResource("game-bg.png"));
            partOfImage = backgroundImage.getSubimage(0, 0, 650, 200);
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
        player.printSprite(pen);
        enemy.printSprite(pen);
    }

    private void printBG(Graphics pen) {
        pen.drawImage(partOfImage, 0, 0, GW, GH, null);
    }
}
