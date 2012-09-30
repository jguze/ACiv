/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.engine;

import civ.City;
import civ.MapLocation;
import civ.World;
import civ.enums.CityStyle;
import java.util.ArrayList;
import java.util.EnumMap;


public class CityManager {
    World world;
    
    public CityManager(World world) {
        this.world = world;
    }
    
    public City createCity(CityStyle type, MapLocation mapLocation) {
        City city = new City(type, mapLocation);
        findAvailableResources(city);
        return city;
    }
    
    public void findAvailableResources(City city) {
        MapLocation topLeftLocation = new MapLocation(city.getMapLocation().x - city.getRadius(),
                city.getMapLocation().y - city.getRadius());
        
        if (topLeftLocation.x < 0) {
            topLeftLocation.x = world.getMap().getMapWidth() - topLeftLocation.x;
        }
        if (topLeftLocation.y < 0) {
            topLeftLocation.y = 0;
        }
        
        ArrayList<MapLocation> resourceList = new ArrayList<MapLocation>();
        
        for (;topLeftLocation.y < city.getRadius() || topLeftLocation.y > world.getMap().getMapHeight(); topLeftLocation.y++) {
            for (int i = topLeftLocation.x; i < city.getRadius(); i++) {
                if (i > world.getMap().getMapWidth()) {
                    i = 0;
                }
                
                resourceList.add(new MapLocation(i, topLeftLocation.y));
                
            }
        }
        
        city.setAvailableResources(resourceList);       
    }
}
