package com.shurel.marsrover;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shurel Reynolds.
 */

public abstract class AbstractVehicle implements Vehicle {
    protected Camera camera;
    protected final String name;
    //initial position
    protected Point location = new Point(0, 0);
    /*
     * represents face turning 0 - W, 90 - N, 180 - E 270 -S
     * */
    protected int degrees = 90;
    protected char facingDirection = 'N';
    protected List<History> history = new ArrayList<>();

    public AbstractVehicle(String name) {
        this.name = name;
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
        return this.name == null ? this.getClass().getName() : this.name;
    }

    @Override
    public boolean move(int x, int y) {
        return false;
    }


    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public String getCoordinates() {
        return getLocation().x + " " + getLocation().y + " " + Navigable.toCoord(degrees);
    }

    @Override
    public int getDegrees() {
        return degrees;
    }

    @Override
    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    @Override
    public List<History> getHistory() {
        return history;
    }

    @Override
    public void setPoint(int x, int y) {
        location = new Point(x, y);
    }
}
