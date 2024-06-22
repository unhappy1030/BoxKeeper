package Test1;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private Map map;
    private BufferedImage playerImage;
    private BufferedImage monsterImage;
    private int playerX = 150;
    private int playerY = 200;
    private int monsterX = 300;
    private int monsterY = 300;
    private static final int PLAYER_SIZE = 40;

    public GamePanel() {
        setBackground(Color.BLACK);
        map = new Map("Images/map.png");
        loadImage();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                movePlayer(e);
            }
        });
        setFocusable(true);
    }

    private void loadImage() {
        try {
            playerImage = ImageIO.read(new File("Images/cat.png"));
            monsterImage = ImageIO.read(new File("Images/cat.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void movePlayer(KeyEvent e) {
        int key = e.getKeyCode();
        int newX = playerX;
        int newY = playerY;
        switch (key) {
            case KeyEvent.VK_LEFT:
                newX = playerX - 5;
                break;
            case KeyEvent.VK_RIGHT:
                newX = playerX + 5;
                break;
            case KeyEvent.VK_UP:
                newY = playerY - 5;
                break;
            case KeyEvent.VK_DOWN:
                newY = playerY + 5;
                break;
        }
        if (map.canMoveTo(newX, newY, PLAYER_SIZE)) {
            playerX = newX;
            playerY = newY;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.draw(g);
        drawPlayer(g);
        drawMonster(g);
    }

    private void drawPlayer(Graphics g) {
        if (playerImage != null) {
            g.drawImage(playerImage, playerX, playerY, null);
        }
    }

    private void drawMonster(Graphics g) {
        if (monsterImage != null) {
            g.drawImage(monsterImage, monsterX, monsterY, null);
        }
    }
}
