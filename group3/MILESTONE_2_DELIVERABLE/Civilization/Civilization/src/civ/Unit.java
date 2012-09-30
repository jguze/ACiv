package civ;

// TODO: Implement Movement Queue

import civ.enums.UnitTravelType;
import civ.enums.UnitType;
import java.util.concurrent.ArrayBlockingQueue;


public class Unit {
    
    private MapLocation mapLocation;
    private int movementRange;
    private int health;
    private int baseAttack;
    private int baseArmor;
    private ArrayBlockingQueue<MapLocation> moveQueue;
    private UnitType unitType;
    private UnitTravelType movementType;
    private int remainingMovement;
    private int ownerId;

    public Unit(UnitType uT, int h, int bA, int bAr, int mR, UnitTravelType mT)
    {
        movementRange = mR;
        health = h;
        baseAttack = bA;
        baseArmor = bAr;
        unitType = uT;
        movementType = mT;
    }
    
    public Unit(Unit unit) {
        movementRange = unit.getMovementRange();
        health = unit.getHealth();
        baseAttack = unit.getBaseAttack();
        baseArmor = unit.getBaseArmor();
        unitType = unit.getUnitType();
        movementType = unit.getMovementType();
    }
    
    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
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

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public ArrayBlockingQueue<MapLocation> getMoveQueue() {
        return moveQueue;
    }

    public void setMoveQueue(ArrayBlockingQueue<MapLocation> moveQueue) {
        this.moveQueue = moveQueue;
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
}
