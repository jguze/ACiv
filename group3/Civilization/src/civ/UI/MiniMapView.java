/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.UI;

import java.util.Observable;
import javax.swing.*;
import civ.engine.GameEngine;
import civ.MapLocation;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import civ.UI.MapView;
import civ.sprites.SpriteUtils;
import java.awt.Color;

/**
 *
 * @author paulhunter
 * TODO: Implement the ability to move the map view by clicking in the minimap view window.
 * TODO: Implement a coloured spec in the mini map view if there is an enemy of friendly (its kinda a pain in the arse to have to find your unit every turn)
 */
public class MiniMapView extends JPanel
{
    private BufferedImage view;
    public MiniMapView(int width, int height)
    {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new javax.swing.border.LineBorder(Color.LIGHT_GRAY, 1));
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
    }

    //This is the 'update' method the for observation pattern on the MapView
    public void updateView(MapView mainView)
    {
        //Integers for the width and height we will draw in.
        int viewWidth = this.getWidth()-2;
        int viewHeight = this.getHeight()-2;

        //The draw ratio for tiles to pixels, ie 2 = a tile is a 2x2pixel splot
        int ratio = 2;
        //Find the ratio that fills the most of the mini map view. If there is excess space we will have black regions
        int optiWidthRatio = viewWidth/mainView.mapWidth;
        int optiHeightRatio = viewHeight/mainView.mapHeight;
        optiWidthRatio = optiWidthRatio>optiHeightRatio?optiWidthRatio:optiHeightRatio;
        ratio = ratio>optiWidthRatio?ratio:optiWidthRatio;
        
        //Find the size of the 'map' section that we need to draw
        //that is the number of tiles
        int miniWidth = (viewWidth)/ratio;
        miniWidth = miniWidth>mainView.mapWidth?mainView.mapWidth:miniWidth;
        int miniHeight = (viewHeight)/ratio;
        miniHeight = miniHeight>mainView.mapHeight?mainView.mapHeight:miniHeight;
        
        //Our camera offset in the minimap
        int miniOffsetX = 0;
        if(!mainView.mapWrap){
            miniOffsetX = (mainView.CameraOffset.x - ((miniWidth-mainView.viewTileWidth)/2));
            if(miniOffsetX < 0) miniOffsetX = 0;
            else if(miniOffsetX > mainView.mapWidth-miniWidth)
                miniOffsetX = mainView.mapWidth-miniWidth;
        }
        else
            miniOffsetX = (((mainView.CameraOffset.x - ((miniWidth-mainView.viewTileWidth)/2))%mainView.mapWidth)+mainView.mapWidth)%mainView.mapWidth;
        int miniOffsetY = (mainView.CameraOffset.y - ((miniHeight-mainView.viewTileHeight)/2));
        miniOffsetY = miniOffsetY<0?0:miniOffsetY;
        miniOffsetY = miniOffsetY>mainView.mapHeight-miniHeight?mainView.mapHeight-miniHeight:miniOffsetY;

        //Find the camera draw specs
        int camX = ((mainView.CameraOffset.x-miniOffsetX)+mainView.mapWidth)%mainView.mapWidth;
        int camY = ((mainView.CameraOffset.y-miniOffsetY)+mainView.mapHeight)%mainView.mapHeight;

        this.view = GenerateMapImage(miniOffsetX, miniOffsetY, miniWidth, miniHeight, ratio, viewWidth, viewHeight,
                camX, camY, mainView.viewTileWidth, mainView.viewTileHeight);

        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int xbuff = ((this.getWidth()-2) - this.view.getWidth())/2;
        int ybuff = ((this.getHeight()-2) - this.view.getHeight())/2;
        g.drawImage(this.view, xbuff+1,ybuff+1, this.getWidth()-2, this.getHeight()-2, this);
    }

    /**
     * Generate the minimap image
     * @param xOffset Minimap camera offset x
     * @param yOffest minimap camera offset y
     * @param viewWidth minimap tile width
     * @param ViewHeight minimap tile hieght
     * @param ratio minimap ratio( tile to pixel)
     * @param sizeX image size x
     * @param sizeY image size y
     */
    static public BufferedImage GenerateMapImage(int xOffset, int yOffset, int viewWidth, int viewHeight, int ratio, int sizeX, int sizeY, int CamX, int CamY, int CamW, int CamH)
    {
        BufferedImage miniMap = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
        Graphics2D canvas = miniMap.createGraphics();
        canvas.setColor(Color.black);
        canvas.fillRect(0, 0, sizeX, sizeY);

        int xBuff = (sizeX - (viewWidth*ratio))/2;
        int yBuff = (sizeY - (viewHeight*ratio))/2;

        for(int x = xOffset; x < viewWidth + xOffset; x++)
        {
            for(int y = yOffset; y < viewHeight + yOffset; y++)
            {
                canvas.setColor(SpriteUtils.getInstance().getTerrainColor(x, y));
                canvas.fillRect((x-xOffset)*ratio + xBuff, (y-yOffset)*ratio + yBuff, ratio, ratio);
                canvas.setColor(SpriteUtils.getInstance().getTerrainOverColor(x, y));
                canvas.fillRect((x-xOffset)*ratio + xBuff, (y-yOffset)*ratio + yBuff, ratio, ratio);
            }
        }
        //Paint the view border.
        canvas.setColor(new Color(0, 220, 220, 200));
        canvas.drawRect(CamX*ratio + xBuff, CamY*ratio + yBuff, CamW*ratio-1, CamH*ratio-1);
        
        return miniMap;
    }
}
