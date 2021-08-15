package com.example.mars.input.translator;

import com.example.mars.instructions.factory.InstructionCreator;
import com.example.mars.spacialdata.direction.Direction;
import com.example.mars.spacialdata.coordinates.model.Coordinates;

public class InputTranslator {


    public static InstructionCreator createInstructionCreator(char character) {
        String inputInstruction = Character.toString(character);
        InstructionCreator instructionCreator = new InstructionCreator(inputInstruction);
        return instructionCreator;
    }

    public static InstructionCreator createInstructionCreator(String inputInstruction) {
        InstructionCreator instructionCreator = new InstructionCreator(inputInstruction);
        return instructionCreator;
    }

    public static Direction createDirection(String direction) throws IllegalStateException{
        switch(direction.toUpperCase()){
            case "E" : {
                return Direction.EAST;
            }
            case "W" : {
                return Direction.WEST;
            }
            case "S" : {
                return Direction.SOUTH;
            }
            case "N" : {
                return Direction.NORTH;
            }
            default : {
                throw new IllegalStateException("wrong input: "+ direction + " is not an accepted direction");
            }
        }
    }

    public static Coordinates createCoordinates(int x, int y) {
        return new Coordinates(x, y);
    }
}
