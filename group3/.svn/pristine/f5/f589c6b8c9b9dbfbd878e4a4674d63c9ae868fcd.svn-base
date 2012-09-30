/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projectalphacentauritests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;


public class GameUtils {
    private HashMap<Character,BufferedImage> terrainMap;
    private int pixelWidth = 30;
    private int pixelHeight = 30;
    
    public GameUtils() {
        terrainMap = new HashMap<Character,BufferedImage>();
        setUp();
    }
    
    private void setUp() {
        try {
            BufferedImage buffedImage = ImageIO.read(new File("images/tiles.png"));
            
            terrainMap.put('p', buffedImage.getSubimage(pixelWidth, pixelWidth, pixelWidth, pixelWidth));
            terrainMap.put('f', buffedImage.getSubimage(0,0,0,0));
            terrainMap.put('g', buffedImage.getSubimage(0,0,0,0));
            terrainMap.put('w', buffedImage.getSubimage(0,0,0,0));
            terrainMap.put('d', buffedImage.getSubimage(0,0,0,0));

        } catch (IOException ex) {
            System.out.println("Shoot");
        }
        
    }
    
}
