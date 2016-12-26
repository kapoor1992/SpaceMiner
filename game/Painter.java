package spaceminer.game;

import java.awt.Graphics;

public class Painter extends GameElement {
    private Player player;
    private Goal goal;
    private Obstacles obstacles;
    private Score score;
    private Background background;
    
    public Painter(int height, int width, Player player, Goal goal, 
                   Obstacles obstacles, Score score, Background background) {
        super(height, width);
        
        this.player = player;
        this.goal = goal;
        this.obstacles = obstacles;
        this.score = score;
        this.background = background;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        background.draw(graphics);
        obstacles.draw(graphics);
        goal.draw(graphics);
        player.draw(graphics);
        score.draw(graphics);
    }
}
