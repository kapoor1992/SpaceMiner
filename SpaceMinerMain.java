package spaceminer;

import spaceminer.game.GameController;
import java.io.File;

public class SpaceMinerMain {
    public static void main(String[] args) throws InterruptedException {
        // Set arguments to be passed.
        int aX = 600;
        int aY = 600;
        int pX = 30;
        int pY = 30;
        int gX = 20;
        int gY = 20;
        int oX = 20;
        int oY = 20;
        int s = 1;
        
        // Grab images.
        String pp = new File("spaceminer/images/player.jpg").getAbsolutePath();
        String gp = new File("spaceminer/images/goal.jpg").getAbsolutePath();
        String op = new File("spaceminer/images/obstacle.jpg").getAbsolutePath();
        String bp = new File("spaceminer/images/background.jpg").getAbsolutePath();
        
        // Start game.
        GameController gc = new GameController(aY, aX, pY, pX, gY, gX, oY, oX, s, pp, gp, op, bp);
    }
}