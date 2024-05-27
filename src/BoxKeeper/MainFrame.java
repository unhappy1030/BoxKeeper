package BoxKeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class MainFrame {
    private JFrame frame;

    public MainFrame(){
        frame = new JFrame("BoxKeeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
    }

    public void Start(){
        StartMenu startMenu = new StartMenu();
        startMenu.initStartPanel();
        startMenu.setStartMenuListener(new StartMenu.StartMenuListener() {
            @Override
            public void onStartGame() {
                // 게임 시작 로직 수행
                System.out.println("Game is starting...");
            }
        });
        frame.setContentPane(startMenu.getPanel());
        frame.setVisible(true);
    }
}
