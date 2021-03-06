/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites;

import civ.Map;
import civ.sprites.SpriteUtils;
import civ.MapLocation;
import civ.Tile;
import civ.World;
import civ.enums.TerrainBonusType;
import civ.enums.TerrainType;
import civ.enums.UnitType;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Justin
 */
public class SpriteUtilsTest extends JPanel {
    BufferedImage[][] sprites;
    BufferedImage highlight;
    int width = 30;
    int height = 30;
    int rows = 19; 
    int cols = 20;
    int mouseX = 0;
    int mouseY = 0;
    SpriteUtils utils;
    
    SpriteUtilsTest() throws IOException {
        //This is broken, we need to create a world
        //we can use the world.createTest to do this if we wanted.
        utils = new SpriteUtils(new World(new Map(new Tile[100][100])));
    }
    
    public void draw(Graphics g) {
        g.drawImage(utils.getCityMap().get("ASIAN_WALLS"), 0, 0, 30, 30, this);
    }
    
    public void drawTerrain(Graphics g) throws IOException {
        BufferedReader reader  = null;
        int i = 0, j = 0;
        try {
            reader = new BufferedReader(new FileReader(new File("resources/spec/terrain.jspec")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpriteUtilsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line;
        String[] words;
        reader.readLine();
        while((line = reader.readLine()) != null) {
            words = line.split(" ");
            if (i == 10) {
                i = 0;
                j++;
            }
            g.drawImage(utils.getTerrainMap().get(words[0]), 30 *i++, 30 *j, 30, 30, null);
        }
    }
    
    public void drawUnits(Graphics g){
        int i = 0, j = 0;
        for(UnitType type : UnitType.values()){
            if (i == 10) {
                i = 0;
                j++;
            }
            g.drawImage(utils.getUnitMap().get(type), 30 *i++, 30*j, 30, 30, null);
        }
    }
    
    public void drawResources(Graphics g) {
        int i = 0;
        for (TerrainBonusType type : TerrainBonusType.values()) {
            g.drawImage(utils.getTerrainBonusMap().get(type), (30 * i++), 0, 30, 30, this);
        }
    }
    public void drawUnit(Graphics g){
        int i = 0;
        int j=0;
        for (UnitType type : UnitType.values()) {
            if (i > 10) {
                i = 0;
                j++;
            }
            g.drawImage(utils.getUnitMap().get(type), (30 * i++), j*30, 30, 30, this);
        }
    }
    
    public void drawTerrainBonus(Graphics g){
        int i = 0;
        int j=0;
        for (TerrainBonusType type : TerrainBonusType.values()) {
            if (i > 10) {
                i = 0;
                j++;
            }
            g.drawImage(utils.getTerrainBonusMap().get(type), (30 * i++), j*30, 30, 30, this);
        }
        
    }
    
    /*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawResources(g);
    }   */
    @Override
    protected void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            this.drawTerrainBonus(g);
        } catch (Exception ex) {
            Logger.getLogger(SpriteUtilsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public void display(JFrame frame) throws Exception {
        frame.setSize((21)*height,(21)*width);
        frame.add(this);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        SpriteUtilsTest test = new SpriteUtilsTest();
        JFrame j = new JFrame("TEST");
        j.setDefaultCloseOperation(3);
        test.display(j);
    }
}
