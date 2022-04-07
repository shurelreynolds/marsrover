package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public interface Navigable{
    boolean move(int x, int y);
    String getName();
    boolean rotate(char dir);
    Point getLocation();
    char getFacingDirection();
}


