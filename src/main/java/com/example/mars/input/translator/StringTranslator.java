package com.example.mars.input.translator;

import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.model.Coordinates;


public class StringTranslator extends InputTranslator{

    public static Position createStartPosition(String[] position) {
        Coordinates startCoordinates = createCoordinates( Integer.parseInt(position[0]),
                Integer.parseInt(position[1]));
        Direction startDirection = createDirection(position[2]);
        Position startPosition = new Position(startCoordinates,startDirection);
        return startPosition;
    }


    public static Map createMap(String[] input) {
        Map map = new Map(Integer.parseInt(input[0])
                , Integer.parseInt(input[1]));
        return map;
    }
}
