/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package civ.navigation;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Scott
 */
class SortedList {
    private ArrayList list = new ArrayList();
    
    public Object getFirst() {
        return list.get(0);
    }
    
    public void clear() {
        list.clear();
    }
    
    public void add(Object o) {
        list.add(o);
        Collections.sort(list);
    }
    
    public void remove(Object o) {
        list.remove(o);
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean contains(Object o) {
        return list.contains(o);
    }
}
