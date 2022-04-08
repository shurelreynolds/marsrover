package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public class Mars extends AbstractPlanet {
    protected Mars(Plateau plateau) {
        super(plateau);
    }

    @Override
    public Plateau getPlateau() {
        return null;
    }
}
