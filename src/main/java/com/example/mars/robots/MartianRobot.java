/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.robots;

import com.example.mars.instructions.model.Instruction;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.model.Coordinates;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/**
 *
 * @author Malik
 */
public class MartianRobot implements Robot {
    
    private Position currentPosition;
    private boolean alive = true;
    private final Stack<Coordinates> visitedLocations = new Stack<>();;
    private final Set<Coordinates> uniqueVisitedLocations = new HashSet<>();
    private final Map map;



    public MartianRobot(Position startPosition, Map map) {
        currentPosition = startPosition;
        this.map = map;
        addVisitedLocations(startPosition);
    }

    @Override
    public Position move(Instruction instruction) {
        if(!isAlive()){
            return currentPosition;
        }
        Position newPosition = instruction.execute(currentPosition);
        if(map.doesLocationHaveScent(currentPosition)){
            currentPosition = new Position(currentPosition.getCoordinates(),newPosition.getDirection());
            return currentPosition;
        }
        if(!newPosition.getCoordinates().equals(currentPosition.getCoordinates())
        && !isRobotOutOfBounds(newPosition)){
            addVisitedLocations(newPosition);
        }
        if (isAlive() && isRobotOutOfBounds(newPosition)){
            killRobotAndSetWarningData(currentPosition);
        }else{
            currentPosition = newPosition;
        }
        return currentPosition;
    }

    private void addVisitedLocations(Position newPosition) {
        visitedLocations.push(newPosition.getCoordinates());
        uniqueVisitedLocations.add(newPosition.getCoordinates());
    }

    @Override
    public void kill(){
        alive = false;
    }

    @Override
    public Coordinates getLastCoordinates() {
         return visitedLocations.lastElement();
    }

    @Override
    public int getNumberOfCellsVisited() {
        return uniqueVisitedLocations.size();
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public Collection<Coordinates> getVisitedLocations() {
        return visitedLocations;
    }

    public boolean isRobotOutOfBounds(Position currentPosition) {
        return map.isOutOfBounds(currentPosition.getCoordinates());
    }

    private void killRobotAndSetWarningData(Position currentPosition) {
        kill();
        setWarningSignal(currentPosition);
    }

    private void setWarningSignal(Position currentPosition) {
        map.setWarningInfo(currentPosition.getCoordinates(), currentPosition.getDirection());
    }

    @Override
    public String getRobotStatus() {
        return currentPosition.getCoordinates().getX() + " "
                + currentPosition.getCoordinates().getY() + " "
                + currentPosition.getDirection() + " "
                + (isAlive() ? "" : "LOST");
    }

}
