package com.shurel.marsrover.planet;

import com.shurel.marsrover.planet.plateau.Plateau;
import com.shurel.marsrover.util.MarsRoverAppUtil;

/**
 * @author Shurel Reynolds.
 */
public class Mars extends AbstractPlanet {
    public Mars(Plateau plateau) {
        super(plateau);
        setName(MarsRoverAppUtil.getWord("mars"));
    }


    @Override
    public Plateau getPlateau() {
        return plateau;
    }

    @Override
    public int getHoursInADay() {
        return 25;
    }
}
