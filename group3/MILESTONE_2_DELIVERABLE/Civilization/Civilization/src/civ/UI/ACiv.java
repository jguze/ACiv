/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.UI;

import javax.swing.*;
/**
 *
 * @author paulhunter
 */
public class ACiv
{
    //Starting part of the application for opening the UI
    public static void main(String[] args) {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException cnfe) {
        } catch (InstantiationException ie) {
        } catch (IllegalAccessException iae) {
        }
        CivFrame civ = new CivFrame();
    }
}
