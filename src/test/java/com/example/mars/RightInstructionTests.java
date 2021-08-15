package com.example.mars;


import com.example.mars.instructions.model.RightInstruction;
import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RightInstructionTests {

    private RightInstruction underTest;

    @BeforeEach
    public void before() {
        underTest = new RightInstruction();
    }

    @Test
    public void turnRightFromNorth(){
        Position startPosition = new Position();
        Position endPosition = new Position(startPosition.getCoordinates()
        , Direction.EAST);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }

    @Test
    public void turnRightFromSouth(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.SOUTH);
        Position endPosition = new Position(startPosition.getCoordinates()
                , Direction.WEST);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }

    @Test
    public void turnRightFromEast(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.EAST);
        Position endPosition = new Position(startPosition.getCoordinates()
                , Direction.SOUTH);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }

    @Test
    public void turnRightFromWest(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.WEST);
        Position endPosition = new Position(startPosition.getCoordinates()
                , Direction.NORTH);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }
}
