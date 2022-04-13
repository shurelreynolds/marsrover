package com.shurel.marsrover.vehicle.equipment;

import com.shurel.marsrover.Navigable;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public class Camera extends AbstractEquipment implements Navigable {
    /*
     * represents face turning 0 - W, 90 - N, 180 - E 270 -S
     * */
    protected int degrees;

    @Override
    public int getDegrees() {
        return 0;
    }

    @Override
    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

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
    public String getCoordinates() {
        return getLocation().x + " " + getLocation().y + " " + Navigable.toCoord(degrees);
    }

    @Override
    public void setPoint(int x, int y) {
    }

}
