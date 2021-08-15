package com.example.mars.spacialdata.coordinates.model;

public class WestCoordinates extends Coordinates{
    public WestCoordinates(int x, int y) {
        super(x, y);
    }

    public WestCoordinates(Coordinates startCoordinates) {
        super(startCoordinates.getX() - 1, startCoordinates.getY());
    }
}
