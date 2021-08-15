package com.example.mars.input.translator;

import com.example.mars.input.model.MarsInput;
import com.example.mars.input.model.RobotInput;
import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;
import com.example.mars.spacialdata.coordinates.model.Coordinates;

public class JsonTranslator extends InputTranslator{

    public static Position createStartPosition(RobotInput robotInput) {
        Coordinates startCoordinates = createCoordinates(robotInput.getStartPosition().getX(),
                robotInput.getStartPosition().getY());
        Direction startDirection = createDirection(robotInput.getStartPosition().getDirection());
        Position startPosition = new Position(startCoordinates,startDirection);
        return startPosition;
    }


    public static Map createMap(MarsInput input) {
        Map map = new Map(input.getMapSize().getX()
                , input.getMapSize().getY());
        return map;
    }


}
