package BoxKeeper.MainGame.Player;

import BoxKeeper.MainGame.KeyInput.KeyInputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Player extends JPanel implements ActionListener {
    private final KeyInputManager keyInputManager;

    private final Image walkRight1; // 오른쪽으로 걷는 캐릭터 이미지 1
    private final Image walkRight2; // 오른쪽으로 걷는 캐릭터 이미지 2
    private final Image walkLeft1; // 왼쪽으로 걷는 캐릭터 이미지 1
    private final Image walkLeft2; // 왼쪽으로 걷는 캐릭터 이미지 2
    private final Image defaultRImage; // 기본 캐릭터 이미지
    private final Image defaultLImage; // 기본 캐릭터 이미지
    private int currentRightImageIndex = 1; // 오른쪽 방향 캐릭터의 현재 표시 중인 이미지 인덱스
    private int currentLeftImageIndex = 1; // 왼쪽 방향 캐릭터의 현재 표시 중인 이미지 인덱스
    private boolean lastDirectionRight = true; // 마지막으로 이동한 방향

    public Player(KeyInputManager keyInputManager){
        this.keyInputManager = keyInputManager;
        setPreferredSize(new Dimension(64,64));

        // 오른쪽으로 걷는 캐릭터 이미지들을 불러옵니다.
        walkRight1 = new ImageIcon("Images/Player/right1.png").getImage();
        walkRight2 = new ImageIcon("Images/Player/right2.png").getImage();

        // 왼쪽으로 걷는 캐릭터 이미지들을 불러옵니다.
        walkLeft1 = new ImageIcon("Images/Player/left1.png").getImage();
        walkLeft2 = new ImageIcon("Images/Player/left2.png").getImage();

        // 기본 캐릭터 이미지를 불러옵니다.
        defaultRImage = new ImageIcon("Images/Player/defaultR.png").getImage();
        defaultLImage = new ImageIcon("Images/Player/defaultL.png").getImage();

        // 타이머를 설정하여 주기적으로 액션 이벤트를 발생시킵니다.
        Timer timer = new Timer(1000 / 10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 방향키에 따라 캐릭터의 모션을 표현합니다.
        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT)) {
            System.out.println("Player: Walking left");
            // 왼쪽으로 걷는 이미지를 변경합니다.
            currentLeftImageIndex = (currentLeftImageIndex == 1) ? 2 : 1;
            lastDirectionRight = false;
        } else if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT)) {
            System.out.println("Player: Walking right");
            // 오른쪽으로 걷는 이미지를 변경합니다.
            currentRightImageIndex = (currentRightImageIndex == 1) ? 2 : 1;
            lastDirectionRight = true;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 캐릭터를 그립니다.
        if (keyInputManager.isKeyPressed(KeyEvent.VK_LEFT)) {
            // 왼쪽으로 걷는 캐릭터 이미지를 그립니다.
            if (currentLeftImageIndex == 1) {
                g.drawImage(walkLeft1, 200, 450, this);
            } else {
                g.drawImage(walkLeft2, 200, 450, this);
            }
        } else if (keyInputManager.isKeyPressed(KeyEvent.VK_RIGHT)) {
            // 오른쪽으로 걷는 캐릭터 이미지를 그립니다.
            if (currentRightImageIndex == 1) {
                g.drawImage(walkRight1, 200, 450, this);
            } else {
                g.drawImage(walkRight2, 200, 450, this);
            }
        } else {
            // 이동하지 않을 때 기본 캐릭터 이미지를 그립니다.
            if (lastDirectionRight) {
                g.drawImage(defaultRImage, 200, 450, this);
            } else {
                // 왼쪽으로 움직였을 때 기본 캐릭터 이미지를 그립니다.
                // 이미지가 없다면 마지막으로 그린 방향의 이미지를 사용할 수도 있습니다.
                g.drawImage(defaultLImage, 200, 450, this);
            }
        }
    }

    public void update(){
        actionPerformed(null);
    }
}
