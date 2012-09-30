package civ;

import civ.UI.MiniMapView;
import civ.engine.GameEngine;
import java.io.*;
import civ.SaveObject;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * A class to save the current gameEngine object to a file and
 * to load an existing gameEngine to a file.
 * @author Justin
 */
public class SaveModule {
    private static SaveModule saveModule;
    private static final boolean DEBUG = true;
    private static final String directory = "saveFiles";
    private static final String extension = "sav";
    
    /**
     * Private constructor for Singleton
     */
    private SaveModule() {
        
    }
    
    public static SaveModule getInstance() {
        if (saveModule == null) {
            saveModule = new SaveModule();
        }
        
        return saveModule;
    }
    
    /**
     * Saves any game objects to a file
     * @param saveObj The saveObject to save to the file
     * @return a boolean that determines whether the save was successful or not
     */
    public boolean save(SaveObject saveObj) {
        try {
            int numOfFiles = new File(directory).list().length;
            String saveName = "save" + numOfFiles;
            saveName = JOptionPane.showInputDialog("Choose a name for your save file", saveName);
            if (saveName == null) {
                return false;
            }
            FileOutputStream saveFile = new FileOutputStream(directory + "/" + saveName + "." + extension);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(saveObj);
            save.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Could not save game");
            if (DEBUG) {
                ioe.printStackTrace();
            }
            return false;
        }
        JOptionPane.showMessageDialog(null, "Saved Game");
        return true;
    }
    
    /**
     * Loads game objects from a file
     * @param filename a string representing the name of a file
     * @return the SaveObject to load
     */
    public SaveObject load() {
        ObjectInputStream load = null;
        try {
            File file = createFileChooser();
            if (file == null) return null;
            if (!isDotSav(file.getName())) {
                JOptionPane.showMessageDialog(null, "File is not a valid save file");
                return null;
            }
            FileInputStream loadFile = new FileInputStream(file);
            load = new ObjectInputStream(loadFile);
            return (SaveObject) load.readObject();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No files are available");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Could not load file");
        }        
        JOptionPane.showMessageDialog(null, "Load unsuccessful");
        return null;
    }
    
    private File createFileChooser() {
        JFileChooser chooser = new JFileChooser(directory);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
        
    }

    private boolean isDotSav(String filename) {
        Scanner scanner = new Scanner(filename);
        if (scanner.hasNext("([^\\s]+(\\.(?i)(sav))$)")) {
            return true;
        }
        return false;
    }

}
