package civ;

import civ.enums.TerrainBonusType;
import civ.enums.TerrainType;
import java.io.Serializable;

public class Tile implements Serializable{
    private TerrainType terrainType;
    private MapLocation mapLocation;
    private TerrainBonusType bonusType;
    private boolean hasRoad;
    private boolean hasMine;
    private boolean hasIrrigation;
    private boolean riverFlow;

    public Tile(int x, int y, TerrainType type, TerrainBonusType bonus, boolean road, boolean mine, boolean irrig, boolean rivflow)
    {
        this.mapLocation = new MapLocation(x,y);
        this.terrainType = type;
        this.bonusType = bonus;
        this.hasRoad = road;
        this.hasMine = mine;
        this.hasIrrigation = irrig;
        this.riverFlow = rivflow;
    }

    public boolean isRoadBuilt() {
        return hasRoad;
    }
    
    public boolean isMineBuilt() {
        return hasMine;
    }
    
    public boolean isIrrigationBuilt() {
        return hasIrrigation;
    }
    
    public TerrainBonusType getBonusType() {
        return bonusType;
    }

    public void setBonusType(TerrainBonusType bonusType) {
        this.bonusType = bonusType;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public void setTerrainType(TerrainType type) {
        this.terrainType = type;
    }
    
    public TerrainType getTerrainType() {
        return terrainType;
    }

    public void setRiver(boolean riv)
    {
        this.riverFlow = riv;
    }

    public boolean riverPresent()
    {
        return this.riverFlow;
    }
}
