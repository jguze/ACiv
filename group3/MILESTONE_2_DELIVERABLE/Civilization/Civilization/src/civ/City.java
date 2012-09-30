package civ;

import civ.enums.CityStyle;
import java.util.ArrayList;

public class City {
    
    private MapLocation mapLocation;
    private int level;
    private ArrayList<MapLocation> availableResources;
    private Player owner;
    private int citizens;
    private ArrayList<Integer> citizenFeelings;
    private CityStyle style;
    private int radius = 5;

    public City(CityStyle type, MapLocation mapLocation) {
        this.style = type;
        this.mapLocation = mapLocation;
    }

    public ArrayList<MapLocation> getAvailableResources() {
        return availableResources;
    }

    public void setAvailableResources(ArrayList<MapLocation> availableResources) {
        this.availableResources = availableResources;
    }

    public ArrayList<Integer> getCitizenFeelings() {
        return citizenFeelings;
    }

    public void setCitizenFeelings(ArrayList<Integer> citizenFeelings) {
        this.citizenFeelings = citizenFeelings;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public CityStyle getStyle() {
        return style;
    }

    public void setStyle(CityStyle style) {
        this.style = style;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
