package BoxKeeper.MainGame;

import BoxKeeper.MainGame.Background.Monster;
import BoxKeeper.MainGame.Player.Player;
import java.awt.*;
import java.util.ArrayList;

public class InteractionManager {
    private static Player player;
    private static MainPanel mainPanel;

    public static void setPlayer(Player player){
        InteractionManager.player = player;
    }
    public static void setMainPanel(MainPanel mainPanel){
        InteractionManager.mainPanel = mainPanel;
    }

    public static void getMainPanelDirection(){
        int mainX = mainPanel.getX();

    }
}
