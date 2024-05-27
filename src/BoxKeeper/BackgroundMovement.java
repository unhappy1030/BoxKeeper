package BoxKeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class BackgroundMovement extends JPanel implements KeyListener, ActionListener {
    private int bgX = 0; // 배경의 초기 x 위치
    private int bgY = 0; // 배경의 초기 y 위치
    private final int speed = 5; // 배경 이동 속도
    private Set<Integer> pressedKeys = new HashSet<>(); // 현재 눌러진 키들
    private Image backgroundImage; // 배경 이미지
    private Image playerImage; // 플레이어 이미지
    private Image monsterImage; // 몬스터 이미지
    private int monsterX = 300; // 몬스터의 초기 x 위치
    private int monsterY = 200; // 몬스터의 초기 y 위치

    public BackgroundMovement() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(1000, 600));
        this.addKeyListener(this);

        // 배경 이미지 로드
        backgroundImage = new ImageIcon("Images/Background/resize/country-platform-back.png").getImage();
        // 플레이어 이미지 로드
        playerImage = new ImageIcon("Images/Player.png").getImage();
        // 몬스터 이미지 로드
        monsterImage = new ImageIcon("Images/cat.png").getImage();

        Timer timer = new Timer(1000 / 60, this); // 60 FPS로 애니메이션 타이머 설정
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 배경 그리기
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, bgX, bgY, this);
        }

        // 플레이어 그리기
        if (playerImage != null) {
            int playerX = (getWidth() - playerImage.getWidth(this)) / 2;
            int playerY = (getHeight() - playerImage.getHeight(this)) / 2;
            g.drawImage(playerImage, playerX, playerY, this);
        }

        // 몬스터 그리기
        if (monsterImage != null) {
            g.drawImage(monsterImage, monsterX + bgX, monsterY + bgY, this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 키가 타이핑되었을 때 처리할 내용이 없으므로 비워둡니다.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) {
            bgX += speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            bgX -= speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_UP)) {
            bgY += speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_DOWN)) {
            bgY -= speed;
        }

        repaint(); // 화면을 다시 그립니다.
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Background Movement");
        BackgroundMovement backgroundMovement = new BackgroundMovement();
        frame.add(backgroundMovement);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
