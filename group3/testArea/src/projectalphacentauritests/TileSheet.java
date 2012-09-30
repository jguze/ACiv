/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectalphacentauritests;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TileSheet extends JPanel {
    private Image grass, mountain, water;
    BufferedImage[][] sprites;
    int width = 30;
    int height = 30;
    int rows = 19; 
    int cols = 20;
    public void createSpriteSheet() throws IOException {
        BufferedImage buffedImg = ImageIO.read(new File("images/tiles.png"));

        sprites = new BufferedImage[20][20];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sprites[j][i] = buffedImg.getSubimage(
                        j * width,
                        i * height, 
                        width, 
                        height);
            }
        }
    }
    
    public void draw(Graphics g) {
          for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g.drawImage(sprites[j][i], j * cols, i * rows, null);
            }
          }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }
    
    public void display(JFrame frame) throws Exception {
        createSpriteSheet();
        frame.setSize(340,320);
        frame.add(this);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        TileSheet t = new TileSheet();
        JFrame j = new JFrame("TEST");
        j.setDefaultCloseOperation(3);
        t.display(j);
        
    }
}
