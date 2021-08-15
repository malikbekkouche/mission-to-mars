/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.spacialdata;

import com.example.mars.spacialdata.coordinates.model.Coordinates;
import com.example.mars.spacialdata.direction.Direction;

import java.util.Objects;

/**
 *
 * @author Malik
 */
public class Position {
    
    private Coordinates coordinates;
    private Direction direction;

    public Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Position() {
        this.coordinates = new Coordinates(0, 0);
        this.direction = Direction.NORTH;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Location{" + "coordinates=" + coordinates + ", direction=" + direction + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        final Position other = (Position) obj;
        return this.getCoordinates().equals(other.getCoordinates())
                && this.getDirection().equals(other.getDirection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinates(), getDirection());
    }
}
