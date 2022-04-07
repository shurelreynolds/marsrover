package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractSample implements Sample {

    public String getName(){
        return this.getClass().getName();
    }

}
