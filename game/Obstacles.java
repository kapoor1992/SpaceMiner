package spaceminer.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Obstacles extends GameElement {
    private ArrayList obstacles = new ArrayList(); // Holds position of all obstacles.
    private int obstacleHeight;
    private int obstacleWidth;
    
    public Obstacles(int areaHeight, int areaWidth, String path, 
                     int obstacleHeight, int obstacleWidth) {
        super(areaHeight, areaWidth, path);
        
        this.obstacleHeight = obstacleHeight;
        this.obstacleWidth = obstacleWidth;
    }
    
    public void newObstacle() {
        int x = Math.round((float)(Math.random() * (areaWidth - obstacleWidth)));
        int y = Math.round((float)(Math.random() * (areaHeight - (2 * obstacleHeight))));
        
        obstacles.add(new Obstacle(x, y));
    }
    
    public boolean didCollide(int playerX, int playerY, int playerWidth, int playerHeight) {
        Obstacle p;
        int x;
        int y;
        
        // Compare with each obstacle.
        for (int i = 0; i < obstacles.size(); i++) {
            p = (Obstacle)obstacles.get(i);
            x = p.getX();
            y = p.getY();
        
            // These statements ensure any touch to be a collision.
            if (x >= playerX && x <= playerX + playerWidth &&
                y >= playerY && y <= playerY + playerHeight) {
                return true;
            }
            if (x + obstacleWidth >= playerX && x + obstacleWidth <= playerX + playerWidth && 
                y + obstacleHeight >= playerY && y + obstacleHeight <= playerY + playerWidth) {
                return true;
            }
            if (x >= playerX && x <= playerX + playerWidth &&
                y + obstacleHeight >= playerY && y + obstacleHeight <= playerY + playerWidth) {
                return true;
            }
            if (x + obstacleWidth >= playerX && x + obstacleWidth <= playerX + playerWidth &&
                y >= playerY && y <= playerY + playerHeight) {
                return true;
            }
        }
        
        return false;
    }
    
    public void draw(Graphics graphics) {
        Obstacle p;
        int x;
        int y;
        
        graphics.setColor(Color.RED);
        
        // Draw each obstacle.
        for (int i = 0; i < obstacles.size(); i++) {
            p = (Obstacle)obstacles.get(i);
            x = p.getX();
            y = p.getY();
            graphics.drawImage(image, x, y, null);
        }
    }
}
