package com.shurel.marsrover;

import java.awt.*;

/*
* @author
* */
public class CollectedSample extends AbstractSample{
private Sample sample;
private Point location;

    public CollectedSample(Sample sample, Point location) {
        this.sample = sample;
        this.location = location;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
