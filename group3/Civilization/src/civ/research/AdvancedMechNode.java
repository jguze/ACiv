/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package civ.research;

import civ.enums.UnitType;
import java.util.ArrayList;


class AdvancedMechNode extends TreeNode {

    public AdvancedMechNode(ArrayList <UnitType> aU) {
        super(aU, "AdvMech");
        turnsToComplete = FIFTHLEVELTURNS;
    }

    @Override
    public void researchComplete() {
        this.setResearched(true);
        availableUnits.add(UnitType.AWACS);
        availableUnits.add(UnitType.CRUISE_MISSILE);
        availableUnits.add(UnitType.STEALTH_BOMBER);
        availableUnits.add(UnitType.STEALTH_FIGHTER);
        availableUnits.add(UnitType.SUBMARINE);
        availableUnits.add(UnitType.CARRIER);
        availableUnits.add(UnitType.HELICOPTER);
        availableUnits.add(UnitType.AEGIS_CRUISER);
        availableUnits.add(UnitType.DESTROYER);
    }
    
    public String getInfo(){
        return ("<html>Unlocks: AWACS, CRUISE_MISSILE, STEALTH_BOMBER, <br>"
                + "STEALTH_FIGHTER, SUBMARINE, CARRIER, HELICOPTER, <br>"
                + "AEGIS_CRUISER, DESTROYER</html>");
    }

}
