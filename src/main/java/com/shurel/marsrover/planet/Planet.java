package com.shurel.marsrover.planet;

import com.shurel.marsrover.planet.plateau.Plateau;

/**
 * @author Shurel Reynolds.
 */
public interface Planet {
    void setName(String name);
    String getName();
    Plateau getPlateau();
    int getHoursInADay();
}
