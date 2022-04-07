package com.shurel.marsrover;

import java.awt.*;
/**
 * @author Shurel Reynolds.
 */

public abstract class AbstractVehicle implements Vehicle {
    protected Camera camera;
    protected final String name;
    protected Point location;

    public AbstractVehicle(String name) {
        this.name=name;
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public boolean rotate(char dir) {
        return false;
    }

    public String getName() {
        return this.name==null?this.getClass().getName():this.name;
    }

    @Override
    public boolean move(int x, int y) {
        return false;
    }

    @Override
    public char getFacingDirection() {
        return ' ';
    }

    @Override
    public Point getLocation() {
        return location;
    }
}
