/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.research;

import civ.enums.UnitType;
import java.util.ArrayList;


class HonourNode extends TreeNode {

    public HonourNode(ArrayList <UnitType> aU) {
        super(aU, "Honour");
        turnsToComplete = SECONDLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        availableUnits.add(UnitType.CRUSADERS);
        availableUnits.add(UnitType.KNIGHT);
        availableUnits.add(UnitType.CAVALRY);
    }

    public String getInfo(){
        return ("Unlocks: CRUSADERS, KNIGHT, CAVALRY");
    }

}
