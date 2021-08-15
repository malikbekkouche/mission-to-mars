/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.instructions.model;

import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.factory.CoordinatesCreator;
import com.example.mars.spacialdata.coordinates.model.Coordinates;

/**
 *
 * @author Malik
 */
public class ForwardInstruction implements Instruction{

    @Override
    public Position execute(Position startPosition) {
        return new Position(moveForward(startPosition), startPosition.getDirection());
    }

    public Coordinates moveForward(Position startPosition){
        return new CoordinatesCreator(startPosition).createCoordinates();

    }


}
