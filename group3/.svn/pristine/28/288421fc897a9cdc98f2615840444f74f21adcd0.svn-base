/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author paulhunter
 */
public class MapPreviewView extends JFrame
{
    JLabel previewImage;

    private Container cp = getContentPane();

    public MapPreviewView(String name, BufferedImage preview, SplashView splash)
    {
        super(name + " - Preview");
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.black);
        previewImage = new JLabel(new ImageIcon(preview));
        cp.add(previewImage);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.addWindowListener(new CustomWindowAdapter(this, splash));
    }

    private class CustomWindowAdapter extends java.awt.event.WindowAdapter
    {
        SplashView view;
        MapPreviewView mpview;
        CustomWindowAdapter(MapPreviewView mv, SplashView v)
        {
            view = v;
            mpview = mv;
        }

        @Override
        public void windowClosing(java.awt.event.WindowEvent e)
        {
            view.setEnabled(true);
            view.setFocusableWindowState(true);
            mpview.dispose();
        }
    }
}
