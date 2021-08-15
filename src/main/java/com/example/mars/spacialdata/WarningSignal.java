/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.spacialdata;

import com.example.mars.spacialdata.direction.Direction;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Malik
 */
class WarningSignal {
    
    private boolean scent;
    private final Set<Direction> forbiddenDirections;

    public WarningSignal() {
        forbiddenDirections = new HashSet<>();
    }
    
    public boolean isForbiddenDirection(Direction direction){
        return forbiddenDirections.contains(direction);
    }
    
    public void addForbiddenDirection(Direction direction){
        forbiddenDirections.add(direction);
    }

    public boolean hasScent() {
        return scent;
    }

    public void setScent(boolean scent) {
        this.scent = scent;
    }

    
    
    
    
    
    
}
