/*
 * Returns terrainInfo about a MapLocation
 */

package civ.engine;
import java.io.*;
import civ.MapLocation;
import civ.TerrainInfo;
import civ.World;
import civ.Tile;
import civ.enums.TerrainType;
import civ.enums.TerrainBonusType;
import java.util.EnumMap;
import java.util.logging.Logger;

public class TerrainManager implements Serializable {
    private EnumMap<TerrainType, TerrainInfo> terrainInfoMap;
    private EnumMap<TerrainBonusType, TerrainBonusInfo> bonusInfoMap;
    private World world;
    
    transient BufferedReader reader;
    
    public TerrainManager(World world) {
        terrainInfoMap = new EnumMap<TerrainType, TerrainInfo>(TerrainType.class);
        bonusInfoMap = new EnumMap<TerrainBonusType, TerrainBonusInfo>(TerrainBonusType.class);
        this.world = world;
        loadTerrainInfo();
        loadBonusInfo();
    }

    public TerrainInfo getTerrainInfo(MapLocation mapLocation) {
        Tile tile = world.getTile(mapLocation);
        return gatherInfo(tile);
    }

    private TerrainInfo clone(TerrainInfo ti)
    {
        return new TerrainInfo(ti.getFoodResource(), ti.getProductionResource(), ti.getDefenseBonus(), ti.getMovementCost(), ti.getCombatModifier(), ti.getScienceResource());

    }

    private TerrainInfo gatherInfo(Tile t)
    {
        TerrainInfo result = clone(terrainInfoMap.get(t.getTerrainType()));
        TerrainBonusInfo tbi = bonusInfoMap.get(t.getBonusType());
        result.setFoodResource(result.getFoodResource() + tbi.Food);
        result.setProductionResource(result.getProductionResource() + tbi.Production);
        result.setScienceResource(result.getScienceResource() + tbi.Science);
        //Modify the movement cost for a river.
        if(t.riverPresent()) result.setMovementCost(Math.max(result.getMovementCost()/3, 1));
        return result;
    }

    private void loadTerrainInfo() {
        TerrainInfo terrainInfo;        
        try {
            reader = new BufferedReader(new FileReader(new File("resources/spec/terraintype.jspec")));
            String line;
            String [] values;
            reader.readLine();
            while((line = reader.readLine()) != null) {
                values = line.split(" ");
                terrainInfo = createTerrainInfo(values);
                terrainInfoMap.put(TerrainType.valueOf(values[0]), terrainInfo);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger("Error instantiating unit types");
        }
    }
    
    public TerrainInfo createTerrainInfo(String[] attributes) {
        TerrainInfo tR = new TerrainInfo (
            Integer.parseInt(attributes[1]),
            Integer.parseInt(attributes[2]),
            Integer.parseInt(attributes[3]),
            Integer.parseInt(attributes[4]),
            Float.parseFloat(attributes[5]),
            Integer.parseInt(attributes[6])
        );      
        
        return tR;
    }

    private void loadBonusInfo()
    {
        TerrainBonusInfo info;
        try {
            reader = new BufferedReader(new FileReader(new File("resources/spec/terrainBonus.jspec")));
            String line;
            String [] values;
            reader.readLine();
            while((line = reader.readLine()) != null) {
                values = line.split(" ");
                info = new TerrainBonusInfo(Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                bonusInfoMap.put(TerrainBonusType.valueOf(values[0]), info);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger("Error instantiating terrain bonus information");
        }
    }

    private class TerrainBonusInfo implements Serializable
    {
        public int Food;
        public int Production;
        public int Science;

        public TerrainBonusInfo(int f, int p, int s)
        {
            this.Food = f;
            this.Production = p;
            this.Science = s;
        }
    }
    
}
