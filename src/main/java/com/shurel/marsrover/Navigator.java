package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */

import com.shurel.marsrover.planet.Mars;
import com.shurel.marsrover.planet.Planet;
import com.shurel.marsrover.planet.plateau.Plateau;
import com.shurel.marsrover.util.LogMessage;
import com.shurel.marsrover.util.MarsRoverAppUtil;

import java.awt.*;

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
     * The Planet to navigate
     * */
    private final Planet planet;

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

//

        //position the first rover on grid
        Navigable rover = planet.getPlateau().getNavigable("Rover 1");
        //  grid[(gridYSize - 1) - rover.getLocation().y][rover.getLocation().x] = " " + rover.getInitial();
    }

    /*
     * @return a text representation of the map
     * */
    public String getTextMap() {
// map out

        return planet.getPlateau().getMap();
    }

    public void move(String navigable, int x, int y) throws NavigatorCommandException {
        MarsRoverAppUtil.log(new LogMessage(navigable + " " + MarsRoverAppUtil.getWord("move") + " " + x + " " + y));

        move(navigable, x + " " + y + " N");
    }

    public void printMap() {
        System.out.println(getTextMap());
    }

    public String getCoordinates(String navigable) throws NavigatorCommandException {
        MarsRoverAppUtil.log(new LogMessage("getCoordinates: " + navigable));
        return planet.getPlateau().getNavigable(navigable).getCoordinates();
    }

    Point parseLocation(Navigable navigable, char command) {
        Point currentLocation = navigable.getLocation();
        int degrees = navigable.getDegrees();

        int x = currentLocation.x;
        int y = currentLocation.y;
        char current = ' ';
        int deg = degrees;

        //LMLMLMLMM

        deg = navigable.getDegrees();


        switch (command) {
            case 'L':

                deg = deg == 0 ? 270 : deg - 90;
                navigable.setDegrees(deg);
                break;
            case 'R':
                deg = deg == 270 ? 0 : deg + 90;
                navigable.setDegrees(deg);

                break;

            case 'M':

                switch (deg) {
                    //west
                    case 0:
                        x--;
                        break;

                    //north
                    case 90:
                        y++;
                        break;
                    //east
                    case 180:
                        x++;
                        break;
                    //south
                    case 270:
                        y--;
                        break;
                }


        }

        if (x < 0)
            x += planet.getPlateau().getGridXSize();
        if (y < 0)
            y += planet.getPlateau().getGridYSize();


        return new Point(x, y);
    }

    private void updateLocation(Navigable navigable, Point newLocation) {
        Point oldLocation = navigable.getLocation();
        // grid[(planet.getPlateau().getGridYSize() - 1) - oldLocation.y][oldLocation.x] = " . ";

        navigable.setLocation(newLocation.x, newLocation.y);

        // places new position on grid
        //  grid[(planet.getPlateau().getGridYSize() - 1) - newLocation.y][newLocation.x] = navigable.getInitial() + " ";

    }

    //TODO: replace with enum
    private int charToDegrees(char direction) {
        switch (direction) {
            case 'E':
                return 180;
            case 'W':
                return 0;
            case 'N':
                return 90;
            case 'S':
                return 270;
            default:
                return -1;
        }
    }

    public static boolean isValidCommand(String command) throws NavigatorCommandException {

        if (command == null) throw new NavigatorCommandException("Command is null");

        if (!command.toUpperCase().matches("[LMR]+") && !command.toUpperCase().matches("\\d+ \\d+ [NEWS]"))
            throw new NavigatorCommandException("Invalid Format");
        return true;
    }

    public void move(String navigable, String command) throws NavigatorCommandException {
        MarsRoverAppUtil.log(new LogMessage(navigable + " " + command));


        if (navigable == null) new NavigatorCommandException("Navigable is null");

        if (!isValidCommand(command)) new NavigatorCommandException("Invalid Command");


        int x, y;

        Navigable nav = planet.getPlateau().getNavigable(navigable);
        Point location = nav.getLocation();

        if (command.matches("[LMR]+")) {
            //update position
            for (int i = 0; i < command.length(); i++) {
                updateLocation(nav, parseLocation(nav, command.charAt(i)));
            }
        } else if (command.matches("\\-?\\d+ \\-?\\d+ [NEWS]")) {

            String s[] = command.split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            char d = command.charAt(command.length() - 1);
            //

            if (x >= planet.getPlateau().getGridXSize())
                throw new NavigatorCommandException("x is out of bounds");

            if (y >= planet.getPlateau().getGridYSize())
                throw new NavigatorCommandException("y is out of bounds");

            if (x <= -planet.getPlateau().getGridXSize())
                throw new NavigatorCommandException("x is out of bounds");

            if (y <= -planet.getPlateau().getGridYSize())
                throw new NavigatorCommandException("y is out of bounds");

            if (x < 0)
                x += planet.getPlateau().getGridXSize() - 1;
            if (y < 0)
                y += planet.getPlateau().getGridYSize() - 1;


            char dir = command.charAt(command.length() - 1);

            nav.setDegrees(charToDegrees(dir));

            nav.setLocation(x, y);

            // places new position on grid
            location = nav.getLocation();

        }


    }

    public Navigable find(String navigable) throws NavigatorCommandException {
        return planet.getPlateau().getNavigable(navigable);
    }

    public Planet getPlanet() {
        return this.planet;
    }


}
