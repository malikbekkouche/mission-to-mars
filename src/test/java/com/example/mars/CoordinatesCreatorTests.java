package com.example.mars;

import com.example.mars.instructions.model.ForwardInstruction;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.factory.CoordinatesCreator;
import com.example.mars.spacialdata.coordinates.model.*;
import com.example.mars.spacialdata.direction.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinatesCreatorTests {

    private CoordinatesCreator underTest;


    @Test
    public void getNorthCoordinates(){
        Position startPosition = new Position();
        underTest = new CoordinatesCreator(startPosition);
        Coordinates endCoordinates = new NorthCoordinates(startPosition.getCoordinates());
        Coordinates coordinatesAfterMoving = underTest.createCoordinates();
        assertEquals(endCoordinates, coordinatesAfterMoving);
        assertEquals(coordinatesAfterMoving,new Coordinates(0,1));
    }

    @Test
    public void getSouthCoordinates(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.SOUTH);
        underTest = new CoordinatesCreator(startPosition);
        Coordinates endCoordinates = new SouthCoordinates(startPosition.getCoordinates());
        Coordinates coordinatesAfterMoving = underTest.createCoordinates();
        assertEquals(endCoordinates, coordinatesAfterMoving);
        assertEquals(coordinatesAfterMoving,new Coordinates(0,-1));
    }

    @Test
    public void getWestCoordinates(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.WEST);
        underTest = new CoordinatesCreator(startPosition);
        Coordinates endCoordinates = new WestCoordinates(startPosition.getCoordinates());
        Coordinates coordinatesAfterMoving = underTest.createCoordinates();
        assertEquals(endCoordinates, coordinatesAfterMoving);
        assertEquals(coordinatesAfterMoving,new Coordinates(-1,0));
    }

    @Test
    public void getEastCoordinates(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.EAST);
        underTest = new CoordinatesCreator(startPosition);
        Coordinates endCoordinates = new EastCoordinates(startPosition.getCoordinates());
        Coordinates coordinatesAfterMoving = underTest.createCoordinates();
        assertEquals(endCoordinates, coordinatesAfterMoving);
        assertEquals(coordinatesAfterMoving,new Coordinates(1,0));
    }
}
