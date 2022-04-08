package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public class Camera extends AbstractEquipment implements Navigable {
protected int degrees;

    @Override
    public int getDegrees() {
        return 0;
    }

    @Override
    public void setDegrees(int degrees) {
this.degrees=degrees;
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
    public char getFacingDirection() {
        return ' ';
    }

    @Override
    public String getCoordinates() {
        return getLocation().x+" "+getLocation().y+" "+getFacingDirection();
    }

    @Override
    public void setPoint(int x, int y) {
    }


}
