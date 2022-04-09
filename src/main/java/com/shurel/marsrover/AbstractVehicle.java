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
    public char getFacingDirection() {

        return facingDirection;
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public String getCoordinates() {
        return getLocation().x + " " + getLocation().y + " " + getFacingDirection();
    }

    @Override
    public int getDegrees() {
        return 0;
    }

    @Override
    public void setDegrees(int degrees) {

    }

    @Override
    public List<History> getHistory() {
        return history;
    }

    @Override
    public void setFacingDirection(char facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void setPoint(int x, int y) {
        location = new Point(x, y);
    }
}
