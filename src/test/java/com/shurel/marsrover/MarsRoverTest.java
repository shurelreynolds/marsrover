package com.shurel.marsrover;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static com.shurel.marsrover.Navigator.MAX_GRID_COUNT;
import static com.shurel.marsrover.Navigator.MIN_GRID_COUNT;
import static org.junit.Assert.assertEquals;

public class MarsRoverTest {
    Navigator navigator;
    int gridXSize = 0;
    int gridYSize = 10;

    @Before
    public void setUp() {

    }

    @Test
    public void testNavigatorSetup() {
        //minimum size
        int gridXSize = 10;
        int gridYSize = 10;
        try {
            navigator = new Navigator(gridXSize, gridYSize);
            assertEquals("Mars", navigator.getPlanet().getName());
        } catch (NavigatorException | NavigatorCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRoverOnMap() {

        try {
            Navigator navigator = new Navigator();


            String expected = " .  .  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    "R1  .  .  .  . \n";
            assertEquals(expected, navigator.getTextMap());
        } catch (NavigatorException | NavigatorCommandException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testMinimumInitGridSize() {

        NavigatorException exception = Assertions.assertThrows(NavigatorException.class, () -> {
            navigator = new Navigator(gridXSize, gridYSize);

        });

        Assertions.assertEquals("Minimum Grid Size: " + MIN_GRID_COUNT, exception.getMessage());
    }


    @Test
    public void testMaximumInitGridSize() {
        gridXSize = 10;
        gridYSize = 200;

        NavigatorException exception = Assertions.assertThrows(NavigatorException.class, () -> {
            navigator = new Navigator(gridXSize, gridYSize);
        });

        Assertions.assertEquals("Maximum Grid Size: " + MAX_GRID_COUNT, exception.getMessage());

    }


    @Test
    public void testMoveRover() {
        try {
            navigator = new Navigator();
            navigator.move("Rover 1", "1 2 N");
            Navigable rover = navigator.find("Rover 1");
            assertEquals(new Point(1, 2), rover.getLocation());
            assertEquals('N', Navigable.toCoord(rover.getDegrees()));

            String expected = " .  .  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    " . R1  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    " .  .  .  .  . \n";

            assertEquals(expected, navigator.getTextMap());

        } catch (NavigatorCommandException | NavigatorException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testMoveNegativeNumbersRover() {
        try {
            navigator = new Navigator();
            navigator.move("Rover 1", "-1 -1 N");
            Navigable rover = navigator.find("Rover 1");

            assertEquals(new Point(4, 4), rover.getLocation());

            String expected =
                    " .  .  .  . R1 \n" +
                            " .  .  .  .  . \n" +
                            " .  .  .  .  . \n" +
                            " .  .  .  .  . \n" +
                            " .  .  .  .  . \n";

            assertEquals(expected, navigator.getTextMap());

        } catch (NavigatorCommandException | NavigatorException e) {
            e.printStackTrace();
        }

    }


    @Test

    public void testInvalidCommands() {
        NavigatorCommandException exception = Assertions.assertThrows(NavigatorCommandException.class, () -> {
            Navigator.isValidCommand(null);

        });
        Assertions.assertEquals("Command is null", exception.getMessage());

        exception = Assertions.assertThrows(NavigatorCommandException.class, () -> {
            Navigator.isValidCommand("3");

        });

        Assertions.assertEquals("Invalid Format", exception.getMessage());
        exception = Assertions.assertThrows(NavigatorCommandException.class, () -> {
            Navigator.isValidCommand("KGFDHRT");

        });

        Assertions.assertEquals("Invalid Format", exception.getMessage());


    }

}