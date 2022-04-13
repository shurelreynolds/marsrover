package com.shurel.marsrover.vehicle;

import com.shurel.marsrover.vehicle.equipment.RobotArm;

/**
 * @author Shurel Reynolds.
 */
public class Robot extends AbstractVehicle {
protected RobotArm robotArm=new RobotArm();
    public Robot(String name){
        super(name);
    }

    public RobotArm getRobotArm() {
        return robotArm;
    }
    @Override
    public String getInitial() {
        return getName().charAt(0) + "" + getName().charAt(getName().length() - 1);
    }
    @Override
    public void setPoint(int x, int y) {

    }
}
