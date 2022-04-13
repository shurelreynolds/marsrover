package com.shurel.marsrover.planet;

import com.shurel.marsrover.planet.plateau.Plateau;

/**
 * @author Shurel Reynolds.
 */
public class Mars extends AbstractPlanet {
    public Mars(Plateau plateau) {
        super(plateau);
        setName("Mars");
    }


    @Override
    public Plateau getPlateau() {
        return plateau;
    }
}
