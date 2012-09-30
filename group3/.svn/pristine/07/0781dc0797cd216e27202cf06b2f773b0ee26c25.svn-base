/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.engine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class WindowHandler implements WindowListener {
    
    private GameEngine gameEngine;

    public WindowHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine; 
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        gameEngine.disableCivFrame();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        gameEngine.enableCivFrame();
        gameEngine.updatePlayerInfo();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

}
