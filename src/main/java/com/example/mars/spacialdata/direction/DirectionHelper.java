package com.example.mars.spacialdata.direction;

import java.util.HashMap;

public class DirectionHelper {
    private HashMap<Direction,Direction> leftTurn = new HashMap<>();
    private HashMap<Direction,Direction> rightTurn = new HashMap<>();

    public static DirectionHelper instance;

    public static DirectionHelper getInstance() {
        if(instance == null){
            return new DirectionHelper();
        }
        return instance;
    }

    public Direction turnLeft(Direction direction){
        return leftTurn.get(direction);
    }

    public Direction turnRight(Direction direction){
        return rightTurn.get(direction);
    }

    private DirectionHelper(){
        addLeftDirections();
        addRightDirections();
    }

    private void addRightDirections() {
        rightTurn.put(Direction.NORTH,Direction.EAST);
        rightTurn.put(Direction.SOUTH,Direction.WEST);
        rightTurn.put(Direction.EAST,Direction.SOUTH);
        rightTurn.put(Direction.WEST,Direction.NORTH);
    }

    private void addLeftDirections() {
        leftTurn.put(Direction.NORTH,Direction.WEST);
        leftTurn.put(Direction.SOUTH,Direction.EAST);
        leftTurn.put(Direction.EAST,Direction.NORTH);
        leftTurn.put(Direction.WEST,Direction.SOUTH);
    }
}
