/*
 * Returns terrainInfo about a MapLocation
 */

package civ.engine;

import civ.MapLocation;
import civ.TerrainInfo;
import civ.Unit;
import civ.World;
import civ.enums.UnitTravelType;
import civ.enums.UnitType;
import java.io.*;
import java.util.EnumMap;
import java.util.logging.Logger;

public class UnitManager implements Serializable {
    private EnumMap<UnitType, Unit> unitMap;
    private World world;
    
    transient BufferedReader reader;    
    
    public UnitManager(World world) {
        unitMap = new EnumMap<UnitType, Unit>(UnitType.class);
        loadUnits();
        this.world = world;
    }
    
    public Unit createUnit(UnitType type) {
        return new Unit(unitMap.get(type));
    }
    
    //Get unit information about a specific unit.
    //DO NOT USE TO CREATE UNITS
    public Unit getUnitInfo(UnitType type) {
        return unitMap.get(type);
    }
    
    // Load all types of units from unit.jspec and store them in the unitMap data map.
    private void loadUnits() {
        Unit unit;        
        try {
            reader = new BufferedReader(new FileReader(new File("resources/spec/units.jspec")));
            String line;
            String [] values;
            reader.readLine();
            while((line = reader.readLine()) != null) {
                values = line.split(" ");
                unit = createUnitTemplate(values);
                unitMap.put(unit.getUnitType(), unit);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger("Error instantiating unit types");
        }
    }        
    
    /* Create unit template from jspec file attributes */
    private Unit createUnitTemplate(String [] attributes)
    {
        Unit unit = new Unit(
                UnitType.valueOf(attributes[0]),
                Integer.parseInt(attributes[1]),
                Integer.parseInt(attributes[2]),
                Integer.parseInt(attributes[3]),
                Integer.parseInt(attributes[4]),
                UnitTravelType.valueOf(attributes[5]),
                Integer.parseInt(attributes[6]),
                Integer.parseInt(attributes[7]),
                Integer.parseInt(attributes[8]));
        
        return unit;
    }
}
