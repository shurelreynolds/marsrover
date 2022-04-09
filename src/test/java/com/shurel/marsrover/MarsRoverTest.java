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
        } catch (NavigatorException|NavigatorCommandException e) {
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
        public void testRoverOnMap(){

            try {
                navigator = new Navigator();
            } catch (NavigatorException|NavigatorCommandException e) {
                e.printStackTrace();
            }
               String expected=" .  .  .  .  . \n" +
                 " .  .  .  .  . \n" +
                 " .  .  .  .  . \n" +
                 " .  .  .  .  . \n" +
                 " R1 .  .  .  . \n";
            assertEquals(expected, navigator.getTextMap());
            try {
                System.out.println(navigator.getCoordinates("Rover 1"));
            } catch (NavigatorCommandException e) {
                e.printStackTrace();
            }

        }

    @Test
    public void testMoveRover(){
        try {
            navigator = new Navigator();
            navigator.move("Rover 1","1 2 N");
            Navigable rover=navigator.find("Rover 1");
            assertEquals(new Point(1,2),rover.getLocation());
            assertEquals('N',rover.getFacingDirection());

            String expected=" .  .  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    " . R1  .  .  . \n" +
                    " .  .  .  .  . \n" +
                    " .  .  .  .  . \n";

            assertEquals(expected,navigator.getTextMap());

        } catch (NavigatorCommandException|NavigatorException e) {
            e.printStackTrace();
        }

    }
}