package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public class Earth extends AbstractPlanet {
    protected Earth(Plateau plateau) {
        super(plateau);
    }

    @Override
    public Plateau getPlateau() {
        return null;
    }
}
