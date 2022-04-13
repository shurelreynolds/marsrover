package com.shurel.marsrover;

/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractPlanet implements Planet {
    protected Plateau plateau;
    protected String name;

    protected AbstractPlanet(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {


        return name == null ? this.getClass().getName() : name;
    }

}
