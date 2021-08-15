package com.example.mars.spacialdata.coordinates.factory;

import com.example.mars.spacialdata.coordinates.model.Coordinates;
import com.example.mars.spacialdata.coordinates.model.EastCoordinates;

public class EastCoordinatesFactory extends CoordinatesFactory{


    public EastCoordinatesFactory(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Coordinates createCoordinates() {
        return new EastCoordinates(coordinates);
    }
}
