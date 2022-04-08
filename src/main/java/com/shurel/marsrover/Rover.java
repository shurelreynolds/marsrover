package com.shurel.marsrover;

/**
 * @author Shurel Reynolds.
 */
public class Rover extends AbstractVehicle {
    public Rover(String name) {
        super(name);
    }

    @Override
    public String getInitial() {
        return getName().charAt(0) + "" + getName().charAt(getName().length() - 1);
    }

    @Override
    public void setPoint(int x, int y) {

    }
}
