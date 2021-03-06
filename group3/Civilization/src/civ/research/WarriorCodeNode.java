/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.research;

import civ.enums.UnitType;
import java.util.ArrayList;


class WarriorCodeNode extends TreeNode {

    public WarriorCodeNode(ArrayList <UnitType> aU) {
        super(aU, "WarriorCode");
        turnsToComplete = FIRSTLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        availableUnits.add(UnitType.ARCHERS);
        availableUnits.add(UnitType.ELEPHANT);
        availableUnits.add(UnitType.HORSEMEN);  

    }

    public String getInfo(){
        return ("Unlocks: ARCHERS, ELEPHANT, HORSEMAN");
    }

}
