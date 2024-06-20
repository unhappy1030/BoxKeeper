package BoxKeeper.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu {
    private JPanel panel;
    private GridBagConstraints gbc;

    public JPanel getPanel(){
        return panel;
    }

    public interface StartMenuListener {
        void onStartGame();
    }

    private StartMenuListener listener;

    public void setStartMenuListener(StartMenuListener listener) {
        this.listener = listener;
    }

    public void initStartPanel(){
        panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        initGBC();
        ImageIcon gifIcon = new ImageIcon("Images/Start/frontRolling.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        panel.add(gifLabel, gbc);

        JLabel titleLabel = new JLabel("Box Keeper");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        panel.add(titleLabel, gbc);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 2;
        panel.add(startButton, gbc);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.onStartGame();
                }
            }
        });
    }

    private void initGBC(){
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTH;
    }
}
