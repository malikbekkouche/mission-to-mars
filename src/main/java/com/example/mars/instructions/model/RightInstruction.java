/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.instructions.model;

import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.direction.DirectionHelper;

/**
 *
 * @author Malik
 */
public class RightInstruction implements Instruction{

    @Override
    public Position execute(Position startPosition) {
        return new Position(startPosition.getCoordinates(),
                turnRight(startPosition.getDirection()));
    }

    public Direction turnRight(Direction startDirection){
        DirectionHelper directionHelper = DirectionHelper.getInstance();
        return directionHelper.turnRight(startDirection);
    }
    
}
