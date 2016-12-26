package spaceminer.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameElement implements ActionListener, KeyListener {
    private int playerHeight;
    private int playerWidth;
    private int speed;
    private int x;
    private int y;
    private int velX;
    private int velY;
    
    
    public Player (int areaHeight, int areaWidth, String path, 
                   int playerHeight, int playerWidth, int speed) {
        super(areaHeight, areaWidth, path);
        
        this.playerHeight = playerHeight;
        this.playerWidth = playerWidth;
        this.speed = speed;
        x = (areaWidth / 2) - (playerWidth / 2);
        y = (areaHeight / 2) - (playerHeight / 2);
        velX = 0;
        velY = 0;
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public int getXPos() {
        return x;
    }
    
    public int getYPos() {
        return y;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        // Bounce off left wall.
        if (x < 0) {
            velX = speed;
            x = 0;
        }
        // Bounce off top wall.
        if (y < 0) {
            velY = speed;
            y = 0;
        }
        // Bounce off right wall.
        if (x > areaWidth - playerWidth) {
            velX = -speed;
            x = areaWidth - playerWidth;
        }
        // Bounce off bottom wall.
        if (y > areaHeight - (playerHeight * 2)) {
            velY = -speed;
            y = areaHeight - (playerHeight * 2);
        }
        
        x = x + velX;
        y = y + velY;
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();
        
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            velX = -speed;
            velY = 0;
        } else if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            velX = speed;
            velY = 0;
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            velX = 0;
            velY = -speed;
        } else if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            velX = 0;
            velY = speed;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent event) {
    }
    
    @Override
    public void keyTyped(KeyEvent event) {
    }
    
    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }
}
