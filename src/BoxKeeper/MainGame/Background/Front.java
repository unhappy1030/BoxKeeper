package BoxKeeper.MainGame.Background;

import BoxKeeper.MainGame.InteractionManager;
import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Front extends JPanel implements ActionListener{
    private final KeyInputManager keyInputManager;

    private double bgX = 0;
    private final double speed = 2;
    private final Image frontImage;
    private final int numImages = 3;
    private final int maxBgX;

    public Front(KeyInputManager keyInputManager) {
        this.keyInputManager = keyInputManager;


        this.setPreferredSize(new Dimension(1000, 600));

        // 배경 이미지 로드
        frontImage = new ImageIcon("Images/Background/resize/country-platform-tiles-example.png").getImage();
        int width = frontImage.getWidth(this);

        // 최대 이동 범위 설정
        maxBgX = width * (numImages - 1);

        Timer timer = new Timer(1000/144, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (frontImage != null) {
            int width = frontImage.getWidth(this);
            int height = frontImage.getHeight(this);

            for (int i = 0; i < numImages; i++) {
                int x = (int) (bgX + i * width);
                g.drawImage(frontImage, x, -100, width, height, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT) && bgX < 0) {
            bgX += speed;
            InteractionManager.moveMonsters((int)speed);
        }
        if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT) && bgX > maxBgX * -1) {
            bgX -= speed;
            InteractionManager.moveMonsters((int)(speed * -1));
        }
        repaint();
        InteractionManager.setMonsterDir();
    }
}
