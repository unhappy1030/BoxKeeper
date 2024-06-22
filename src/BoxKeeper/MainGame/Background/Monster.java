package BoxKeeper.MainGame.Background;

import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Monster extends JPanel implements ActionListener{
    private final KeyInputManager keyInputManager;
    private int position;
    private int speed;
    private int direction;
    private final Random random;

    private final Image[] rightImages;
    private final Image[] leftImages;
    private final Image[] attackLeftImages;
    private final Image[] attackRightImages;
    private int currentImageIndex;
    private int attackImageIndex;
    private boolean movingRight;
    private boolean isAttack;

    public Monster(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        setPreferredSize(new Dimension(64,64));

        // Load images
        rightImages = new Image[4];
        leftImages = new Image[4];

        attackRightImages = new Image[8];
        attackLeftImages = new Image[8];

        for (int i = 0; i < 4; i++) {
            rightImages[i] = new ImageIcon("Images/Monster/walk/right" + (i+1) + ".png").getImage();
            leftImages[i] = new ImageIcon("Images/Monster/walk/left" + (i+1) + ".png").getImage();
        }
        for (int i = 0; i < 8; i++){
            attackRightImages[i] = new ImageIcon("Images/Monster/attack/attackR" + (i+1) + ".png").getImage();
            attackLeftImages[i] = new ImageIcon("Images/Monster/attack/attackL" + (i+1) + ".png").getImage();
        }

        random = new Random();
        speed = 5;
        currentImageIndex = 0;
        movingRight = random.nextBoolean();
        isAttack = false;

        if (movingRight) {
            this.position = -rightImages[0].getWidth(null);
            direction = 1;
        } else {
            this.position = 1000;
            direction = -1;
        }

        Timer timer = new Timer(1000/10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(isAttack){
            attackImageIndex = (attackImageIndex + 1) % 8;
            if(attackImageIndex == 0){
                isAttack = false;
            }
        }else{
            position += direction * speed;
            if(speed != 0){
                currentImageIndex = (currentImageIndex + 1) % 4;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image currentImage;
        if (movingRight) {
            if(isAttack){
                currentImage = attackRightImages[attackImageIndex];
            }
            else{
                currentImage = rightImages[currentImageIndex];
            }
        } else {
            if(isAttack){
                currentImage = attackLeftImages[attackImageIndex];
            }
            else{
                currentImage = leftImages[currentImageIndex];
            }
        }
        g.drawImage(currentImage, position, 275, this);
//        System.out.println("Monster X :" + position);
    }

    public void setDirection(boolean dir){
        direction = dir ? 1 : -1;
        movingRight = dir;
    }

    public void move(int value){
        position += value;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getPosition(){return position;}
    public int getCenter(){
        return position + 175;
    }

    public void attack(){
        isAttack = true;
    }
}
