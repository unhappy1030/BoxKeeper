package BoxKeeper.MainGame.Background;

import BoxKeeper.MainGame.InteractionManager;
import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Front extends JPanel implements ActionListener {
    private final KeyInputManager keyInputManager;

    private Monster monster;

    private double bgX = 0; // 배경의 초기 x 위치
    private final double speed = 2; // 배경 이동 속도
    private final Image frontImage; // 배경 이미지
    private final int numImages = 3; // 배경 이미지의 개수
    private final int maxBgX; // 배경 이동의 최대 값

    public Front(KeyInputManager keyInputManager) {
        this.keyInputManager = keyInputManager;

        monster = new Monster(keyInputManager);
        monster.setBounds(0, 0, 1000,600);
        monster.setOpaque(false);

        this.setPreferredSize(new Dimension(1000, 600));

        // 배경 이미지 로드
        frontImage = new ImageIcon("Images/Background/resize/country-platform-tiles-example.png").getImage();
        int width = frontImage.getWidth(this);

        // 최대 이동 범위 설정
        maxBgX = width * (numImages - 1);
        add(monster);
        Timer timer = new Timer(1000 / 144, this); // 60 FPS로 애니메이션 타이머 설정
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 배경 그리기
        if (frontImage != null) {
            // 배경을 5장만 이어서 그리기
            int width = frontImage.getWidth(this);
            int height = frontImage.getHeight(this);

            for (int i = 0; i < numImages; i++) {
                int x = (int) (bgX + i * width);
                g.drawImage(frontImage, x, -100, width, height, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT) && bgX < 0) {
            bgX += speed;
            InteractionManager.moveMonsters((int)speed);
        }
        if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT) && bgX > maxBgX * -1) {
            bgX -= speed;
            InteractionManager.moveMonsters((int)(speed * -1));
        }
//        System.out.println("bgX: " + bgX + "/" + (maxBgX * -1));
        repaint(); // 화면을 다시 그립니다.
        InteractionManager.setMonsterDir();
    }
}
