package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public interface Planet {
    void setName(String name);
    String getName();
    Plateau getPlateau();
}
