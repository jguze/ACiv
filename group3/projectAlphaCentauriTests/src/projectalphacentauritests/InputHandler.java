package projectalphacentauritests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

public class InputHandler implements MouseListener, MouseMotionListener, KeyListener{
    private boolean[] keys = new boolean[256];  // keyboard buttons
    private boolean[] states = new boolean[10]; //mouse buttons
    private int      mouseX = 0; // mouse X position
    private int      mouseY = 0; // mouse Y position

    public InputHandler() {
        mouseX = 0;
        mouseY = 0;
    }

    public boolean[] getKeys() { return keys; }

    // Properties
    public int getX() { return mouseX; }
    public int getY() { return mouseY; }
    public void reset() { for ( int i = 0; i < keys.length; i++ ) keys[i] = false; }
    public boolean isKeyDown( int k ) { return keys[k]; }
    public boolean isAnyKeyDown() { for( int i = 0; i < keys.length; i++ ) { if ( keys[i] ) return true; } return false; }
    public boolean isMouseButtonDown( int k ) { return states[k]; }

    // Keyboard events
    public void keyPressed(KeyEvent e)  { int k = e.getKeyCode(); if ( k < 256 ) keys[k] = true;  }
    public void keyReleased(KeyEvent e) { int k = e.getKeyCode(); if ( k < 256 ) keys[k] = false; }
    public void keyTyped(KeyEvent e)    { }

    // Mouse events
    public void mouseMoved(MouseEvent e){
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    } // mouseMoved

    public void mousePressed( MouseEvent e ) { states[e.getButton()] = true; }
    public void mouseReleased( MouseEvent e ) { states[e.getButton()] = false; }
    public void mouseEntered( MouseEvent e ) { mouseMoved( e ); }
    public void mouseExited( MouseEvent e ) { mouseMoved( e ); }
    public void mouseDragged( MouseEvent e ) { mouseMoved( e ); }
    public void mouseClicked( MouseEvent e ) { }
} // InputHandler

