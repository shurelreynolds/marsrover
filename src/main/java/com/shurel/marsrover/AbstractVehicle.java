package com.shurel.marsrover;
/**
 * @author Shurel Reynolds.
 */
public abstract class AbstractVehicle implements Vehicle {
protected Camera camera;
    @Override
    public void setCamera(Camera camera) {
        this.camera=camera;
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public boolean rotate(char dir) {
      return false;
    }

    public String getName(){
        return this.getClass().getName();
    }
    @Override
    public boolean move(int x, int y) {
        return false;
    }
}
