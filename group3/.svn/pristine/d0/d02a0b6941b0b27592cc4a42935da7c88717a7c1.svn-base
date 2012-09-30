package civ.UI;

import civ.engine.GameEngine;
import civ.engine.WindowUtils;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Mark
 */
public class TextView extends JFrame {
    
    private Container cp = getContentPane();
    Scanner scan;
    JTextArea printArea;
    
    public TextView(String fileName){
        super("Document");
        
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.DARK_GRAY);
        
        try{
            scan = new Scanner(new File(fileName));
        }catch(FileNotFoundException e){
//            e.printStackTrace();
        }
        printArea = new JTextArea(20,50);
        printArea.setEditable(false);
        printArea.setLineWrap(true);
        
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            printArea.append(line);
            printArea.append("\n");
        }
        printArea.setCaretPosition(0);
        JScrollPane sp = new JScrollPane(printArea);
        sp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
        cp.add(sp);
        WindowUtils.centerOnScreen(this, new Dimension(150, 300));
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }
}
