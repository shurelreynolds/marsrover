package com.shurel.marsrover.vehicle;

import com.shurel.marsrover.planet.plateau.Plateau;

/**
 * @author Shurel Reynolds.
 */
public class Rover extends AbstractVehicle {
    public Rover(String name) {
        this(name, null);
    }

    public Rover(String name, Plateau plateau) {
        super(name, plateau);
    }

    @Override
    public String getInitial() {
        return getName().charAt(0) + "" + getName().charAt(getName().length() - 1);
    }


}
