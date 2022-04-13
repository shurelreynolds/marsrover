package com.shurel.marsrover.planet;

import com.shurel.marsrover.planet.plateau.Plateau;

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
