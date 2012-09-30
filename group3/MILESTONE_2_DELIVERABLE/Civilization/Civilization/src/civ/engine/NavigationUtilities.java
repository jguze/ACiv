/*
 * Finds the best route to a specific location given a MapLocation
 */

package civ.engine;

import civ.MapLocation;
import civ.Unit;
import civ.World;
import java.util.ArrayList;

public class NavigationUtilities {
    private World world;
    
    public NavigationUtilities(World world) {
        this.world = world;
    }
    
    public ArrayList<MapLocation> getRoute(MapLocation currentLocation, MapLocation desiredLocation, Unit selectedUnit) {
        return null;
    }
}
