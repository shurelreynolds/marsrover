package com.shurel.marsrover;
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


    public Plateau(int gridXSize, int gridYSize) {
        this.gridXSize = gridXSize;
        this.gridYSize = gridYSize;
    }
}
