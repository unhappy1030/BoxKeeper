package BoxKeeper.MainGame.Background;

import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Monster extends JPanel implements ActionListener {
    private final KeyInputManager keyInputManager;
    private int position;
    private int speed;
    private static int direction;
    private final Random random;

    private final Image monsterImage;

    public Monster(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        setPreferredSize(new Dimension(64,64));
        this.monsterImage = new ImageIcon("Images/Player/defaultL.png").getImage();
        random = new Random();

        speed = 2;

        // 몬스터가 화면 밖에서 생성되도록 설정
        if (random.nextBoolean()) {
            // 왼쪽 밖에서 생성
            this.position = -monsterImage.getWidth(null);
        } else {
            // 오른쪽 밖에서 생성
            this.position = 1000;
        }

        Timer timer = new Timer(1000 / 10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        position += direction * speed;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(monsterImage, position, 450, this);
    }

    public static void setDirection(boolean dir){
        direction = dir ? 1 : -1;
    }

    public void update(){
        actionPerformed(null);
    }
}
