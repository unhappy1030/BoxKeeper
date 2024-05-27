package BoxKeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Back extends JPanel implements ActionListener{
    private int bgX = 0; // 배경의 초기 x 위치
    private int bgY = 0; // 배경의 초기 y 위치
    private final int speed = 1; // 배경 이동 속도
    private Image backgroundImage; // 배경 이미지

    public Back() {
        this.setPreferredSize(new Dimension(1000, 600));

        // 배경 이미지 로드
        backgroundImage = new ImageIcon("Images/Background/resize/country-platform-back.png").getImage();

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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // 화면을 다시 그립니다.
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Background Movement");
        Back back = new Back();
        frame.add(back);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
