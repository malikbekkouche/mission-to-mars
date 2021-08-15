package com.example.mars;


import com.example.mars.instructions.model.ForwardInstruction;
import com.example.mars.instructions.model.LeftInstruction;
import com.example.mars.instructions.model.RightInstruction;
import com.example.mars.robots.MartianRobot;
import com.example.mars.robots.Robot;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotTests {

    private Robot underTest;
    private Map map;

    @BeforeEach
    public void before(){
        map = new Map(2,2);
        underTest = new MartianRobot(new Position(),map);
    }

    @Test
    public void moveToNorthernEdge(){
        for(int i = 0; i<map.getTopY(); i++){
            ForwardInstruction forwardInstruction = new ForwardInstruction();
            underTest.move(forwardInstruction);
        }
        assertTrue(underTest.isAlive());
        ForwardInstruction forwardInstruction = new ForwardInstruction();
        underTest.move(forwardInstruction);
        assertFalse(underTest.isAlive());
    }

    @Test
    public void doesRobotRefuseToMoveIfWarningSignal(){
        Robot firstRobot = new MartianRobot(new Position(),map);
        ForwardInstruction forwardInstruction = new ForwardInstruction();
        for(int i = 0; i<map.getTopY(); i++){
            firstRobot.move(forwardInstruction);
        }
        assertTrue(firstRobot.isAlive());
        firstRobot.move(forwardInstruction);
        assertFalse(firstRobot.isAlive());
        Position scentPosition = null;
        for(int i = 0; i<map.getTopY(); i++){
            forwardInstruction = new ForwardInstruction();
            scentPosition = underTest.move(forwardInstruction);
        }
        assertTrue(underTest.isAlive());
        Position positionAfterScent = underTest.move(forwardInstruction);
        assertTrue(underTest.isAlive());
        assertTrue(positionAfterScent.equals(scentPosition));
    }

    @Test
    public void doesRobotRotateIfWarningSignal(){
        Robot firstRobot = new MartianRobot(new Position(),map);
        ForwardInstruction forwardInstruction = new ForwardInstruction();
        for(int i = 0; i<map.getTopY(); i++){
            firstRobot.move(forwardInstruction);
        }
        assertTrue(firstRobot.isAlive());
        firstRobot.move(forwardInstruction);
        assertFalse(firstRobot.isAlive());
        Position scentPosition = null;
        for(int i = 0; i<map.getTopY(); i++){
            forwardInstruction = new ForwardInstruction();
            scentPosition = underTest.move(forwardInstruction);
        }
        assertTrue(underTest.isAlive());
        LeftInstruction leftInstruction = new LeftInstruction();
        Position leftPositionAfterScent = underTest.move(leftInstruction);
        assertTrue(underTest.isAlive());
        assertFalse(leftPositionAfterScent.equals(scentPosition));
    }

    @Test
    public void checkVisitedLocations(){
        Position startingPoint = new Position();
        assertTrue(underTest.getVisitedLocations().contains(startingPoint.getCoordinates()));
        RightInstruction rightInstruction = new RightInstruction();
        Position rightPosition = underTest.move(rightInstruction);
        assertFalse(underTest.getVisitedLocations().contains(rightPosition));
        assertTrue(underTest.getVisitedLocations().size() == 1);
        ForwardInstruction forwardInstruction = new ForwardInstruction();
        Position firstMove = underTest.move(forwardInstruction);
        assertTrue(underTest.getVisitedLocations().contains(firstMove.getCoordinates()));
        Position secondMove = underTest.move(forwardInstruction);
        assertTrue(underTest.getVisitedLocations().contains(secondMove.getCoordinates()));
        Position thirdMove = underTest.move(forwardInstruction);
        assertTrue(underTest.getVisitedLocations().contains(thirdMove.getCoordinates()));
    }
}
