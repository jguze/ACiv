package civ.engine;

import civ.*;
import civ.UI.MapView;
import civ.enums.CityStyle;
import civ.enums.UnitType;
import java.awt.image.BufferedImage;
import civ.sprites.SpriteUtils;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameEngine {
    
    private World world;
    private SpriteUtils spriteUtils;
    private UnitManager unitManager;
    private CityManager cityManager;
    private NavigationUtils navUtils;
    private CombatManager combatManager;
    private MapView mapView;
    
    private int turnCount;
    
    private Player currentPlayer;
    private Unit currentlySelectedUnit;
    
    private char selectedAction; // Last selected action

    //Getter for world (used by the mapView and miniMapView)
    public World getWorld()
    {
        return world;
    }

    //THIS IS NOT COMPLETE!
    //FINISH ME SOME OTHER TIME ;)
    public GameEngine()
    {
        try
        {
            world = World.createTileTestWorld();
            unitManager = new UnitManager(world);
            cityManager = new CityManager(world);
            currentPlayer = new Player();
            createUnit(UnitType.WARRIORS, new MapLocation(0,0));
            createCity(CityStyle.MODERN, new MapLocation(1,1));
            createCity(CityStyle.ASIAN, new MapLocation(2,2));
            createCity(CityStyle.TROPICAL, new MapLocation(3,3));
            spriteUtils = new SpriteUtils(world);
            navUtils = new NavigationUtils(world);
            combatManager = new CombatManager();
            selectedAction = ' ';
            currentPlayer.setId(1);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public SpriteUtils getSpriteUtility()
    {
        return spriteUtils;
    }
    
    public void createUnit(UnitType type, MapLocation location) {
        Unit unit = unitManager.createUnit(type);
        unit.setOwnerId(currentPlayer.getId());
        unit.setMapLocation(location);
        world.getUnitList(location).add(unit);
    }
    
    public void createCity(CityStyle type, MapLocation mapLocation) {
        City city = cityManager.createCity(type, mapLocation);
        city.setLevel(1);
        city.setMapLocation(mapLocation);
        city.setOwner(currentPlayer);
        world.addCity(city);
    }

    public void findMapEntity(MapLocation interactionLocation){
        // Call world.getCity()
        // Compare city owner to current player
        // If so, then open city dialog
            // Dialog interacted with
                // Dialog has a reference to a city that will be modified and thus updated (passed by reference)
                // TODO: Activiate units supported by the city
        // If city is null
            // Call world.getUnits() (check for units)
            // Look at returned unit list, compare owners, and populate another list with units owned by current player
            // Pop UnitViewer Dialog (make sure we know whose units are whose)
                // If players units, then they select one and currentlySelectedUnit = this selection
                // Get sprite of currently selected unit from SpriteUtils
                // Call mapView.highlght();    
    }
    
    // Knows there is a selected unit and a command, now wait to determine what to do.
    public void setCommand(char key){
        selectedAction = key;
    }
    
    public char getCommand() {
        return selectedAction;
    }

    //desired
    public void moveUnit(MapLocation desiredLocation) {
        //ArrayList<MapLocation> moveList = navUtils.getRoute(currentlySelectedUnit, desiredLocation);
        if (currentlySelectedUnit == null) {
            return;
        }
        MapLocation previousLocation = currentlySelectedUnit.getMapLocation();
        
        if(previousLocation.compare(desiredLocation)){
            currentlySelectedUnit = null;
            mapView.drawTile(desiredLocation);
            return;
        }
        
        ArrayList<MapLocation> moveList = new ArrayList<MapLocation>();
        moveList.add(desiredLocation);
        for (MapLocation moveTo : moveList) {
            if (isEnemyObstacle(moveTo)) {
                combatManager.collision(currentlySelectedUnit, moveTo);
                break;
            }
            world.getUnitList(currentlySelectedUnit.getMapLocation()).remove(currentlySelectedUnit);
            currentlySelectedUnit.setMapLocation(moveTo);
            world.getUnitList(moveTo).add(currentlySelectedUnit);
            mapView.drawMovedUnit(previousLocation, moveTo);
        }
        currentlySelectedUnit = null;
    }
    
    private boolean isEnemyObstacle(MapLocation mapLocation) {
        if (isEnemyCity(mapLocation) || isEnemyUnit(mapLocation)) {
            return true;
        }   
        return false;
    }
    
    private boolean isEnemyUnit(MapLocation mapLocation) {

        if (world.getUnitList(mapLocation).isEmpty()) {
            return false;
        } else if (world.getUnitList(mapLocation).get(0).getOwnerId() == currentPlayer.getId()) {
            return false;
        } else {
            return true;
        }
   }     
 
   private boolean isEnemyCity(MapLocation mapLocation) {
        City isCity = world.getCity(mapLocation);
        if (isCity == null) {
            return false;
        } else if (isCity.getOwner().equals(currentPlayer)) {
            return false;
        } else {
            return true;
        }
   }
        
    public void selectUnit(MapLocation click) {
        ArrayList<Unit> unitList = world.getUnitList(click);
        // Redraw the current location tile in case another tile was selected.
        if (currentlySelectedUnit != null) {
            mapView.drawTile(currentlySelectedUnit.getMapLocation());
        }
        
        if(!unitList.isEmpty()) {
            currentlySelectedUnit = unitList.get(0);
            mapView.highlight(getSpriteUtility().getHighlight(), click);
        } else {
            currentlySelectedUnit = null;
            mapView.highlight(getSpriteUtility().getHighlight(), click);
        }
    }
    
   public Unit getCurrentlySelectedUnit() {
        return currentlySelectedUnit;
   }

   public MapLocation getCurrentlySelectedUnitTile() {
        return currentlySelectedUnit.getMapLocation();
   }    

   public void setMapView(MapView mV) {
        mapView = mV;
   }
   
   public BufferedImage getTerrainSprite(MapLocation mapLocation) {
       return spriteUtils.getTerrainSprite(mapLocation);
   }
   
   public BufferedImage getUnitSprite(MapLocation mapLocation) {
       return spriteUtils.getUnitSprite(mapLocation);
   }
   
   public BufferedImage getCitySprite(MapLocation mapLocation) {
       return spriteUtils.getCitySprite(mapLocation);
   }
    
}
