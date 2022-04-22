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

            assertEquals(expected, navigator.getPlanet().getPlateau().getMap());

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

    @Test
    public void testBasicCommands() {
        boolean error=false;
        Navigator navigator=null;
        try {
         navigator=new Navigator(5,5);
         //default rover coord = 0 0 N
         Navigable rover=navigator.find("Rover 1");
         assertEquals("0 0 N",rover.getCoordinates());

         //move rover North 1 place
           navigator.move("Rover 1","M");
           assertEquals("0 1 N",rover.getCoordinates());
//turn right
            navigator.move("Rover 1","RM");
            assertEquals("1 1 E",rover.getCoordinates());
//position to 1 2 N
            navigator.move("Rover 1","1 2 N");
            assertEquals("1 2 N",rover.getCoordinates());

            //chained of command
            //navigator.move("Rover 1","LMLMLMLMM");
            //navigator.move("Rover 1","LMLMLMLMM");
            navigator.move("Rover 1","L");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","M");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","L");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","M");
            System.out.println(navigator.find("Rover 1").getCoordinates());

            navigator.move("Rover 1","L");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","M");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","L");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","M");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","L");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","M");
            System.out.println(navigator.find("Rover 1").getCoordinates());
            navigator.move("Rover 1","M");
            System.out.println(navigator.find("Rover 1").getCoordinates());


            //  navigator.move("Rover 1","L");
           // navigator.move("Rover 1","L");
           // navigator.move("Rover 1","L");
           // navigator.move("Rover 1","L");
           // navigator.move("Rover 1","L");
             assertEquals("4 2 W",rover.getCoordinates());
           // assertEquals("3 3 E",rover.getCoordinates());


        } catch (NavigatorException|NavigatorCommandException e) {
            error=true;
            e.printStackTrace();
        }
    }


}