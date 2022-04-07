package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractVehicle implements Vehicle {

    public String getName(){
        return this.getClass().getName();
    }

}
