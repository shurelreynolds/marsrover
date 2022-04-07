package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractLever implements Lever {

    @Override
    public boolean move(int x, int y) {
        return false;
    }
    @Override
    public boolean rotate(char dir) {
        return false;
    }
    @Override
    public Point getCoordinate() {
        return null;
    }

    @Override
    public char getFacingDirection() {
        return ' ';
    }

}
