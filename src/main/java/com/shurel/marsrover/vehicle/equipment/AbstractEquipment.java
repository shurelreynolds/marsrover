package com.shurel.marsrover.vehicle.equipment;

/**
 * @author Shurel Reynolds.
 */
public class AbstractEquipment implements Equipment {

    public String getName() {
        return this.getClass().getName();
    }

    public String getInitial() {
        return getName().charAt(0) + "" + getName().charAt(getName().length() - 1);
    }
}
