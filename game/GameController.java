package spaceminer.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

// The brain of the game.
public class GameController implements ActionListener {
    private Timer timer;
    private JFrame window;
    private int areaHeight;
    private int areaWidth;
    private int playerHeight;
    private int playerWidth;
    private int goalHeight;
    private int goalWidth;
    private int obstacleHeight;
    private int obstacleWidth;
    private int speed;
    private String playerPath;
    private String goalPath;
    private String obstaclePath;
    private String backgroundPath;
    private Player player;
    private Goal goal;
    private Obstacles obstacles;
    private Score score;
    private Background background;
    private Painter painter;
    
    // Yes, it's one hell of a constructor.
    public GameController (int areaHeight, int areaWidth, int playerHeight, 
                           int playerWidth, int goalHeight, int goalWidth,
                           int obstacleHeight, int obstacleWidth, int speed, 
                           String playerPath, String goalPath, 
                           String obstaclePath, String backgroundPath) {
        timer = new Timer(5, this);
        
        window = new JFrame("Space Miner");
        
        this.areaHeight = areaHeight;
        this.areaWidth = areaWidth;
        this.playerHeight = playerHeight;
        this.playerWidth = playerWidth;
        this.goalHeight = goalHeight;
        this.goalWidth = goalWidth;
        this.obstacleHeight = obstacleHeight;
        this.obstacleWidth = obstacleWidth;
        this.speed = speed;
        this.playerPath = playerPath;
        this.goalPath = goalPath;
        this.obstaclePath = obstaclePath;
        this.backgroundPath = backgroundPath;
        
        initElements();
        attachElements();
        formatWindow();
        
        timer.start();
    }
    
    // Instantiate other package classes.
    private void initElements() {
        player = new Player(areaHeight, areaWidth, playerPath, playerHeight, playerWidth, speed);
        goal = new Goal(areaHeight, areaWidth, goalPath, goalHeight, goalWidth);
        obstacles = new Obstacles(areaHeight, areaWidth, obstaclePath, obstacleHeight, obstacleWidth);
        score = new Score(areaHeight, areaWidth);
        background = new Background(areaHeight, areaWidth, backgroundPath);
        
        painter = new Painter(areaHeight, areaWidth, player, goal, obstacles, score, background);
    }
    
    // Layer the game window.
    private void attachElements() {
        window.add(painter);
        painter.add(background);
        background.add(obstacles);
        obstacles.add(goal);
        goal.add(player);
        player.add(score);
    }
    
    // Adjust window parameters.
    private void formatWindow() {
        window.setResizable(false);
        window.setSize(areaHeight, areaWidth);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (goal.didCollide(player.getXPos(), player.getYPos(), playerWidth, playerHeight)) {
            score.updateScore();
            obstacles.newObstacle();
            
            do {
                goal.newGoal(); // Do not place a goal on top of an obstacle!
            } while (obstacles.didCollide(goal.getXPos(), goal.getYPos(), goalWidth, goalHeight));
        }
        if (obstacles.didCollide(player.getXPos(), player.getYPos(), playerWidth, playerHeight)) {
            try {
                Thread.sleep(2000); // Give a couple seconds for the player to process mistake.
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.exit(0); // Goodbye!
        }
        
        player.actionPerformed(event);
        
        painter.repaint();
    }
}