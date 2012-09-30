/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ;

import org.junit.Test;
import static org.junit.Assert.*;

public class WorldTest {
    
    @Test
    public void testUnitLoad() {
        Tile[][] tileset = new Tile[5][5];
        Map map = new Map(tileset);
        MapLocation mapLocation = new MapLocation(0,0);
        World world = new World(map);
        System.out.println(map.getMapHeight() + " " + map.getMapWidth());
        
        for (int i = 0; i < map.getMapHeight(); i++) {
            for (int j = 0; j < map.getMapWidth(); j++) {
                mapLocation.x = j;
                mapLocation.y = i;
                assertNotNull(world.getUnitList(mapLocation));
            }
        }
    }
}
