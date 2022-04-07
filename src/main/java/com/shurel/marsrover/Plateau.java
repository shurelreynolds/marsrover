package com.shurel.marsrover;

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

    private final List<Navigable> navigableList = new ArrayList<>();

    public Plateau(int gridXSize, int gridYSize) {
        this.gridXSize = gridXSize;
        this.gridYSize = gridYSize;
    }
    //add navigable object to plateau
    public void addNavigable(Navigable navigable){
        navigableList.add(navigable);
    }
}
