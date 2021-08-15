package com.example.mars;


import com.example.mars.instructions.model.ForwardInstruction;
import com.example.mars.spacialdata.coordinates.model.*;
import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForwardInstructionTests {

    private ForwardInstruction underTest;


    @BeforeEach
    public void before() {
        underTest = new ForwardInstruction();
    }

    @Test
    public void moveForwardNorth(){
        Position startPosition = new Position();
        Position endPosition = new Position(new NorthCoordinates(startPosition.getCoordinates()), Direction.NORTH);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }

    @Test
    public void moveForwardEast(){
        Position startPosition = new Position();
        startPosition.setDirection(Direction.EAST);
        Position endPosition = new Position(
                new EastCoordinates(startPosition.getCoordinates()),
         Direction.EAST);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }

    @Test
    public void moveForwardWest(){
        Position startPosition = new Position(new Coordinates(1,1)
        ,Direction.WEST);
        Position endPosition = new Position(new WestCoordinates(startPosition.getCoordinates()),
                Direction.WEST);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }

    @Test
    public void moveForwardSouth(){
        Position startPosition = new Position(new Coordinates(1,1)
                ,Direction.SOUTH);
        Position endPosition = new Position(new SouthCoordinates(startPosition.getCoordinates()),
                Direction.SOUTH);
        Position positionAfterMoving = underTest.execute(startPosition);
        Assertions.assertEquals(endPosition, positionAfterMoving);
    }


}
