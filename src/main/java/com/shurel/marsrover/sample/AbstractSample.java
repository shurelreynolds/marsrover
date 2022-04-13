package com.shurel.marsrover.sample;

import com.shurel.marsrover.sample.Sample;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractSample implements Sample {
    protected Point location;

    public AbstractSample(Point location) {
        this.location = location;
    }

    public AbstractSample(String name, Point location) {
        this(location);
    }

    public String getName() {
        return this.getClass().getName();
    }

    public Point getLocation() {

        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

}
