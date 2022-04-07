package com.shurel.marsrover;

import java.awt.*;

/**
 * @author Shurel Reynolds.
 */
public interface Vehicle extends Navigable {
    void setCamera(Camera camera);
    Camera getCamera();
    Point getLocation();
}
