package com.shurel.marsrover;
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
}
