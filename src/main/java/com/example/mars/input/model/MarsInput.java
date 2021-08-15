package com.example.mars.input.model;

import java.util.List;

public class MarsInput {

    private MapSize mapSize;
    private List<RobotInput> robots;

    public MarsInput(MapSize mapSize, List<RobotInput> robots) {
        this.mapSize = mapSize;
        this.robots = robots;
    }

    public MarsInput() {
    }

    public MapSize getMapSize() {
        return mapSize;
    }

    public void setMapSize(MapSize mapSize) {
        this.mapSize = mapSize;
    }

    public List<RobotInput> getRobots() {
        return robots;
    }

    public void setRobots(List<RobotInput> robots) {
        this.robots = robots;
    }
}
