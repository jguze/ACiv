package civ;

import civ.enums.UnitTravelType;
import civ.enums.UnitType;
import civ.navigation.Path;
import java.io.Serializable;
import java.util.ArrayList;

public class Unit implements Serializable {
    
    private MapLocation mapLocation;
    private int movementRange;
    private int health;
    private int baseAttack;
    private int baseDefense;
    private int firepower;
    private Path moveList;
    private UnitType unitType;
    private UnitTravelType movementType;
    private int remainingMovement;
    private Player owner;
    private int maxHealth; // Maximum possible health a unit can have
    private int turnsToProduce;
    private int cost; //Cost to buy the unit
    private boolean isTransport;
    private int numberUnits = 0;

    public ArrayList<Unit> containedUnits = new ArrayList<Unit>();
    
    public enum State {
        IDLE,
        MOVING,
        MOVE_BLOCKED,
        IRRIGATING,
        FARMING,
        MINING,
        BUILDING_ROAD,
    };
    
    private State state;

    public Unit(UnitType uT, int h, int bA, int bAr, int mR, UnitTravelType mT, int tTP, int fp, int c)
    {
        movementRange = mR;
        maxHealth = h;
        health = h;
        baseAttack = bA;
        baseDefense = bAr;
        unitType = uT;
        movementType = mT;
        turnsToProduce = tTP;
        firepower = fp;
        state = State.IDLE;
        cost = c;

        if(uT == UnitType.CARRIER || uT == UnitType.ROLLERCOASTER || uT == UnitType.TRANSPORT || uT == UnitType.TRIREME || uT == UnitType.HELICOPTER || uT == UnitType.GALLEON || uT == UnitType.FREIGHT){
            isTransport = true;
        }
    }
    
    public Unit(Unit unit) {
        movementRange = unit.getMovementRange();
        health = unit.getHealth();
        maxHealth = unit.getHealth();
        baseAttack = unit.getBaseAttack();
        baseDefense = unit.getBaseDefense();
        unitType = unit.getUnitType();
        movementType = unit.getMovementType();
        turnsToProduce = unit.getTurnsToProduce();
        firepower = unit.getFirepower();
        state = State.IDLE;
        isTransport = unit.isTransport();
    }
    
    public int getBaseDefense() {
        return baseDefense;
    }

    public boolean isTransport() {
        return isTransport;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseDefense = baseArmor;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }
    
    public String getHealthRatio() {
        return Integer.toString((int)((((double)this.health)/this.maxHealth) * 10));
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public void setMovementRange(int movementRange) {
        this.movementRange = movementRange;
    }

    public UnitTravelType getMovementType() {
        return movementType;
    }

    public void setMovementType(UnitTravelType movementType) {
        this.movementType = movementType;
    }

    public int getRemainingMovement() {
        return remainingMovement;
    }

    public void setRemainingMovement(int remainingMovement) {
        this.remainingMovement = remainingMovement;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

   /* public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }*/
    
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public void setMoveList(Path moveList) {
        this.moveList = moveList;
    }

    public Path getPath() {
        return this.moveList;
    }

    public int getTurnsToProduce() {
        return turnsToProduce;
    }
    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return this.state;
    }
    
    public void wasAttacked(int firepower) {
        health = health - firepower;
    }
    
    public String toString() {
        return this.unitType.toString();
    } 
    
    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void addUnitTransport(Unit addMe){
        containedUnits.add(addMe);
        numberUnits = numberUnits + 1;
    }

    public void removeUnitTransport(Unit removeMe){
        containedUnits.remove(removeMe);
        numberUnits = numberUnits - 1;
    }

    public ArrayList<Unit> getList (){
        return containedUnits;
    }

    public int getNumUnits(){
        return numberUnits;
    }

    public boolean compare(Unit x)
    {
        if(x == null) return false;
        else return (this.mapLocation.x == x.mapLocation.x
                && this.mapLocation.y == x.mapLocation.y
                && this.unitType == x.unitType
                && this.health == x.health);
    }
}