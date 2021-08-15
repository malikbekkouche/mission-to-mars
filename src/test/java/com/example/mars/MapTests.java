package com.example.mars;


import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.model.Coordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTests {

    private Map underTest;
    private final int width = 5;
    private final int height = 5;

    @BeforeEach
    public void before() {
        underTest = new Map(width,height);
        underTest.setWarningInfo(new Coordinates(0,0), Direction.SOUTH);
    }

    @Test
    public void testLocationHasScent() {
        Coordinates coordinate = new Coordinates(0,0);
        Position position = new Position(coordinate, Direction.SOUTH);
        assertTrue(underTest.doesLocationHaveScent(position));
    }

    @Test
    public void testLocationHasScentButWrongDirection() {
        Coordinates coordinate = new Coordinates(0,0);
        Position position = new Position(coordinate, Direction.EAST);
        assertFalse(underTest.doesLocationHaveScent(position));
    }

    @Test
    public void testLocationDoesNotHaveScent() {
        Coordinates coordinate = new Coordinates(2,0);
        Position position = new Position(coordinate, Direction.EAST);
        assertFalse(underTest.doesLocationHaveScent(position));
    }

    @Test
    public void testWidth() {
        assertEquals(underTest.getTopX(),5);
    }

    @Test
    public void testHeight() {
        assertEquals(underTest.getTopY(),5);
    }

    @Test
    public void testOutOfBoundsEast() {
        Coordinates coordinate = new Coordinates(-1,0);
        Position position = new Position(coordinate, Direction.EAST);
        assertTrue(underTest.isOutOfBounds(position.getCoordinates()));
    }

    @Test
    public void testOutOfBoundsWest() {
        Coordinates coordinate = new Coordinates(6,0);
        Position position = new Position(coordinate, Direction.EAST);
        assertTrue(underTest.isOutOfBounds(position.getCoordinates()));
    }

    @Test
    public void testOutOfBoundsNorth() {
        Coordinates coordinate = new Coordinates(0,6);
        Position position = new Position(coordinate, Direction.EAST);
        assertTrue(underTest.isOutOfBounds(position.getCoordinates()));
    }

    @Test
    public void testOutOfBoundsSouth() {
        Coordinates coordinate = new Coordinates(0,-1);
        Position position = new Position(coordinate, Direction.EAST);
        assertTrue(underTest.isOutOfBounds(position.getCoordinates()));
    }

    @Test
    public void testOutOfBoundsMiddle() {
        Coordinates coordinate = new Coordinates(0,0);
        Position position = new Position(coordinate, Direction.EAST);
        assertFalse(underTest.isOutOfBounds(position.getCoordinates()));
    }

    @Test
    public void testMapExceedsMaxSize() {
        Exception exception = assertThrows(Exception.class, () -> {
            underTest = new Map(50,60);
        });
        String expectedMessage = "Maps can't exceed 50 in size";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}
