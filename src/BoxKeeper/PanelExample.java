package BoxKeeper;

import javax.swing.*;

public class PanelExample {
    public static void main(String[] args) {
        // 메인 프레임 생성
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);  // null 레이아웃 사용하여 위치와 크기를 직접 설정

        // 하위 패널 생성
        JPanel subPanel = new JPanel();
        subPanel.setBounds(50, 50, 200, 100);  // 위치와 크기 설정
        subPanel.setBackground(java.awt.Color.BLUE);

        // 버튼 생성
        JButton button = new JButton("Click Me");
        button.setBounds(50, 20, 100, 30);  // 위치와 크기 설정

        // 하위 패널에 버튼 추가
        subPanel.setLayout(null);
        subPanel.add(button);

        // 메인 패널에 하위 패널 추가
        mainPanel.add(subPanel);

        // 프레임에 메인 패널 추가
        frame.add(mainPanel);

        // 프레임 보이기
        frame.setVisible(true);
    }
}
