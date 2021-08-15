package com.example.mars.spacialdata.coordinates.model;

public class SouthCoordinates extends Coordinates{
    public SouthCoordinates(int x, int y) {
        super(x, y);
    }

    public SouthCoordinates(Coordinates startCoordinates) {
        super(startCoordinates.getX() , startCoordinates.getY() - 1);
    }
}
