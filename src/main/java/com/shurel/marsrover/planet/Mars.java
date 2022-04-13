package com.shurel.marsrover.planet;

/**
 * @author Shurel Reynolds.
 */
public class Mars extends AbstractPlanet {
    protected Mars(Plateau plateau) {
        super(plateau);
        setName("Mars");
    }


    @Override
    public Plateau getPlateau() {
        return plateau;
    }
}
