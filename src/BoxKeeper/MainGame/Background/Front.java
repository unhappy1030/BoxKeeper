package BoxKeeper.MainGame.Background;

import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Front extends JPanel implements ActionListener {
    private final KeyInputManager keyInputManager;
    private double bgX = 0; // 배경의 초기 x 위치
    private final double speed = 2; // 배경 이동 속도
    private final Image frontImage; // 배경 이미지

    public Front(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        this.setPreferredSize(new Dimension(1000, 600));

        // 배경 이미지 로드
        frontImage = new ImageIcon("Images/Background/resize/country-platform-tiles-example.png").getImage();

        Timer timer = new Timer(1000 / 144, this); // 60 FPS로 애니메이션 타이머 설정
        timer.start();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 배경 그리기
        if (frontImage != null) {
            // 배경을 반복해서 그리기
            int width = frontImage.getWidth(this);
            int height = frontImage.getHeight(this);

            for (int x = (int) bgX; x < getWidth(); x += width) {
                g.drawImage(frontImage, x, -100, width, height, this);
            }
            for (int x = (int) bgX - width; x > -width; x -= width) {
                g.drawImage(frontImage, x, -100, width, height, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT)) {
            bgX += speed;
        }
        if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT)) {
            bgX -= speed;
        }
        repaint(); // 화면을 다시 그립니다.
    }
}
