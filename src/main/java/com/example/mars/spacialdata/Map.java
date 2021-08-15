/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.spacialdata;


import com.example.mars.spacialdata.coordinates.model.Coordinates;
import com.example.mars.spacialdata.direction.Direction;

import java.util.HashMap;

/**
 *
 * @author Malik
 */

public class Map {
    private final HashMap<Coordinates, WarningSignal> cells;
    private final int topX;
    private final int topY;

    public Map(int topX, int topY) {
        if(topX > 50 || topY > 50){
            throw new IllegalStateException("Maps can't exceed 50 in size");
        }
        this.topX = topX;
        this.topY = topY;
        cells = new HashMap();
    }

    public Map(){
        this.topX = 5;
        this.topY = 5;
        cells = new HashMap();
    }

    public int getTopX() {
        return topX;
    }

    public int getTopY() {
        return topY;
    }
    
    public boolean doesLocationHaveScent(Position position){
        WarningSignal info = cells.get(position.getCoordinates());
        if(info == null){
            return false;
        }
        return info.hasScent() && info.isForbiddenDirection(position.getDirection());
    }
    
    public boolean isOutOfBounds(Coordinates coordinates) {
        boolean isOutOfBounds =  coordinates.getX() > topX ||
                coordinates.getY() > topY ||
                coordinates.getX() < 0 ||
                coordinates.getY() < 0;
        return isOutOfBounds;
    }

    public void setWarningInfo(Coordinates coordinates, Direction direction) {
        WarningSignal info = cells.get(coordinates);
        if(info == null){
            info = new WarningSignal();
            info.setScent(true);
            cells.put(coordinates, info);
        }
        info.addForbiddenDirection(direction);
    }

}
