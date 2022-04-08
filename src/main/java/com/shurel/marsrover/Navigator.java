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





    private static void position(Navigable navigable, int x, int y) {
        navigable.setPoint(x,y);
    }

    /*
     * The Planet to navigate
     * */
    private final Planet planet;

    /*
     * for plotting out coords
     * */
    private String[][] grid;

    /*
     * creates a constructor with the default minimum grid size
     * */
    public Navigator() throws NavigatorException {
        this(MIN_GRID_COUNT, MIN_GRID_COUNT);
    }

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
        planet = new Mars(new Plateau(gridXSize, gridYSize));
        grid = new String[gridXSize][gridYSize];
        //fill the grid
        for (String i[] : grid) {
            // Fill each row with -.
            Arrays.fill(i, " . ");
        }
        //position the first rover on grid
        Navigable rover=planet.getPlateau().getNavigable("Rover 1");

        grid[(gridYSize-1)-rover.getLocation().y][rover.getLocation().x]=" "+rover.getInitial();
    }

    /*
     * @return a text representation of the map
     * */
    public String getTextMap() {
// map out



        String out = "";
        for (String i[] : grid) {
            for (String j : i) {
                out += j;
            }
            out += "\n";

        }



        return out;
    }

    public void move(String navigable, int x, int y) {
        planet.getPlateau().getNavigable(navigable).move(x, y);
    }

    public void printMap() {
        System.out.println(getTextMap());
    }
}
