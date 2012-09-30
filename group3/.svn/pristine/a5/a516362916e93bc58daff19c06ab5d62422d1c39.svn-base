/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.engine;

import civ.UI.CityView;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CityUnitSelectWindowHandler implements WindowListener {
    private CityView view;
    
    public CityUnitSelectWindowHandler(CityView view) {
        this.view = view;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        view.setEnabled(false);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        view.unitSelected();
        view.setEnabled(true);
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
