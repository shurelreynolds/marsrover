package com.shurel.marsrover.planet.plateau;

import com.shurel.marsrover.Navigable;
import com.shurel.marsrover.NavigatorCommandException;
import com.shurel.marsrover.ui.Grid;
import com.shurel.marsrover.vehicle.Rover;

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

    private final List<Grid> grid = new ArrayList<>();
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
        for (int y = gridYSize - 1; y > 0; y--)
            for (int x = 0; x < gridXSize; x++) {
                grid.add(new Grid(x, y));
            }
        navigableList.get(0).setPlateau(this);

    }

    //add navigable object to plateau
    public void addNavigable(Navigable navigable) {
        navigableList.add(navigable);
    }

    public Navigable getNavigable(String name) throws NavigatorCommandException {

        for (Navigable n : navigableList)
            if (n.getName().equals(name))
                return n;

        throw new NavigatorCommandException(name + " not found");

    }

    public int getGridYSize() {
        return this.gridYSize;
    }

    public int getGridXSize() {
        return this.gridXSize;
    }

    public Dimension getDimension() {
        return new Dimension(gridXSize, gridYSize);
    }

    public String getMap() {
        String out = "";
        Navigable navi = null;

        for (int y = 0; y < getGridYSize(); y++) {
            for (int x = 0; x < getGridXSize(); x++) {
                navi = getNavigableAt(x, y);
                out += navi == null ? " . " : navi.getInitial() + " ";
            }
            out += "\n";
        }
        return out;
    }

    private Grid getGridAt(int x, int y) {
        return grid.stream().filter(g -> g.x == x && g.y == y).findFirst().get();
    }

    private Navigable getNavigableAt(int x, int y) {
        Navigable navi = null;

        for (Navigable n : navigableList) {
            if (n.getLocation().x == x && n.getUnrealPosition().y == y) {
                return n;
            }
        }
        return navi;
    }


    public int getNavigableCount() {
        return navigableList.size();
    }
}
