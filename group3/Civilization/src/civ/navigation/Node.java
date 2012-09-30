/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package civ.navigation;

/**
 *
 * @author Scott
 */

// Creates a node for pathfinding. 
class Node implements Comparable {
    public int x; // x co-ordinate
    public int y; // y co-ordinate
    public float cost; // the movement cost associated with moving across a specific node.
    public Node parent; // the parent of the current node
    public float heuristicCost; // cost associated with moving using heuristic equation.

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Object o) {
        Node other = (Node)o;
        float f = heuristicCost + cost;
        float otherF = other.heuristicCost + other.cost;

        if(f < otherF) {
            return -1;
        } else if (f > otherF) {
            return 1;
        } else {
            return 0;
        }
    }
}