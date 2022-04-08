package com.shurel.marsrover;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shurel Reynolds.
 */
public class Plateau {
    /*
     * Sets the number of grids along the x-axis
     * */
    private final int gridXSize;
    /*
     * Sets the number of grids along the y-axis
     * */
    private final int gridYSize;

    private static final List<Navigable> navigableList = new ArrayList<>();

    /*
     * Assigns one Rover to the navigable map
     * */
    static {
        Rover rover = new Rover("Rover 1");
        navigableList.add(rover);

    }


    public Plateau(int gridXSize, int gridYSize) {
        this.gridXSize = gridXSize;
        this.gridYSize = gridYSize;
    }
    //add navigable object to plateau
    public void addNavigable(Navigable navigable){
        navigableList.add(navigable);
    }

    public Navigable getNavigable(String name) {

        return navigableList.stream().filter(n->n.getName().equals(name)).findFirst().get();
    }
}
