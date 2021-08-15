package com.example.mars.input.model;

public class RobotInput {

    private startPosition startPosition;
    private String instructions;

    public RobotInput(startPosition startPosition, String instructions) {
        this.startPosition = startPosition;
        this.instructions = instructions;
    }

    public startPosition getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(startPosition startPosition) {
        this.startPosition = startPosition;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
