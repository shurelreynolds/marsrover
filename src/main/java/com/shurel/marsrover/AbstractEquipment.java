package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public class AbstractEquipment implements Equipment {

    public String getName(){
        return this.getClass().getName();
    }


}
