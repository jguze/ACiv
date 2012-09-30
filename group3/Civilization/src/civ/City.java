package civ;

import civ.enums.CityStyle;
import civ.enums.TerrainType;
import civ.enums.UnitType;
import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    
    private static final double FOODGROWTH = 2.5;
    private static final int CITYRADIUS = 3;
    private static final double GOLDCONSTANT = 2.0;
    
    private MapLocation mapLocation;
    private int level;
    private ArrayList<MapLocation> availableResources;
    private Player owner;
    private int citizens;
    private ArrayList<Integer> citizenFeelings;
    private CityStyle style;
    private int radius;
    private String name;
    private UnitType currentlyProducing;
    private int prodTurnsRemaining;
    private ArrayList<Unit> units;
    private UnitType lastUnitProduced;
    private int lastUnitProdRemaining;
    //The weight that we decide which resources we pull.
    private WeightedResourceObj resourceWeight;
    private int production, science, food;
    public int prodBonus = 0, foodBonus = 0, sciBonus = 0;
    //Current amount of food in the city and the amount needed to grow in size.
    private int foodSupply, foodLimit;
    private int goldProduced;
    private int currentlyProdCost;

    public City(String name, CityStyle type, MapLocation mapLocation) {
        this.name = name;
        this.style = type;
        this.mapLocation = mapLocation;
        currentlyProducing = UnitType.NONE;
        lastUnitProduced = UnitType.NONE;
        prodTurnsRemaining = Integer.MAX_VALUE;
        lastUnitProdRemaining = prodTurnsRemaining;
        units = new ArrayList<Unit>();
        resourceWeight = new WeightedResourceObj(5,2,1);
        level = 1;
        foodSupply = 0;
        foodLimit = 15;
        radius = CITYRADIUS;
        goldProduced = 0;
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
        this.style = owner.getBuildingStyle();
    }

    public CityStyle getStyle() {
        return style;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitType getCurrentlyProducing() {
        return currentlyProducing;
    }

    public void setCurrentlyProducing(UnitType currentlyProducing) {
        this.currentlyProducing = currentlyProducing;
    }
    
    public String getTurnsRemaining() {
        int remaining = (int) Math.ceil((double)prodTurnsRemaining / ((double)production + 1));

        if (remaining > 514) {
            return "∞";
        } else {
            return String.valueOf(remaining);
        }
    }

    public void setProdTurnsRemaining(int prodTurnsRemaining) {
        this.prodTurnsRemaining = prodTurnsRemaining;
    }
    
    /*
     * Once a turn has gone by, takes care of all the turn related
     * activity related to the city. Will return the UnitType to be created, or null if not.
     */
    public void nextTurn() {
        nextTurnProd();
        nextTurnFood();
        nextTurnGold();
        updateScience();
    }
    
    private void nextTurnProd() {
        if (currentlyProducing.equals(UnitType.NONE)) {
            return;
        }
        
        prodTurnsRemaining = prodTurnsRemaining - production - 1;
        
        if (prodTurnsRemaining <= 0) {
            if (citySettlerLogic()) {
                owner.addToCreateQueue(currentlyProducing, mapLocation);
                currentlyProducing = UnitType.NONE;
                prodTurnsRemaining = Integer.MAX_VALUE;
            }
        }
        
            
        lastUnitProduced = currentlyProducing;
        lastUnitProdRemaining = prodTurnsRemaining;
    }
    
    private boolean citySettlerLogic() {
        if (currentlyProducing == UnitType.SETTLERS) {
            if (level < 2) {
                prodTurnsRemaining = 1;
                return false;
            } else {
                level--;
                foodLimit = (int)Math.ceil((double)foodLimit / (double)FOODGROWTH);
                foodSupply -= foodLimit;
            }
        }
        return true;
    }
    
    private void nextTurnFood() {
        foodSupply -= (level + units.size());
        foodSupply += food;
        if (foodSupply >= foodLimit) {
            foodLimit = (int) (foodLimit * (FOODGROWTH));
            level++;
        } else if (foodSupply <= 0) {
            if (level > 1) {
                level--;
                foodLimit = (int) (foodLimit / FOODGROWTH);
            }
            
            foodSupply = 0;
        }
    }
    
    private void updateScience() {
        owner.collectScience(science);
    }
    
    /**
     * The gold making formula for cities
     */
    private void nextTurnGold() {
        int gold = (int) ((level) * GOLDCONSTANT) - (units.size() * 2);
        if (gold < 0) {
            gold = 0;
        }
        owner.collectGold(gold);
    }
    
    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    public UnitType getLastProducedUnit() {
        return lastUnitProduced;
    }

    public int getLastUnitProdRemaining() {
        return lastUnitProdRemaining;
    }
    
    public WeightedResourceObj getResourceWeight() {
        return resourceWeight;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public UnitType getLastUnitProduced() {
        return lastUnitProduced;
    }

    public void setLastUnitProduced(UnitType lastUnitProduced) {
        this.lastUnitProduced = lastUnitProduced;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }
    
    public void setWeightedResources(int prod, int food, int sci) {
        resourceWeight.prodWeight = prod;
        resourceWeight.foodWeight = food;
        resourceWeight.sciWeight = sci;
    }
    
    public void setWeightedResources(WeightedResourceObj w) {
        resourceWeight = w;
    }

    public int getFoodLimit() {
        return foodLimit;
    }

    public void setFoodLimit(int foodLimit) {
        this.foodLimit = foodLimit;
    }

    public int getFoodSupply() {
        return foodSupply;
    }

    public void setFoodSupply(int foodSupply) {
        this.foodSupply = foodSupply;
    }

    public void setCost(int cost) {
        this.currentlyProdCost = cost;
    }
    
    public int getCurrentlyProdCost() {
        int turnsRemaining = (int) Math.ceil((double)prodTurnsRemaining / ((double)production + 1));
        int factor = 2;
        if (production == 0) {
            factor = 4;
        } 
        return factor * turnsRemaining + (turnsRemaining * turnsRemaining / factor);
    }

    public void buyUnit() {
        if (currentlyProducing == UnitType.NONE) {
            return;
        }
        
        if (owner.getGold() >= getCurrentlyProdCost()) {
            owner.setGold(owner.getGold() - getCurrentlyProdCost());
            prodTurnsRemaining = 1;
            lastUnitProdRemaining = 1;
        }
    }
}
