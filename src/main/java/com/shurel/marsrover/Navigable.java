package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public interface Navigable{
    int getDegrees();
    void setDegrees(int degrees);
    /* Adds to the x,y value of the location
    * @return true if the change was made
    * */
    boolean move(int x, int y);
    String getName();
    String getInitial();
    boolean rotate(char dir);
    Point getLocation();
    String getCoordinates();
    void setPoint(int x, int y);

    static char toCoord(int degree){
        switch(degree){
            case 0:
                return 'W';
            case 90:
                return 'N';
            case 180:
                return 'E';
            case 270:
                return 'S';

        }
        return ' ';
    }

}


