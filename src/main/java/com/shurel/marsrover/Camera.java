package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public class Camera extends AbstractEquipment implements Navigable {

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


}
