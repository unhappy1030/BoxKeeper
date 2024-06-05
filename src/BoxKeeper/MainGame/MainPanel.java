package BoxKeeper.MainGame;

import BoxKeeper.MainGame.Background.Back;
import BoxKeeper.MainGame.Background.Front;
import BoxKeeper.MainGame.KeyInput.KeyInputManager;
import BoxKeeper.MainGame.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    private final JLayeredPane layeredPane;

    private final KeyInputManager keyInputManager;
//    private final Timer timer;

    private final Player player;
    private final Back back;
    private final Front front;

    public MainPanel(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 600));

        back = new Back(keyInputManager);
        back.setBounds(0, 0, 1000, 600);
        back.setOpaque(false);

        front = new Front(keyInputManager);
        front.setBounds(0, 0, 1000, 600);
        front.setOpaque(false);

        player = new Player(keyInputManager);
        player.setBounds(0, 0, 1000, 600); // Set the bounds for the player
        player.setOpaque(false);



        layeredPane.add(back, Integer.valueOf(0));
        layeredPane.add(front, Integer.valueOf(1));
        layeredPane.add(player, Integer.valueOf(2));
    }

    public JLayeredPane getLayeredPane(){
        return layeredPane;
    }
}
