package BoxKeeper.MainGame;

import BoxKeeper.Menu.StartMenu;
import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;

public class MainFrame {
    private JFrame frame;
    private KeyInputManager keyInputManager;

    public MainFrame(){
        frame = new JFrame("BoxKeeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        keyInputManager = new KeyInputManager();
    }

    public void Start(){
        StartMenu startMenu = new StartMenu();
        startMenu.initStartPanel();//setting StartMenu
        startMenu.setStartMenuListener(new StartMenu.StartMenuListener() {
            @Override
            public void onStartGame() {
                // 게임 시작 로직 수행
                System.out.println("Game is starting...");
                switchToGamePanel();
            }
        });
        frame.setContentPane(startMenu.getPanel()); // add panel on the MainFrame
        frame.setVisible(true);//Turn on the Frame
    }

    private void switchToGamePanel() {
        MainPanel mainPanel = new MainPanel(keyInputManager);
        frame.setContentPane(mainPanel.getLayeredPane()); // Set the new panel
        frame.pack(); // Adjust the frame size to fit the new panel
        frame.setLocationRelativeTo(null); // Re-center the frame on the screen
        frame.addKeyListener(keyInputManager);

        // 포커스 설정
        frame.requestFocusInWindow();
    }

}
