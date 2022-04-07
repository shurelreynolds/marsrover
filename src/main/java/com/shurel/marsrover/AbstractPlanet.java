package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractPlanet implements Planet{

    public String getName(){
        return this.getClass().getName();
    }

}
