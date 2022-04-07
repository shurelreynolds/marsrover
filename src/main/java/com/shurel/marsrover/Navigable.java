package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public interface Navigable{
    int getDegrees();
    void setDegrees(int degrees);
    boolean move(int x, int y);
    String getName();
    boolean rotate(char dir);
    Point getLocation();
    char getFacingDirection();
}


