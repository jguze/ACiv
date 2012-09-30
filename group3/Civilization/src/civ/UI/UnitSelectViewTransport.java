package civ.UI;


import civ.MapLocation;
import civ.Unit;
import civ.World;
import civ.engine.GameEngine;
import civ.engine.WindowHandler;
import civ.engine.WindowUtils;
import civ.enums.TerrainType;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class UnitSelectViewTransport extends JFrame implements ListSelectionListener
{


    private Container cp;
    private JList list;
    private Unit transporter;

    private int IndexOfSelectedUnit;

    GameEngine game;
    ArrayList<Unit> unit;
    World worldy;

    public UnitSelectViewTransport(Unit transport, GameEngine gameEngine, World world){
        super("Contained Units");
        game = gameEngine;
        unit = transport.getList();
        transporter = transport;
        worldy = world;
        int i;

        game.setCurrentlySelectedUnit(transporter);

        String UnitList[] = new String[transport.getNumUnits()];

        for(i = 0; i < transport.getNumUnits(); i++){
            UnitList[i] = unit.get(i).getUnitType().toString();
        }

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        cp.setBackground(Color.DARK_GRAY);
        cp.setPreferredSize(new Dimension(200,200));
        WindowUtils.centerOnFrame(this, new Dimension(200, 200), (CivFrame) game.getCivFrame());

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Color.BLACK, WIDTH), "Select a Unit:"));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200,200));
        panel.setSize(298,298);
        panel.setVisible(true);

        this.list = new JList(unit.toArray());
        this.list.setCellRenderer(new ImageRenderers(gameEngine));
        this.list.setVisibleRowCount(5);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(150,165));
        list.addListSelectionListener(this);

        panel.add(scrollPane);
        cp.add(panel);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.addWindowListener(new WindowHandler(gameEngine));
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            game.setCurrentlySelectedUnit(null);
            IndexOfSelectedUnit = list.getSelectedIndex();
            MapLocation maploc = new MapLocation(transporter.getMapLocation());
            MapLocation maplocxw = new MapLocation(maploc.x-1,maploc.y);
            MapLocation maplocxe = new MapLocation(maploc.x+1,maploc.y);
            MapLocation maplocyu = new MapLocation(maploc.x,maploc.y+1);
            MapLocation maplocyd = new MapLocation(maploc.x,maploc.y-1);

            
            if(worldy.getTile(maploc).getTerrainType() == TerrainType.OCEAN){
                if(worldy.getTile(maplocxw).getTerrainType() != TerrainType.OCEAN){
                    game.setCurrentlySelectedUnit(unit.get(IndexOfSelectedUnit));
                    unit.get(IndexOfSelectedUnit).setMapLocation(maplocxw);
                    game.addUnit(unit.get(IndexOfSelectedUnit));
                    transporter.removeUnitTransport(unit.get(IndexOfSelectedUnit));
                }else if(worldy.getTile(maplocxe).getTerrainType() != TerrainType.OCEAN){
                    game.setCurrentlySelectedUnit(unit.get(IndexOfSelectedUnit));
                    unit.get(IndexOfSelectedUnit).setMapLocation(maplocxe);
                    game.addUnit(unit.get(IndexOfSelectedUnit));
                    transporter.removeUnitTransport(unit.get(IndexOfSelectedUnit));
                }else if(worldy.getTile(maplocyu).getTerrainType() != TerrainType.OCEAN){
                    game.setCurrentlySelectedUnit(unit.get(IndexOfSelectedUnit));
                    unit.get(IndexOfSelectedUnit).setMapLocation(maplocyu);
                    game.addUnit(unit.get(IndexOfSelectedUnit));
                    transporter.removeUnitTransport(unit.get(IndexOfSelectedUnit));
                }else if(worldy.getTile(maplocyd).getTerrainType() != TerrainType.OCEAN){
                    game.setCurrentlySelectedUnit(unit.get(IndexOfSelectedUnit));
                    unit.get(IndexOfSelectedUnit).setMapLocation(maplocyd);
                    game.addUnit(unit.get(IndexOfSelectedUnit));
                    transporter.removeUnitTransport(unit.get(IndexOfSelectedUnit));
                }
            }else if(worldy.getTile(maploc).getTerrainType() != TerrainType.OCEAN){
                game.setCurrentlySelectedUnit(unit.get(IndexOfSelectedUnit));
                unit.get(IndexOfSelectedUnit).setMapLocation(transporter.getMapLocation());
                game.addUnit(unit.get(IndexOfSelectedUnit));
                transporter.removeUnitTransport(unit.get(IndexOfSelectedUnit));
            }            
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
      }
}
class ImageRenderers extends DefaultListCellRenderer{
    
    private GameEngine game;
    
    ImageRenderers(GameEngine gE){
        game = gE;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){   
        // for default cell renderer behavior
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        // set icon for cell image
        ((JLabel)c).setIcon(new ImageIcon((BufferedImage)game.getUnitSprite(((Unit)value).getUnitType())));
        ((JLabel)c).setText(((Unit)value).getUnitType().toString());
        return c;
    }
  }

