package com.example.mars.spacialdata.coordinates.factory;

import com.example.mars.spacialdata.coordinates.model.Coordinates;

public abstract class CoordinatesFactory {

    protected Coordinates coordinates;

    public CoordinatesFactory(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract Coordinates createCoordinates();
}
