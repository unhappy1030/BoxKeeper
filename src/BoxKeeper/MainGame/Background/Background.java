package BoxKeeper.MainGame.Background;

import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background extends JPanel implements ActionListener {
    private KeyInputManager keyInputManager;
    private Back back;
    private Front front;

    public Background(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        back = new Back(keyInputManager);
        front = new Front(keyInputManager);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // 화면을 다시 그립니다.
    }

    public void update(){

    }
}
