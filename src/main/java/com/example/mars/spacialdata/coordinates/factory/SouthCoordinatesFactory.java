package com.example.mars.spacialdata.coordinates.factory;

import com.example.mars.spacialdata.coordinates.model.Coordinates;
import com.example.mars.spacialdata.coordinates.model.SouthCoordinates;

public class SouthCoordinatesFactory extends CoordinatesFactory{


    public SouthCoordinatesFactory(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Coordinates createCoordinates() {
        return new SouthCoordinates(coordinates);
    }
}
