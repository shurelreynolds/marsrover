package com.shurel.marsrover;

import java.util.Scanner;

public class NavigatorApp {

    public static void main(String []arg) throws NavigatorException,NavigatorCommandException {
        Navigator navigator=new Navigator();
       // navigator.printMap();

String input=null;
        String msg = "Welcome to MarsRover";
        System.out.println(msg);
        String r="Rover 1";
        Scanner scanner = new Scanner(System.in);
        while ((input = scanner.nextLine()) != null && !input.toLowerCase().equals("quit")) {
            try {
            navigator.parseCommand(r+" "+input);
            } catch (NavigatorCommandException e) {
                System.out.println(e);
            }
        }
        if (input.toLowerCase().equals("quit")) {
            System.out.println("Bye");
            System.exit(0);
        }

    }




}
