/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package civ.navigation;

import civ.Map;


public class ManhattanHeuristic implements AStarHeuristic {
    
    // Set this to the smallest amount of movement we allow in game. In this case, it's warriors on roads (movement of 3/3 = 1)
    private static final int MIN_MOVE_AMOUNT = 1;

    /**
     * Gets cost of moving from one tile to another based on the Manhattan distance equation.
     * @param x current x location
     * @param y current y location
     * @param moveToX destination x location
     * @param moveToY destination y location
     * @return the movement cost associated with moving to the destination tile
     */
    @Override
    public float getCost(int x, int y, int moveToX, int moveToY, int mapWidth, int mapHeight) {
        int dx = Math.abs(moveToX - x);
        int dy = Math.abs(moveToY - y);
        
        if(dx > mapWidth/2)
            dx = mapWidth/2 - dx;
        
        return MIN_MOVE_AMOUNT * (dx + dy);
    }
}
