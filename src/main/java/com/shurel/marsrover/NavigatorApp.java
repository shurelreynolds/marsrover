package com.shurel.marsrover;

import com.shurel.marsrover.util.LogMessage;
import com.shurel.marsrover.util.MarsRoverAppUtil;

import java.awt.*;
import java.util.Scanner;

public class NavigatorApp {

    public static void main(String[] arg) {
        Navigator navigator = null;

        String input = null;
        System.out.println(MarsRoverAppUtil.getWord("welcome"));
        MarsRoverAppUtil.log(new LogMessage(MarsRoverAppUtil.getWord("appstarting")));
        String r = "Rover 1";
        Scanner scanner = new Scanner(System.in);
        String[] coord = null;
        int x;
        int y;


        try {

            System.out.println(MarsRoverAppUtil.getWord("enterplateausize") + navigator.MIN_GRID_COUNT + " " + MarsRoverAppUtil.getWord("to") + " " + navigator.MAX_GRID_COUNT);
            //first line input
            input = scanner.nextLine();
            while (!canContinue(input) && !input.toLowerCase().equals("quit")) {
                System.out.println(MarsRoverAppUtil.getWord("invalidinput") + MarsRoverAppUtil.getWord("enterplateausize") + navigator.MIN_GRID_COUNT + " " + MarsRoverAppUtil.getWord("to") + " " + navigator.MAX_GRID_COUNT);
                input = scanner.nextLine();

            }
            checkQuit(input);

            coord = input.split(" ");

            x = Integer.parseInt(coord[0]);
            y = Integer.parseInt(coord[1]);

            try {
                navigator = new Navigator(x, y);
            } catch (NavigatorException e) {
                MarsRoverAppUtil.log(new LogMessage(MarsRoverAppUtil.getWord("navigatorstarting"), e));
                System.out.println(e.getMessage());
            }
            Dimension d = navigator.getPlanet().getPlateau().getDimension();
            System.out.println(MarsRoverAppUtil.getWord("plateausetto") + d.width + " x " + d.height);
        } catch (NavigatorCommandException e) {
            MarsRoverAppUtil.log(new LogMessage(MarsRoverAppUtil.getWord("navigatorstarting"), e));
            System.out.println(e.getMessage());
        }
        Navigable rover = null;
        try {
            rover = navigator.find("Rover 1");
        } catch (NavigatorCommandException e) {
            MarsRoverAppUtil.log(new LogMessage(MarsRoverAppUtil.getWord("findrover"), e));
            System.out.println(e.getMessage());

        }
        System.out.println("Rover 1: " + rover.getCoordinates());
        System.out.println(navigator.getTextMap());

        System.out.println(MarsRoverAppUtil.getWord("move") + rover.getName() + "(" + rover.getInitial() + ")");
        while ((input = scanner.nextLine()) != null && !"".equals(input) && !input.toLowerCase().equals(MarsRoverAppUtil.getWord("quit"))) {
            input = input.toUpperCase();

            try {
                navigator.move(r, input);
                System.out.println(r + ": " + rover.getCoordinates());
                System.out.println(navigator.getTextMap());

            } catch (NavigatorCommandException e) {
                MarsRoverAppUtil.log(new LogMessage(MarsRoverAppUtil.getWord("moverover"), e));
                System.out.println(e.getMessage());

            }
        }
        checkQuit(input);

    }

    static boolean canContinue(String input) {

        return (input.matches("\\d+ \\d+"));


    }


    private static void checkQuit(String input) {
        if (input.toLowerCase().equals(MarsRoverAppUtil.getWord("quit"))) {
            System.out.println(MarsRoverAppUtil.getWord("bye"));
            MarsRoverAppUtil.log(new LogMessage(MarsRoverAppUtil.getWord("exitcommand")));

            System.exit(0);
        }
    }


}
