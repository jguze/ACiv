/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package civ.navigation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Scott
 */
public class Path implements Serializable {
  
    private ArrayList steps = new ArrayList();
    
    public Path() {}
    
    public int getLength() {
        return steps.size();
    }
    
    public Step getStep(int index) {
        return (Step) steps.get(index);
    }
    
    public void removeCurrentStep() {
        steps.remove(0);
    }
    
    public int getX(int index) {
        return getStep(index).x;
    }
    
    public int getY(int index) {
        return getStep(index).y;
    }
    
    public void appendStep(int x, int y) {
        steps.add(new Step(x,y));
    }
    
    public void prependStep(int x, int y) {
        steps.add(0, new Step(x,y));
    }
    
    public boolean contains(int x, int y) {
        return steps.contains(new Step(x,y));
    }
    
    public class Step implements Serializable {
        private int x;
        private int y;
        
        public Step(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }        
        
        @Override
        public int hashCode() {
            return y*x;
        }
        
        @Override
        public boolean equals(Object other) {
            if(other instanceof Step) {
                Step o = (Step) other;
                return (o.x == x) && (o.y == y);
            }
            
            return false;
        }
    }
}   
