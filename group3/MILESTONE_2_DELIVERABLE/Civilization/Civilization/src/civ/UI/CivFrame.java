/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.UI;

import javax.swing.*;
import java.awt.*;
import civ.engine.*;

/**
 *
 * @author paulhunter
 */
public class CivFrame extends JFrame
{
    private MapView mapView;
    private MiniMapView miniMapView;
    private GameEngine civEngine;

    public CivFrame()
    {
        super("MainCivFrame");

        Container CP = this.getContentPane();

        CP.setLayout(this.createLayout());
        CP.setPreferredSize(new Dimension(800, 600));

        CP.setBackground(new Color(255,0,255));
        
        civEngine = new GameEngine();
        mapView = new MapView(civEngine, 632, 592);
        //Use this line to have a 10x10 tile map.
        //mapView = new MapView(civEngine, 302, 302);
        miniMapView = new MiniMapView(150,90);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        CP.add(miniMapView, c);

        //Add the main map view to the frame.
        c.insets = new Insets(3,3,3,3);
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        CP.add(mapView, c);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);
        this.pack(); //DO NOT REMOVE, YOU WILL BREAK THINGS YOU DONT EVEN UNDERSTAND!
        mapView.paintMap();
        this.setVisible(true);
    }

    private GridBagLayout createLayout()
    {
        GridBagLayout GBL = new GridBagLayout();
        GBL.columnWidths = new int[] {160,640};
        GBL.rowHeights = new int[] {100, 500};
        return GBL;
    }
}
