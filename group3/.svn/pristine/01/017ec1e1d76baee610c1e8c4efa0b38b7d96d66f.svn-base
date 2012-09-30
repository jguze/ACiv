/*
 * Returns terrainInfo about a MapLocation
 */

package civ.engine;
import java.io.*;
import civ.MapLocation;
import civ.TerrainInfo;
import civ.World;
import civ.enums.TerrainType;
import java.util.EnumMap;

public class TerrainManager {
    private EnumMap<TerrainType, TerrainInfo> terrainInfoMap;
    private World world;
    
    public TerrainManager(World world) {
        terrainInfoMap = new EnumMap<TerrainType, TerrainInfo>(TerrainType.class);
        this.world = world;
    }
    
    public TerrainInfo getTerrainInfo(MapLocation mapLocation) {
        return terrainInfoMap.get(world.getTile(mapLocation).getTerrainType());
    }

    public boolean constructMap(BufferedReader mapFile)
    {
        return true;
    }
    
}
