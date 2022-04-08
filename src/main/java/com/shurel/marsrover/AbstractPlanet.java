package com.shurel.marsrover;

/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractPlanet implements Planet {
    protected Plateau plateau;

    protected AbstractPlanet(Plateau plateau) {
        this.plateau = plateau;
    }

    public String getName() {
        return this.getClass().getName();
    }

}
