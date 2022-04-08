package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractLever implements Lever {

    protected int degrees;

    @Override
    public boolean move(int x, int y) {
        return false;
    }
    @Override
    public boolean rotate(char dir) {
        return false;
    }
    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public char getFacingDirection() {
        return ' ';
    }
    @Override
    public String getInitial() {
        return getName().charAt(0) + "" + getName().charAt(getName().length() - 1);
    }
    @Override
    public int getDegrees() {
        return 0;
    }

    @Override
    public void setDegrees(int degrees) {
this.degrees=degrees;
    }

    @Override
    public String getCoordinates() {
        return getLocation().x+" "+getLocation().y+" "+getFacingDirection();
    }
}
