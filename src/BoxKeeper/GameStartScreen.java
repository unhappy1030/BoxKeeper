package BoxKeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStartScreen {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("Game Start Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);

        // JPanel 생성 및 GridBagLayout 설정
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTH; // 최상단 배치
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // 패널 투명하게 설정


        // JLabel 제목 텍스트 설정
        // 배경으로 사용할 GIF 로드
        ImageIcon gifIcon = new ImageIcon("Images/frontRolling3.gif");
        JLabel gifLabel = new JLabel(gifIcon);// GridBagLayout 설정
        panel.add(gifLabel, gbc);


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
                // 버튼 클릭 시 실행될 코드
                JOptionPane.showMessageDialog(frame, "Game Starting...");
                // 실제 게임 시작 코드를 여기에서 호출할 수 있습니다.
            }
        });

        // JFrame에 설정된 내용을 추가
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
