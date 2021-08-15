package com.example.mars.spacialdata.coordinates.factory;

import com.example.mars.spacialdata.coordinates.model.Coordinates;
import com.example.mars.spacialdata.coordinates.model.NorthCoordinates;

public class NorthCoordinatesFactory extends CoordinatesFactory{


    public NorthCoordinatesFactory(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Coordinates createCoordinates() {
        return new NorthCoordinates(coordinates);
    }
}
