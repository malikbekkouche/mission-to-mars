package com.example.mars;

import com.example.mars.input.model.MarsInput;
import com.example.mars.input.model.RobotInput;
import com.example.mars.input.translator.JsonTranslator;
import com.example.mars.instructions.model.Instruction;
import com.example.mars.instructions.factory.InstructionCreator;
import com.example.mars.robots.MartianRobot;
import com.example.mars.robots.Robot;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;

import java.util.ArrayList;
import java.util.List;

public class MissionHelper {

    private MarsInput input;

    public MissionHelper(MarsInput missionInput) {
        this.input = missionInput;
    }

    public List<String> sendMission() {
        List<String> robots = new ArrayList<>();
        Map map = JsonTranslator.createMap(input);
        for(RobotInput robotInput : input.getRobots()){
            Position startPosition = JsonTranslator.createStartPosition(robotInput);
            Robot robot = new MartianRobot(startPosition,map);
            for(char character : robotInput.getInstructions().toCharArray()){
                InstructionCreator instructionCreator = JsonTranslator.createInstructionCreator(character);
                try {
                    Instruction instruction = instructionCreator.createInstruction();
                    robot.move(instruction);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            robots.add(robot.getRobotStatus());
        }
        return robots;
    }
}
