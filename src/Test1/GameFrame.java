package Test1;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("2D Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setVisible(true);
    }
}
