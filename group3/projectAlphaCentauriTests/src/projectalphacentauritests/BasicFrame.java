package projectalphacentauritests;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class BasicFrame extends JFrame {
    public BasicFrame() throws Exception {
        super("TEST");
        
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        TileSheet t = new TileSheet();
        t.createSpriteSheet();
        Graphics2D g = (Graphics2D)this.getRootPane().getGraphics();  
        this.setVisible(true);
        this.setSize(340, 320);
        for (int i = 0; i < t.rows; i++) {
            for (int j = 0; j < t.cols; j++) {
                g.drawImage(t.sprites[i][j], null, 0, 0);
            }
        }
    }
}
