/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectalphacentauritests;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TileSheet extends JPanel implements MouseListener {
    private Image grass, mountain, water;
    BufferedImage[][] sprites;
    BufferedImage highlight;
    int width = 30;
    int height = 30;
    int rows = 19; 
    int cols = 20;
    int mouseX = 0;
    int mouseY = 0;
    
    TileSheet() {
        try {       
            addMouseListener(this);
            highlight = ImageIO.read(new File("images/highlight.png"));
        } catch (Exception e) {
            // Error
        }
    }
     
    public void createSpriteSheet() throws IOException {
        BufferedImage buffedImg = ImageIO.read(new File("images/tiles.png"));

        sprites = new BufferedImage[cols][rows];
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
                g.drawImage(sprites[j][i], j * width, i * height, width, height, null);
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
        frame.setSize((21)*height,(21)*width);
        frame.add(this);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        TileSheet t = new TileSheet();
        JFrame j = new JFrame("TEST");
        j.setDefaultCloseOperation(3);
        t.display(j);  
    }
    
    public void highlightTile() {
//        System.out.println("Mouse X : " + this.mouseX + " Mouse Y: " + this.mouseY);
        this.getGraphics().drawImage(highlight,(this.mouseX),(this.mouseY), width, height, this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
        highlightTile();        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
