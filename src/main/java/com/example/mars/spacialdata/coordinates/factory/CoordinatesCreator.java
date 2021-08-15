package com.example.mars.spacialdata.coordinates.factory;

import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.model.Coordinates;

public class CoordinatesCreator {

    private Position startPosition;

    public CoordinatesCreator(Position startPosition) {
        this.startPosition = startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public Coordinates createCoordinates(){
        Coordinates startCoordinates = startPosition.getCoordinates();
        CoordinatesFactory coordinatesFactory;
        switch (startPosition.getDirection()){
            case EAST : {
                coordinatesFactory = new EastCoordinatesFactory(startCoordinates);
                break;
            }
            case WEST : {
                coordinatesFactory = new WestCoordinatesFactory(startCoordinates);
                break;
            }
            case SOUTH : {
                coordinatesFactory = new SouthCoordinatesFactory(startCoordinates);
                break;
            }
            case NORTH : {
                coordinatesFactory = new NorthCoordinatesFactory(startCoordinates);
                break;
            }
            default: {
                return startCoordinates;
            }
        }
        return coordinatesFactory.createCoordinates();
    }
}
