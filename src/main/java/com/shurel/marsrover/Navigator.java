package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Navigator {
    /*
     * Sets a maximum for the gridCount
     * The user cannot create a plateau with a greater grid count
     * */
    public final static int MAX_GRID_COUNT = 20;

    /*
     * Sets a minimum for the gridCount
     * The user cannot create a plateau with a smaller grid count
     * */
    public final static int MIN_GRID_COUNT = 5;

    /*
     * Stores a map of Navigable objects by Name
     * */
    private static List<Rover> roverList = new ArrayList<>();

    /*
     * Assigns one Rover to the navigable map
     * */
    static {
        Rover rover = new Rover("Rover 1");
        roverList.add(rover);
    }

    /*
     * Defines the plateau where this navigator operates
     * */
    private final Plateau plateau;

    private char[][] grid;


    /*
     * Creates a new Navigator object with the given grid sizes.
     * @param gridXSize sets the number of grids along the x-axis
     * @param gridYSize sets the number of grids along the y-axis
     * @exception NavigatorException if the grid size for x is too small
     * @exception NavigatorException if the grid size for x is too large
     * @exception NavigatorException if the grid size for y is too small
     * @exception NavigatorException if the grid size for y is too large
     * */
    public Navigator(int gridXSize, int gridYSize) throws NavigatorException {
        if (gridXSize > MAX_GRID_COUNT || gridYSize > MAX_GRID_COUNT)
            throw new NavigatorException("Maximum Grid Size: " + MAX_GRID_COUNT);

        if (gridXSize < MIN_GRID_COUNT || gridYSize < MIN_GRID_COUNT)
            throw new NavigatorException("Minimum Grid Size: " + MIN_GRID_COUNT);
         plateau = new Plateau(gridXSize, gridYSize);
        grid = new char[gridXSize][gridYSize];
         //fill the grid
        for (char i[] : grid) {
            // Fill each row with -.
            Arrays.fill(i, '.');
        }
    }

    /*
    * @return a text representation of the map
    * */
    public String getTextMap(){

            String out = "";
            for (char i[] : grid) {
                for (char j : i) {
                    out += j;
                }
                out += "\n";

            }
            return out.trim();
        }

    public void move(String navigable, int x, int y) {
        plateau.getNavigable(navigable).move(x,y);
    }
}
