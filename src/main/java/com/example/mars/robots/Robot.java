/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.robots;

import com.example.mars.instructions.model.Instruction;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.model.Coordinates;

import java.util.Collection;

/**
 *
 * @author Malik
 */
public interface Robot {
    
    public Position move(Instruction instruction);
    public void kill();
    public Coordinates getLastCoordinates();
    public int getNumberOfCellsVisited();
    public boolean isAlive();
    public Collection<Coordinates> getVisitedLocations();
    public String getRobotStatus();
    
}
