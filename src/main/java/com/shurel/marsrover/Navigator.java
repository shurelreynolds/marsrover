package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */

import java.awt.*;
import java.util.Arrays;

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
        navigable.setPoint(x, y);
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
    public Navigator() throws NavigatorException, NavigatorCommandException {
        this(MIN_GRID_COUNT, MIN_GRID_COUNT);
        move("Rover 1", 0, 0);
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
    public Navigator(int gridXSize, int gridYSize) throws NavigatorException, NavigatorCommandException {
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
        Navigable rover = planet.getPlateau().getNavigable("Rover 1");
        grid[(gridYSize - 1) - rover.getLocation().y][rover.getLocation().x] = " " + rover.getInitial();
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

    public void move(String navigable, int x, int y) throws NavigatorCommandException {
        // planet.getPlateau().getNavigable(navigable).move(x, y);
        move(navigable, x + " " + y + " N");
    }

    public void printMap() {
        System.out.println(getTextMap());
    }

    public String getCoordinates(String navigatable) throws NavigatorCommandException {
        return planet.getPlateau().getNavigable(navigatable).getCoordinates();
    }

    public void parseCommand(String input) throws NavigatorCommandException {
        if (input == null) new NavigatorCommandException("Input is null");
    }

    public void move(String navigable, String command) throws NavigatorCommandException {
        //find navigable first
        if (navigable == null) new NavigatorCommandException("Navigable is null");
        Navigable nav = planet.getPlateau().getNavigable(navigable);

        if (command.matches("\\-?\\d+ \\-?\\d+ [NEWS]")) {
            String s[] = command.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            if (x >= planet.getPlateau().getGridXSize())
                throw new NavigatorCommandException("x is out of bounds");

            if (y >= planet.getPlateau().getGridYSize())
                throw new NavigatorCommandException("y is out of bounds");

            if (x <= -planet.getPlateau().getGridXSize())
                throw new NavigatorCommandException("x is out of bounds");

            if (y <= -planet.getPlateau().getGridYSize())
                throw new NavigatorCommandException("y is out of bounds");

            if (x < 0)
                x += planet.getPlateau().getGridXSize();
            if (y < 0)
                y += planet.getPlateau().getGridYSize();


            char dir = command.charAt(command.length() - 1);


            //remove from grid
            Point location = nav.getLocation();


            grid[(planet.getPlateau().getGridYSize() - 1) - location.y][location.x] = " . ";

            nav.setPoint(x, y);
            nav.setFacingDirection(dir);

            // places new position on grid
            location = nav.getLocation();
            grid[(planet.getPlateau().getGridYSize() - 1) - location.y][location.x] = nav.getInitial() + " ";

        }
    }

    public Navigable find(String navigable) throws NavigatorCommandException {
        return planet.getPlateau().getNavigable(navigable);
    }

    public Planet getPlanet() {
        return this.planet;
    }
}
