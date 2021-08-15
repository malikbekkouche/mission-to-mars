package com.example.mars.spacialdata.coordinates.factory;

import com.example.mars.spacialdata.coordinates.model.Coordinates;
import com.example.mars.spacialdata.coordinates.model.WestCoordinates;

public class WestCoordinatesFactory extends CoordinatesFactory{


    public WestCoordinatesFactory(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public Coordinates createCoordinates() {
        return new WestCoordinates(coordinates);
    }
}
