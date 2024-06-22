package BoxKeeper.MainGame.Player;

import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Player extends JPanel implements ActionListener{
    private final KeyInputManager keyInputManager;

    private int posX;
    private int posY;
    private final int speed = 10;

    private final Image walkRight1;
    private final Image walkRight2;
    private final Image walkLeft1;
    private final Image walkLeft2;
    private final Image defaultRImage;
    private final Image defaultLImage;
    private int currentRightImageIndex = 1;
    private int currentLeftImageIndex = 1;
    private boolean lastDirectionRight = true;

    public Player(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        setPreferredSize(new Dimension(64,64));

        walkRight1 = new ImageIcon("Images/Player/right1.png").getImage();
        walkRight2 = new ImageIcon("Images/Player/right2.png").getImage();

        walkLeft1 = new ImageIcon("Images/Player/left1.png").getImage();
        walkLeft2 = new ImageIcon("Images/Player/left2.png").getImage();

        defaultRImage = new ImageIcon("Images/Player/defaultR.png").getImage();
        defaultLImage = new ImageIcon("Images/Player/defaultL.png").getImage();

        posX = 200;
        posY = 450;

        Timer timer = new Timer(1000/10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT)) {
            currentLeftImageIndex = (currentLeftImageIndex == 1) ? 2 : 1;
            lastDirectionRight = false;
        } else if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT)) {
            currentRightImageIndex = (currentRightImageIndex == 1) ? 2 : 1;
            lastDirectionRight = true;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT)) {
            if (currentLeftImageIndex == 1) {
                g.drawImage(walkLeft1, posX, posY, this);
            } else {
                g.drawImage(walkLeft2, posX, posY, this);
            }
        } else if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (currentRightImageIndex == 1) {
                g.drawImage(walkRight1, posX, posY, this);
            } else {
                g.drawImage(walkRight2, posX, posY, this);
            }
        } else {
            if (lastDirectionRight) {
                g.drawImage(defaultRImage, posX, posY, this);
            } else {
                g.drawImage(defaultLImage, posX, posY, this);
            }
        }
    }

    public int getPosX() {return posX;}

    public int getCenter(){return posX + 32;}
}