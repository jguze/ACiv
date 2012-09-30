/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.UI;

import javax.swing.*;
import civ.engine.GameEngine;
import civ.MapLocation;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author paulhunter
 */
public class MiniMapView extends JPanel
{
    Graphics2D paintRegion;

    public MiniMapView(int width, int height)
    {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new javax.swing.border.LineBorder(Color.YELLOW, 2));
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));

        paintRegion = (Graphics2D)this.getGraphics();
    }
}
