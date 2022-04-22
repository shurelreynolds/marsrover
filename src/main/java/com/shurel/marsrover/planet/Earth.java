package com.shurel.marsrover.planet;

import com.shurel.marsrover.planet.plateau.Plateau;
import com.shurel.marsrover.util.MarsRoverAppUtil;

/**
 * @author Shurel Reynolds.
 */
public class Earth extends AbstractPlanet {
    protected Earth(Plateau plateau) {
        super(plateau);
        setName(MarsRoverAppUtil.getWord("earth"));
    }

    @Override
    public Plateau getPlateau() {
        return plateau;
    }

    @Override
    public int getHoursInADay() {
        return 24;
    }
}
