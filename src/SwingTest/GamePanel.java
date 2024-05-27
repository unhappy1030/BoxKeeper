package SwingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private int characterX = 100;
    private int characterY = 400;
    private int characterVelocityX = 0; // 캐릭터의 X축 속도
    private int characterVelocityY = 0; // 캐릭터의 Y축 속도
    private final int CHARACTER_SPEED = 5; // 캐릭터의 이동 속도
    private Image characterImage;

    public GamePanel() {
        setBackground(Color.WHITE);
        setFocusable(true);
        loadCharacterImage(); // 캐릭터 이미지 로드
        timer = new Timer(1000 / 30, this); // 타이머 설정 (60프레임으로 제한)
        timer.start(); // 타이머 시작
        addKeyListener(new GameKeyListener());
    }

    private void loadCharacterImage() {
        ImageIcon ii = new ImageIcon("Images/cat.png"); // 이미지 파일 경로에 맞게 변경하세요
        characterImage = ii.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCharacter(g);
    }

    private void drawCharacter(Graphics g) {
        g.drawImage(characterImage, characterX, characterY, this);
    }

    private void moveCharacter() {
        characterX += characterVelocityX; // 캐릭터의 X 위치 업데이트
        characterY += characterVelocityY; // 캐릭터의 Y 위치 업데이트
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCharacter(); // 캐릭터 이동
        repaint(); // 화면 다시 그리기
    }

    private class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            // 키 입력에 따라 캐릭터의 속도를 조정할 수 있습니다.
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                characterVelocityX = -CHARACTER_SPEED; // 왼쪽으로 이동
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                characterVelocityX = CHARACTER_SPEED; // 오른쪽으로 이동
            }

            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                characterVelocityY = -CHARACTER_SPEED; // 위로 이동
            } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                characterVelocityY = CHARACTER_SPEED; // 아래로 이동
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            // 키를 뗄 때 캐릭터의 속도를 감속도로 설정합니다.
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                characterVelocityX = 0;
            }
            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
                characterVelocityY = 0;
            }
        }
    }
}

