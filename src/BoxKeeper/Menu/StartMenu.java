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
        void onStartGame(); // 게임 시작을 알리는 메서드
    }

    // 리스너 객체를 저장할 변수
    private StartMenuListener listener;

    public void setStartMenuListener(StartMenuListener listener) {
        this.listener = listener;
    }

    public void initStartPanel(){
        // JPanel 생성 및 GridBagLayout 설정
        panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // 패널 투명하게 설정

        initGBC();
        // 배경으로 사용할 GIF 로드
        ImageIcon gifIcon = new ImageIcon("Images/Start/frontRolling.gif");
        JLabel gifLabel = new JLabel(gifIcon);// GridBagLayout 설정
        panel.add(gifLabel, gbc);

        // JLabel 제목 텍스트 설정
        JLabel titleLabel = new JLabel("Box Keeper");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        panel.add(titleLabel, gbc);

        // JButton 생성
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 2; // 버튼을 제목 아래에 배치
        panel.add(startButton, gbc);

        // JButton에 ActionListener 추가
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼이 클릭되었을 때 StartMenuListener를 통해 게임 시작을 알림
                if (listener != null) {
                    listener.onStartGame();
                }
            }
        });
    }

    //GridBagConstraints initialize
    private void initGBC(){
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTH;
    }
}
