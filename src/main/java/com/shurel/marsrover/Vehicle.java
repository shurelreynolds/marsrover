package com.shurel.marsrover;

import java.awt.*;
import java.util.List;

/**
 * @author Shurel Reynolds.
 */
public interface Vehicle extends Navigable {
    void setCamera(Camera camera);
    Camera getCamera();
    Point getLocation();
    List<History> getHistory();

}
