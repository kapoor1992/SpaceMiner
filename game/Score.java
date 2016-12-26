package spaceminer.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import spaceminer.game.util.GoalTypes;

public class Score extends GameElement {
    // Used for score positioning.
    public static final int HEIGHT_OFFSET = 25;
    public static final int WIDTH_OFFSET = 50;
    
    private int score;
    private int x;
    private int y;
    
    public Score(int height, int width) {
        super(height, width);
        
        score = 0;
        
        x = width - WIDTH_OFFSET;
        y = HEIGHT_OFFSET;
    }
    
    public void updateScore(char type) {
        if (type == GoalTypes.COMMON)
            score++;
        else if (type == GoalTypes.UNCOMMON) {
            score += 5;
        } else {
            score += 10;
        }
    }
    
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.setColor(Color.WHITE);
        graphics2D.drawString(Integer.toString(score), x, y);
    }
}