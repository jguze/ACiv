/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.maps;

import civ.enums.TerrainType;
import java.io.*;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.ArrayList;
import civ.MapLocation;
import civ.Map;
import civ.Tile;
import civ.enums.TerrainBonusType;
import java.util.Random;
/**
 * The <code>MapGenerator</code> class is responsible for parsing .map
 * files and creates a map object that is returned to the caller. No need for
 * instantiation, simply call the static method.
 * @author paulhunter
 */
public class MapGenerator
{
    /**
     * Given a filename, <code>constructMap</code> will parse the file and
     * creates a <code>Map</code> which it then returns. It an IO error occurs
     * a null reference will be returned.
     * @param mapFilePath .map File to be parsed
     * @return A <code>Map</code> representation of the information parsed or null.
     */
    private static int PERCENT_BONUS = 3;


    public static Map constructMap(String mapFilePath)
    {
        int width = -1;
        int height = -1;
        Tile[][] terrain;
        HashMap<String, TerrainType> tileMap = new HashMap<String, TerrainType>();
        String line = "NoLineRead!";
        Map world;
        EnumMap<TerrainType, ArrayList<MapLocation>> landTiles = new EnumMap<TerrainType, ArrayList<MapLocation>>(TerrainType.class);
        for(TerrainType t :TerrainType.values())
        {
            landTiles.put(t, new ArrayList<MapLocation>());
        }

        boolean wraps = false;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(new File("resources/maps/maps.spec")));
            reader.readLine();
            String[] values;
            while((line = reader.readLine()) != null)
            {
                values = line.split("-");
                tileMap.put(values[0], TerrainType.valueOf(values[1]));
            }
            reader.close();

            BufferedReader mapFileReader = new BufferedReader(new FileReader(new File(mapFilePath)));
            while((line = mapFileReader.readLine()) != null)
            {
                if(line.startsWith("width="))
                    width = Integer.parseInt(line.substring(6));
                if(line.startsWith("height="))
                    height = Integer.parseInt(line.substring(7));
                if(line.startsWith("wraps="))
                    wraps = Boolean.parseBoolean(line.substring(6));
                if(line.startsWith("t000")) break;
            }
            terrain = new Tile[width][height];
            for(int x = 0; x < width; x++)
                for(int y = 0; y < height; y++)
                    terrain[x][y] = new Tile(x,y,TerrainType.GRASSLAND, TerrainBonusType.NONE,false, false, false, false);

            //Now that we have a complete map of meaningless tiles, its time to fill them in
            //with the correct type
            int y = 0;
            while(line != null)
            {
                line = line.substring(6,6+width);
                for(int x = 0; x < width; x++)
                {
                    TerrainType type = tileMap.get(line.charAt(x)+"");
                    terrain[x][y].setTerrainType(type);
                    landTiles.get(type).add(new MapLocation(x,y));
                }
                y++;
                line = mapFileReader.readLine();
                if(line != null && line.startsWith("r000")) break; //break when we are done reading
            }

            //Next comes the rivers, we continue to parse the map file and read in the
            //river attributes for tiles.
            //Note we dont need there to be river specs, it will simply not read them.
            y=0;
            while(line != null)
            {
                line = line.substring(6,6+width);
                for(int x = 0; x < width; x++)
                {
                    terrain[x][y].setRiver(line.charAt(x) == 'r');
                }
                y++;
                line = mapFileReader.readLine();
            }
            mapFileReader.close();

            world = new Map(terrain, wraps);

            Random r = new Random();
            for(TerrainType t : TerrainType.values())
            {
                ArrayList<MapLocation> locs = landTiles.get(t);
                int tot = locs.size();
                for(TerrainBonusType b : getApplicableBonuses(t))
                {
                    for(int x = 0; x < ((tot*PERCENT_BONUS)/100); x++)
                    {
                        int i = r.nextInt(locs.size());
                        MapLocation m = locs.get(i);
                        world.tileAt(m).setBonusType(b);
                        locs.remove(m);
                    } 
                }
            }

            landTiles.clear();
            return world;
            
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Line of error was: " + line);
            return null;
        }
        
    }

    static private TerrainBonusType[] getApplicableBonuses(TerrainType t)
    {
        if(t == TerrainType.DESERT) return new TerrainBonusType[] {TerrainBonusType.OASIS, TerrainBonusType.OIL};
        else if(t == TerrainType.FOREST) return new TerrainBonusType[]{TerrainBonusType.PHEASANT, TerrainBonusType.SILK};
        else if(t == TerrainType.GLACIER) return new TerrainBonusType[]{TerrainBonusType.IVORY, TerrainBonusType.OIL};
        else if(t == TerrainType.GRASSLAND) return new TerrainBonusType[]{TerrainBonusType.SHIELD, TerrainBonusType.SHIELD};
        else if(t == TerrainType.HILLS) return new TerrainBonusType[]{TerrainBonusType.COAL, TerrainBonusType.WINE};
        else if(t == TerrainType.JUNGLE) return new TerrainBonusType[]{TerrainBonusType.GEMS, TerrainBonusType.FRUIT};
        else if(t == TerrainType.MOUNTAINS) return new TerrainBonusType[]{TerrainBonusType.GOLD, TerrainBonusType.IRON};
        else if(t == TerrainType.OCEAN) return new TerrainBonusType[]{TerrainBonusType.FISH, TerrainBonusType.WHALE};
        else if(t == TerrainType.PLAINS) return new TerrainBonusType[]{TerrainBonusType.BUFFALO, TerrainBonusType.WHEAT};
        else if(t == TerrainType.SWAMP) return new TerrainBonusType[]{TerrainBonusType.PEAT, TerrainBonusType.SPICE};
        else return new TerrainBonusType[]{TerrainBonusType.FURS, TerrainBonusType.GAME};
    }
}
