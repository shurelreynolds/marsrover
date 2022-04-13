package com.shurel.marsrover;

import java.awt.*;
import java.util.Scanner;

public class NavigatorApp {

    public static void main(String[] arg) throws NavigatorException, NavigatorCommandException {
        Navigator navigator = null;

        String input = null;
        String msg = "Welcome to MarsRover";
        System.out.println(msg);
        String r = "Rover 1";
        Scanner scanner = new Scanner(System.in);
        String[] coord = null;
        int x;
        int y;


        try {

            System.out.println("Enter the plateau size range " + navigator.MIN_GRID_COUNT + " to " + navigator.MAX_GRID_COUNT);
            //first line input
            input = scanner.nextLine();
            while (!canContinue(input) && !input.toLowerCase().equals("quit")) {
                System.out.println("Invalid input. Enter the plateau size range " + navigator.MIN_GRID_COUNT + " to " + navigator.MAX_GRID_COUNT);
                input = scanner.nextLine();

            }
            checkQuit(input);

            coord = input.split(" ");

            x = Integer.parseInt(coord[0]);
            y = Integer.parseInt(coord[1]);

            navigator = new Navigator(x, y);
            Dimension d=navigator.getPlanet().getPlateau().getDimension();
            System.out.println("Plateau set to : "+d.width+" x "+d.height);
        } catch (NavigatorCommandException e) {
            e.printStackTrace();
        }
        Navigable rover=navigator.find("Rover 1");
        System.out.println("Rover 1: "+rover.getCoordinates());
        System.out.println(navigator.getTextMap());

        System.out.println("Move "+rover.getName()+"("+rover.getInitial()+")");
        while ((input = scanner.nextLine()) != null && !"".equals(input) && !input.toLowerCase().equals("quit")) {
            input = input.toUpperCase();

            try {
                navigator.move(r, input);
                System.out.println(r+": "+rover.getCoordinates());
                System.out.println(navigator.getTextMap());

            } catch (NavigatorCommandException e) {
                System.out.println(e);
            }
        }
        checkQuit(input);

    }

    static boolean canContinue(String input) {

        return (input.matches("\\d+ \\d+"));


    }


    private static void checkQuit(String input) {
        if (input.toLowerCase().equals("quit")) {
            System.out.println("Bye");
            System.exit(0);
        }
    }


}
