package com.shurel.marsrover.vehicle;

import com.shurel.marsrover.History;
import com.shurel.marsrover.Navigable;
import com.shurel.marsrover.vehicle.equipment.Camera;

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
