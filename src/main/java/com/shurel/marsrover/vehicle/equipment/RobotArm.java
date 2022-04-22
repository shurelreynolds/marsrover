package com.shurel.marsrover.vehicle.equipment;

import com.shurel.marsrover.planet.plateau.Plateau;
import com.shurel.marsrover.sample.Sample;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shurel Reynolds.
 */
public class RobotArm extends AbstractLever {
    //samples collected
    private final List<Sample> collectedSample = new ArrayList<>();

    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public void setLocation(int x, int y) {

    }

    @Override
    public Plateau getPlateau() {
        return null;
    }

    @Override
    public void setPlateau(Plateau plateau) {

    }

    //TOD: document method - collect sample
    public void collect(Sample sample, Point location) {
        collectedSample.add(sample);
    }

}
