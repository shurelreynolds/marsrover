package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public interface Navigable{
    boolean move(int x, int y);
    String getName();
    boolean rotate(char dir);
}


