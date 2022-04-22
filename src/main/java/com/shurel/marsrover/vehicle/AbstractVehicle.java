package com.shurel.marsrover.vehicle;

import com.shurel.marsrover.Navigable;
import com.shurel.marsrover.model.History;
import com.shurel.marsrover.planet.plateau.Plateau;
import com.shurel.marsrover.vehicle.equipment.Camera;

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
    protected Point unrealLocation;
    protected Plateau plateau;

    /*
     * represents face turning 0 - W, 90 - N, 180 - E 270 -S
     * */
    protected int degrees = 90;
    protected char facingDirection = 'N';
    protected List<History> history = new ArrayList<>();

    public AbstractVehicle(String name, Plateau plateau) {
        this.name = name;
        this.plateau = plateau;
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
    public void setLocation(int x, int y) {
        //adjust to plateau range
        location = new Point(x % getPlateau().getGridXSize(), y % getPlateau().getGridYSize());

    }

    @Override
    public Point getUnrealPosition() {
        int y = (getPlateau().getGridYSize() - 1) - location.y;

        if (y < 0)
            y += getPlateau().getGridYSize();

        return new Point(location.x, y);
    }

    @Override
    public Plateau getPlateau() {
        return plateau;
    }

    @Override
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

}
