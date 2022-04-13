package com.shurel.marsrover.planet;

/**
 * @author Shurel Reynolds.
 */
public interface Planet {
    void setName(String name);
    String getName();
    Plateau getPlateau();
}
