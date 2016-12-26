package spaceminer.game;

import java.awt.Graphics;

public class Goal extends GameElement {
    private int goalHeight;
    private int goalWidth;
    private int x;
    private int y;
    
    public Goal(int areaHeight, int areaWidth, String path, 
                int goalHeight, int goalWidth) {
        super(areaHeight, areaWidth, path);
        
        this.goalHeight = goalHeight;
        this.goalWidth = goalWidth;
        
        newGoal();
    }
    
    public void newGoal() {
        x = Math.round((float)(Math.random() * (areaWidth - goalWidth)));
        y = Math.round((float)(Math.random() * (areaHeight - (2 * goalHeight))));
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
        graphics.drawImage(image, x, y, null);
    }
}