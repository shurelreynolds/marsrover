package com.shurel.marsrover;

/**
 * @author Shurel Reynolds.
 */
public interface Vehicle extends Navigable {
    void setCamera(Camera camera);
    Camera getCamera();
}
