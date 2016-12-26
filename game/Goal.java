package spaceminer.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import spaceminer.game.util.GoalTypes;

public class Goal extends GameElement {
    private BufferedImage common;
    private BufferedImage uncommon;
    private BufferedImage rare;
    private int goalHeight;
    private int goalWidth;
    private int x;
    private int y;
    private char type;
    
    public Goal(int areaHeight, int areaWidth, String commonPath, String uncommonPath,
                String rarePath, int goalHeight, int goalWidth) {
        super(areaHeight, areaWidth);
        
        this.goalHeight = goalHeight;
        this.goalWidth = goalWidth;
        
        try {
            common = ImageIO.read(new File(commonPath));
            uncommon = ImageIO.read(new File(uncommonPath));
            rare = ImageIO.read(new File(rarePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        newGoal();
    }
    
    public void newGoal() {
        x = Math.round((float)(Math.random() * (areaWidth - goalWidth)));
        y = Math.round((float)(Math.random() * (areaHeight - (2 * goalHeight))));
        
        int typeRoll = (int)(Math.random() * 20 + 1);

        if (typeRoll == 1) {
            type = GoalTypes.RARE;
        } else if (typeRoll < 6) {
            type = GoalTypes.UNCOMMON;
        } else {
            type = GoalTypes.COMMON;
        }
    }
    
    public char getType() {
        return type;
    }
    
    public int getXPos() {
        return x;
    }
    
    public int getYPos() {
        return y;
    }
    
    public boolean didCollide(int playerX, int playerY, int playerWidth, int playerHeight) {
        // Any touch counts as a collision in these statements.
        if (x >= playerX && x <= playerX + playerWidth &&
            y >= playerY && y <= playerY + playerHeight) {
            return true;
        }
        if (x + goalWidth >= playerX && x + goalWidth <= playerX + playerWidth && 
            y + goalHeight >= playerY && y + goalHeight <= playerY + playerWidth) {
            return true;
        }
        if (x >= playerX && x <= playerX + playerWidth &&
            y + goalHeight >= playerY && y + goalHeight <= playerY + playerWidth) {
            return true;
        }
        if (x + goalWidth >= playerX && x + goalWidth <= playerX + playerWidth &&
            y >= playerY && y <= playerY + playerHeight) {
            return true;
        }
        
        return false;
    }
    
    public void draw(Graphics graphics) {
        if (type == GoalTypes.COMMON) {
            graphics.drawImage(common, x, y, null);
        } else if (type == GoalTypes.UNCOMMON) {
            graphics.drawImage(uncommon, x, y, null);
        } else {
            graphics.drawImage(rare, x, y, null);
        }
    }
}