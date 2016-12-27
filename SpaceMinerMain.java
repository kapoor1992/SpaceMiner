package spaceminer;

import spaceminer.game.GameController;
import java.io.File;
import javax.swing.JOptionPane;

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
        String cp = new File("spaceminer/images/goal_common.jpg").getAbsolutePath();
        String up = new File("spaceminer/images/goal_uncommon.jpg").getAbsolutePath();
        String rp = new File("spaceminer/images/goal_rare.jpg").getAbsolutePath();
        String op = new File("spaceminer/images/obstacle.jpg").getAbsolutePath();
        String bp = new File("spaceminer/images/background.jpg").getAbsolutePath();
        
        // Gives brief information and instructions.
        intro();
        
        // Start game.
        GameController gc = new GameController(aY, aX, pY, pX, gY, gX, oY, oX, s, 
                                               pp, cp, up, rp, op, bp);
    }
    
    public static void intro() {
        JOptionPane.showMessageDialog(null,
                                      "Welcome to Space Miner!\n\n" +
                                      "You are an alien who loves space minerals.\n" +
                                      "Use the arrow keys or WASD to move around your ship!\n\n" +
                                      "Yellow Minerals:  1pt\n" + 
                                      "Red Minerals:      5pt\n" + 
                                      "Green Minerals: 10pt\n\n" +
                                      "Happy mining and try not to hit asteroids!",
                                      "Space Miner",
                                      JOptionPane.PLAIN_MESSAGE);
    }
}