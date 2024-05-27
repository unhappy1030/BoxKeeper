package SwingTest;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("SwingTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // 적절한 크기로 설정하세요
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // GamePanel을 생성하여 JFrame에 추가
        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel); // getContentPane()를 통해 content pane에 추가

        setVisible(true); // JFrame을 표시하기 위해 setVisible을 마지막에 호출
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });
    }
}
