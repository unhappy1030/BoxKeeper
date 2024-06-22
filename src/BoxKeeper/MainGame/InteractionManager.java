package BoxKeeper.MainGame;

import BoxKeeper.MainGame.Background.Front;
import BoxKeeper.MainGame.Background.Monster;
import BoxKeeper.MainGame.Player.Player;
import java.util.ArrayList;

public class InteractionManager {
    private static Player player;
    private static Front front;
    private static ArrayList<Monster> monsters;

    public static void setPlayer(Player player){
        InteractionManager.player = player;
    }
    public static void setFront(Front front){InteractionManager.front = front;}
    public static void setMonsters(ArrayList<Monster> monsters){InteractionManager.monsters = monsters;}
    public static void moveMonsters(int value){
        for(Monster monster : monsters){
            monster.move(value);
        }
    }
    public static void setMonsterDir(){
        for(Monster monster : monsters){
            System.out.println("Player/Monster : " + player.getPosX() + "/" + monster.getPosition());
            if(monster.getCenter() < player.getCenter()){
                monster.setDirection(true);
            } else {
                monster.setDirection(false);
            }

            if(monster.getCenter() + 100 >= player.getCenter() && monster.getCenter() - 100 <= player.getCenter()) {
                monster.setSpeed(0);
                monster.attack();
            }
            else{
                monster.setSpeed(5);
            }
        }
    }
}
