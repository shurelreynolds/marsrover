package com.shurel.marsrover;

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

    //TOD: document method - collect sample
    public void collect(Sample sample, Point location) {
        collectedSample.add(sample);
    }

}
