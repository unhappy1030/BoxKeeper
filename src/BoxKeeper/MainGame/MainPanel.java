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

public class MainPanel extends JPanel implements ActionListener {
    private final JLayeredPane layeredPane;

    private final KeyInputManager keyInputManager;

    private int posX;

    private final Player player;
    private final Back back;
    private final Front front;

    private Timer timer;
//    private ArrayList<Monster> monsters;

    public MainPanel(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        posX = 500;

        timer = new Timer(1000 / 144,this);

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

//        monsters = new ArrayList<>();
//        monsters.add(new Monster(keyInputManager));

//        for(Monster monster : monsters){
//            monster.setBounds(0, 0, 1000, 600);
//            monster.setOpaque(false);
//            layeredPane.add(monster, Integer.valueOf(3));
//        }
        layeredPane.add(back, Integer.valueOf(0));
        layeredPane.add(front, Integer.valueOf(1));
        layeredPane.add(player, Integer.valueOf(2));


        setPreferredSize(new Dimension(1000, 600));
        setOpaque(false);
        add(layeredPane, BorderLayout.CENTER);
    }

    public JLayeredPane getLayeredPane(){
        return layeredPane;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
