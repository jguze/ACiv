/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.engine;

import civ.UI.CivFrame;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;


public class WindowUtils {
    public static void centerOnScreen(Frame frame, Dimension frameSize) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width - frameSize.width)/2,
                (dim.height - frameSize.height)/4);
    }
    
    public static void centerOnFrame(Frame frame, Dimension frameSize,
            CivFrame relativeFrame) {
        frame.setLocation(relativeFrame.getLocationOnScreen().x + (relativeFrame.frameSize.width / 2) - (frameSize.width / 2),
                relativeFrame.getLocationOnScreen().y + (relativeFrame.frameSize.height / 2) - (frameSize.height / 2));
    }
}
