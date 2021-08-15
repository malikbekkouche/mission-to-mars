package com.example.mars.spacialdata.coordinates.model;

public class NorthCoordinates extends Coordinates{
    public NorthCoordinates(int x, int y) {
        super(x, y);
    }

    public NorthCoordinates(Coordinates startCoordinates) {
        super(startCoordinates.getX() , startCoordinates.getY() + 1);
    }
}
