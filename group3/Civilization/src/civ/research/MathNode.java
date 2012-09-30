/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.research;

import civ.enums.UnitType;
import java.util.ArrayList;


class MathNode extends TreeNode {

    public MathNode(ArrayList <UnitType> aU) {
        super(aU, "Math");
        turnsToComplete = FIRSTLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        availableUnits.add(UnitType.EXPLORER);
        availableUnits.add(UnitType.CARAVAN);
    }

    public String getInfo(){
        return ("Unlocks: EXPLORER, CARAVAN");
    }

}
