package civ.UI;

import civ.Player;
import civ.SaveModule;
import civ.SaveObject;
import civ.engine.GameEngine;
import civ.engine.WindowUtils;
import civ.enums.CityStyle;
import civ.enums.CountryFlags;
import civ.maps.MapInfo;
import civ.sprites.SpriteUtils;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/*
 * Mark's, no touchy.
 */

public class SplashView extends JFrame implements ActionListener{
    
    JButton newGame, loadGame, startGame, cancelGame;
    
    JFrame newFrame = new JFrame("New Window");
    JPanel BackPanel = new JPanel();
    JPanel BottomPanel = new JPanel();
    JPanel mapInfoPanel = new JPanel();
    JPanel playerOptions = new JPanel();

    JComboBox amountofplayers, selectingTheMap;
    JComboBox[] playerRaces = new JComboBox[8];
    JComboBox[] playerFlags = new JComboBox[8];
    JLabel SelectNum, SelectMap, MapInfo;
    JLabel mapDescription, mapPlayers, mapSize;
    JLabel nameTitle, cityStyleTitle, flagTitle;
    JButton mapPreview;
    JLabel[] playerLabels = new JLabel[8];

    CivFrame civframe;

    ArrayList<Player> PlayerData = new ArrayList(8);
    JTextField[] playerNames = new JTextField[8];
    JCheckBox spawnType = new JCheckBox("Use random spawn locations");
    ArrayList<MapInfo> info = civ.maps.MapInfoCollector.getMapInfos();

    private int numberofplayers;
    private String[] selectNum = new String[8];
    private String filePath = null;
    private Boolean spawn = true;
    
    MapInfo selectedMap = new MapInfo();
    
    private GameEngine civEngine; 
    private Container cp = getContentPane();
    
    public SplashView(){
        super("ACiv Setup");
        for(int i = 0; i < 8; i++){
            selectNum[i] = (Integer.toString(i+1));
        }

        cp.setLayout(createLayout());
        cp.setBackground(Color.BLACK);
        
        GridBagConstraints c = new GridBagConstraints();
        
        BackPanel.setBackground(Color.DARK_GRAY);
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        cp.add(BackPanel, c);
        
        BottomPanel.setBackground(Color.DARK_GRAY);
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        cp.add(BottomPanel, c);
        
        try{
            BufferedImage myPicture = ImageIO.read(new File("resources/UI stuff/pic for Splash.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
            BackPanel.add(picLabel);
        } catch (IOException e){
            e.printStackTrace();
        }
        
        newGame = new JButton("New Game");
        newGame.setBackground(Color.LIGHT_GRAY);
        newGame.setForeground(Color.BLACK);
        newGame.addActionListener(this);
        
        loadGame = new JButton("Load Game");
        loadGame.setBackground(Color.LIGHT_GRAY);
        loadGame.setForeground(Color.BLACK);
        loadGame.addActionListener(this);
        
        BottomPanel.add(newGame);
        BottomPanel.add(loadGame);
        
        this.setSize(850, 600);
        WindowUtils.centerOnScreen(this, new Dimension(850, 600));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelGame){
            this.setVisible(false);
            this.dispose();
            SplashView SV = new SplashView();
        }
        
        if (e.getSource() == newGame) {
            Initialization();
        } 
        
        if (e.getSource() == selectingTheMap){
            JComboBox a = (JComboBox)e.getSource();
            selectedMap = (MapInfo)a.getSelectedItem();
            mapChange();
        }
              
        if (e.getSource() == amountofplayers){
            JComboBox a = (JComboBox)e.getSource();
            numberofplayers = Integer.parseInt(a.getSelectedItem().toString());
            playerOptionSetup();
        }
            
        
        if (e.getSource() == startGame){
            for(int i = 0; i < numberofplayers; i++){
                PlayerData.add(new Player());
                String temp = playerRaces[i].getSelectedItem().toString();
                String temp2 = playerFlags[i].getSelectedItem().toString();
                if (temp.equals("ASIAN")) PlayerData.get(i).setBuildingStyle(CityStyle.ASIAN);
                if (temp.equals("EUROPEAN")) PlayerData.get(i).setBuildingStyle(CityStyle.EUROPEAN);
                if (temp.equals("CLASSICAL")) PlayerData.get(i).setBuildingStyle(CityStyle.CLASSICAL);
                if (temp.equals("INDUSTRIAL")) PlayerData.get(i).setBuildingStyle(CityStyle.INDUSTRIAL);
                if (temp.equals("MODERN")) PlayerData.get(i).setBuildingStyle(CityStyle.MODERN);
                if (temp.equals("POSTMODERN")) PlayerData.get(i).setBuildingStyle(CityStyle.POSTMODERN);
                if (temp.equals("TROPICAL")) PlayerData.get(i).setBuildingStyle(CityStyle.TROPICAL);
                
                if (temp2.equals("USA")) PlayerData.get(i).setCountry(CountryFlags.USA);
                if (temp2.equals("CZECH")) PlayerData.get(i).setCountry(CountryFlags.CZECH);
                if (temp2.equals("GERMANY")) PlayerData.get(i).setCountry(CountryFlags.GERMANY);
                if (temp2.equals("PIRATES")) PlayerData.get(i).setCountry(CountryFlags.PIRATES);
                if (temp2.equals("CANADA")) PlayerData.get(i).setCountry(CountryFlags.CANADA);
                if (temp2.equals("TURKEY")) PlayerData.get(i).setCountry(CountryFlags.TURKEY);
                if (temp2.equals("TAIWAN")) PlayerData.get(i).setCountry(CountryFlags.TAIWAN);
                if (temp2.equals("SWITZERLAND")) PlayerData.get(i).setCountry(CountryFlags.SWITZERLAND);
                if (temp2.equals("SOMALIA")) PlayerData.get(i).setCountry(CountryFlags.SOMALIA);
                if (temp2.equals("NORWAY")) PlayerData.get(i).setCountry(CountryFlags.NORWAY);
                if (temp2.equals("JAPAN")) PlayerData.get(i).setCountry(CountryFlags.JAPAN);
                if (temp2.equals("JAMAICA")) PlayerData.get(i).setCountry(CountryFlags.JAMAICA);

                PlayerData.get(i).setName(playerNames[i].getText());
            }
            if(spawnType.isSelected()) spawn = false;
            civEngine = new GameEngine(numberofplayers, filePath, PlayerData, spawn);
            SpriteUtils.getInstance().setEngine(civEngine);
            this.setVisible(false);
            this.dispose();
            CivFrame civ = new CivFrame(civEngine);
            civframe = civ;
        }
        
        if (e.getSource() == loadGame){
            loadSaveGame();
        }

        //If you click on the map preview label, we want to pop a dialog that has the preview of the map
        if(e.getSource() == mapPreview)
        {
            String[] values = mapSize.getText().split("x");
            int width = Integer.parseInt(values[0]);
            int height = Integer.parseInt(values[1]);

            int ratio = 6;
            int optiWidthRatio = 500/width;
            int optiHeightRatio = 500/height;
            optiWidthRatio = optiWidthRatio<optiHeightRatio?optiWidthRatio:optiHeightRatio;
            ratio = ratio<optiWidthRatio?ratio:optiWidthRatio;

            
            //Lol, if this works first try, I'm a genious
            SpriteUtils.getInstance().setWorld(civ.World.createWorld(filePath));
            BufferedImage preview = MiniMapView.GenerateMapImage(0, 0, width, height, ratio, ratio*width, ratio*height, 0, 0, width, height);

            this.setEnabled(false);
            this.setFocusableWindowState(false);
            MapPreviewView previewView = new MapPreviewView(selectedMap.name, preview, this);
  
        }
    }

    private GridBagLayout createLayout(){
        GridBagLayout GBL = new GridBagLayout();
        GBL.columnWidths = new int[] {800, 0};
        GBL.rowHeights = new int[] {450, 50};
        return GBL;
    }
    private GridBagLayout SelectLayout(){
        GridBagLayout GBL = new GridBagLayout();
        GBL.columnWidths = new int[] {350, 490};
        GBL.rowHeights = new int[] {150, 408};
        return GBL;
    }
    private GridBagLayout OptionsLayout(){
        GridBagLayout GBL = new GridBagLayout();
        GBL.columnWidths = new int[] {330, 0, 0};
        GBL.rowHeights = new int[] {47, 47, 46};
        return GBL;
    }
    private GridBagLayout RaceLayout(){
        GridBagLayout GBL = new GridBagLayout();
        GBL.columnWidths = new int[] {160, 275, 190, 190};
        GBL.rowHeights = new int[] {38, 38, 38, 38, 38, 38, 38, 38, 38, 38};
        return GBL;
    }
    private GridBagLayout MapInfoLayout(){
        GridBagLayout GBL = new GridBagLayout();
        GBL.columnWidths = new int[] {239, 239};
        GBL.rowHeights = new int[] {26, 26, 26, 26, 26};
        return GBL;
    }

    private void loadSaveGame() {
        SaveObject save = SaveModule.getInstance().load();
        if (save == null) {
            return;
        }
            
        this.setVisible(false);
        this.dispose();
        CivFrame civ = new CivFrame(save);
    }
    
    private void playerOptionSetup(){
            playerOptions.removeAll();
            GridBagConstraints c = new GridBagConstraints();

            nameTitle = new JLabel("Player Name");
            nameTitle.setForeground(Color.WHITE);
            c.gridy = 0;
            c.gridx = 1;
            playerOptions.add(nameTitle, c);
            cityStyleTitle = new JLabel("City Style");
            cityStyleTitle.setForeground(Color.WHITE);
            c.gridy = 0;
            c.gridx = 2;
            playerOptions.add(cityStyleTitle, c);
            flagTitle = new JLabel("Country");
            flagTitle.setForeground(Color.WHITE);
            c.gridy = 0;
            c.gridx = 3;
            playerOptions.add(flagTitle, c);

            for(int i = 0; i < numberofplayers; i++){
                if(i == selectedMap.numberOfPlayers && i != 0){
                    amountofplayers.setSelectedIndex(selectedMap.numberOfPlayers-1);
                    numberofplayers = i;
                    break;
                }
                playerLabels[i] = new JLabel("Player" + (Integer.toString(i+1)));
                playerLabels[i].setForeground(Color.WHITE);
                playerRaces[i] = new JComboBox(CityStyle.values());
                playerRaces[i].setVisible(true);
                playerRaces[i].setSelectedItem(CityStyle.EUROPEAN);
                playerRaces[i].addActionListener(this);
                playerFlags[i] = new JComboBox(CountryFlags.values());
                playerFlags[i].setVisible(true);
                playerFlags[i].setSelectedItem(CountryFlags.GERMANY);
                playerFlags[i].addActionListener(this);
                playerNames[i] = new JTextField("Player" + Integer.toString(i+1), 25);
                c.gridy = i+1;
                c.gridx = 0;
                playerOptions.add(playerLabels[i], c);
                c.gridx = 1;
                playerOptions.add(playerNames[i], c);
                c.gridx = 2;
                playerOptions.add(playerRaces[i], c);
                c.gridx = 3;
                playerOptions.add(playerFlags[i], c);
            }

            startGame = new JButton("Start Game");
            startGame.setBackground(Color.LIGHT_GRAY);
            startGame.setForeground(Color.BLACK);
            startGame.addActionListener(this);
            c.gridx = 3;
            c.gridy = 9;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            playerOptions.add(startGame, c);
            
            cancelGame = new JButton("Cancel");
            cancelGame.setBackground(Color.LIGHT_GRAY);
            cancelGame.setForeground(Color.BLACK);
            cancelGame.addActionListener(this);
            c.gridx = 0;
            c.gridy = 9;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            playerOptions.add(cancelGame, c);

            validate();
            repaint();
    }
    
    private void Initialization(){
            BackPanel.removeAll();
            BottomPanel.removeAll();
            cp.removeAll();

            cp.setLayout(SelectLayout());
            GridBagConstraints c = new GridBagConstraints();

            BottomPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
            c.insets = new Insets(5,5,5,5);
            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            cp.add(BottomPanel, c);
            BottomPanel.setLayout(OptionsLayout());

            mapInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
            mapInfoPanel.setBackground(Color.DARK_GRAY);
            c.gridx = 1;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            cp.add(mapInfoPanel, c);
            mapInfoPanel.setLayout(MapInfoLayout());

            playerOptions.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
            playerOptions.setBackground(Color.DARK_GRAY);
            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            cp.add(playerOptions, c);
            playerOptions.setLayout(RaceLayout());
            
            SelectNum = new JLabel("Select Number Of Players");
            SelectNum.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.NONE;
            BottomPanel.add(SelectNum, c);

            amountofplayers = new JComboBox(selectNum);
            amountofplayers.setVisible(true);
            amountofplayers.addActionListener(this);
            amountofplayers.setSelectedItem(selectNum[0]);
            c.anchor = GridBagConstraints.EAST;
            BottomPanel.add(amountofplayers, c);
            
            playerOptionSetup();

            SelectMap = new JLabel("Select Map to Use");
            SelectMap.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.NONE;
            BottomPanel.add(SelectMap, c);

            selectingTheMap = new JComboBox();
            for(MapInfo ob : info){
                selectingTheMap.addItem(ob);
            }
            selectingTheMap.setVisible(true);
            selectingTheMap.addActionListener(this);
            selectingTheMap.setSelectedItem(info.get(0));
            c.anchor = GridBagConstraints.EAST;
            BottomPanel.add(selectingTheMap, c);

            spawnType.setBackground(Color.DARK_GRAY);
            spawnType.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 2;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            BottomPanel.add(spawnType, c);

            MapInfo = new JLabel("Map Information");
            MapInfo.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(MapInfo, c);
            
            validate();
            repaint();
    }
    
    private void mapChange(){
        GridBagConstraints c = new GridBagConstraints();

            mapInfoPanel.removeAll();

            MapInfo = new JLabel("Map Information");
            MapInfo.setForeground(Color.WHITE);
            c.insets = new Insets(5,5,5,5);
            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(MapInfo, c);

            MapInfo = new JLabel("Max Players:");
            MapInfo.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 2;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(MapInfo, c);

            MapInfo = new JLabel("Map Size:");
            MapInfo.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 3;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.WEST;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(MapInfo, c);

            mapDescription = new JLabel(selectedMap.description);
            mapDescription.setForeground(Color.WHITE);
            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(mapDescription, c);

            mapPlayers = new JLabel(Integer.toString(selectedMap.numberOfPlayers));
            mapPlayers.setForeground(Color.WHITE);
            c.gridx = 1;
            c.gridy = 2;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.EAST;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(mapPlayers, c);

            mapSize = new JLabel(selectedMap.size);
            mapSize.setForeground(Color.WHITE);
            c.gridx = 1;
            c.gridy = 3;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.anchor = GridBagConstraints.EAST;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(mapSize, c);

            mapPreview = new JButton("Map Preview");
            mapPreview.addActionListener(this);
            c.gridx = 0;
            c.gridy = 4;
            c.gridheight = 1;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            mapInfoPanel.add(mapPreview, c);

            filePath = selectedMap.completeFileName;

            validate();
            repaint();
            
            if(selectedMap.numberOfPlayers < numberofplayers){
                amountofplayers.setSelectedIndex(selectedMap.numberOfPlayers-1);
                playerOptionSetup();
            
            }
     }
}