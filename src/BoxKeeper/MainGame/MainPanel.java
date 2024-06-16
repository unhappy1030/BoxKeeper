package BoxKeeper.MainGame;

import BoxKeeper.MainGame.Background.Back;
import BoxKeeper.MainGame.Background.Front;
import BoxKeeper.MainGame.Background.Monster;
import BoxKeeper.MainGame.KeyInput.KeyInputManager;
import BoxKeeper.MainGame.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPanel{
    private final JLayeredPane layeredPane;

    private final KeyInputManager keyInputManager;

    private final Player player;
    private final Back back;
    private final Front front;

    private ArrayList<Monster> monsters;

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
        player.setBounds(0, 0, 1000, 600);
        player.setOpaque(false);

        monsters = new ArrayList<>();
        monsters.add(new Monster(keyInputManager));

        InteractionManager.setPlayer(player);
        InteractionManager.setFront(front);
        InteractionManager.setMonsters(monsters);

        for(Monster monster : monsters){
            monster.setBounds(0, 0, 1000, 600);
            monster.setOpaque(false);
            layeredPane.add(monster, Integer.valueOf(3));
        }
        layeredPane.add(back, Integer.valueOf(0));
        layeredPane.add(front, Integer.valueOf(1));
        layeredPane.add(player, Integer.valueOf(2));

    }

    public JLayeredPane getLayeredPane(){
        return layeredPane;
    }


}
