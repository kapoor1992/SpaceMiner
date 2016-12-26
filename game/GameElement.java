package spaceminer.game;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

// Not to be instantiated by controller.
// Inherited by Player, Background, Goal, Obstacles, and Score.
public class GameElement extends JPanel {
    protected int areaHeight;
    protected int areaWidth;
    
    protected BufferedImage image;
    
    protected GameElement (int height, int width) {
        areaHeight = height;
        areaWidth = width;
        image = null;
        
        setOpaque(false);
    }
    
    protected GameElement (int height, int width, String path) {
        areaHeight = height;
        areaWidth = width;
        
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        setOpaque(false);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(areaHeight, areaWidth);
    }
}
