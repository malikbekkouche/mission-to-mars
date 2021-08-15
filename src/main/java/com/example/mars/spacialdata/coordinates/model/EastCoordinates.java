package com.example.mars.spacialdata.coordinates.model;

public class EastCoordinates extends Coordinates{

    public EastCoordinates(int x, int y) {
        super(x, y);
    }

    public EastCoordinates(Coordinates startCoordinates) {
        super(startCoordinates.getX() + 1, startCoordinates.getY());
    }
}
