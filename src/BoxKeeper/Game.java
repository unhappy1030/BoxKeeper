package BoxKeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Game extends JPanel implements KeyListener, ActionListener {
    private int x = 50; // 캐릭터의 초기 x 위치
    private int y = 50; // 캐릭터의 초기 y 위치
    private final int speed = 5; // 캐릭터 이동 속도
    private Set<Integer> pressedKeys = new HashSet<>(); // 현재 눌러진 키들
    private Image characterImage; // 캐릭터 이미지

    public Game() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(800, 600));
        this.addKeyListener(this);

        characterImage = new ImageIcon("Images/Player.png").getImage();

        Timer timer = new Timer(1000 / 144, this); // 60 FPS로 애니메이션 타이머 설정
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 캐릭터 이미지 그리기
        if (characterImage != null) {
            g.drawImage(characterImage, x, y, this);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 50, 50); // 캐릭터를 사각형으로 그리기
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
            x -= speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            x += speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_UP)) {
            y -= speed;
        }
        if (pressedKeys.contains(KeyEvent.VK_DOWN)) {
            y += speed;
        }

        // 캐릭터가 화면 밖으로 나가지 않도록 경계 설정
        x = Math.max(0, Math.min(x, getWidth() - 50));
        y = Math.max(0, Math.min(y, getHeight() - 50));

        repaint(); // 화면을 다시 그립니다.
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Movement");
        Game characterMovement = new Game();
        frame.add(characterMovement);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
