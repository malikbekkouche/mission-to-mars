package com.example.mars;

import com.example.mars.input.translator.JsonTranslator;
import com.example.mars.input.translator.StringTranslator;
import com.example.mars.instructions.model.Instruction;
import com.example.mars.instructions.factory.InstructionCreator;
import com.example.mars.robots.MartianRobot;
import com.example.mars.robots.Robot;
import com.example.mars.spacialdata.Map;
import com.example.mars.spacialdata.Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsApplication.class, args);
        List<Robot> robots = new ArrayList<>();
        intro();
        Scanner keyboard = new Scanner(System.in);
        Map map = null;
        map = getValidMap(keyboard);
        boolean abortMission = false;
        do {
            Robot robot = getValidRobot(keyboard, map);
            String instructions = getInstructionsInput(keyboard);
            for(char character : instructions.toCharArray()){
                InstructionCreator instructionCreator = JsonTranslator.createInstructionCreator(character);
                try {
                    Instruction instruction = instructionCreator.createInstruction();
                    robot.move(instruction);
                } catch (Exception e) {
                    System.out.println("Wrong input. Could not interpret instruction. Skipping to next");
                }
            }
            robots.add(robot);
            System.out.println("Do you wish to send another robot ? (y/n)");
            abortMission = isAbortMission(keyboard);
        }while(!abortMission);
        printRobots(robots);
    }

    private static boolean isAbortMission(Scanner keyboard) {
        String answer = keyboard.nextLine();
        return answer.equalsIgnoreCase("n");

    }

    private static void printRobots(List<Robot> robots) {
        for(Robot robot : robots){
            System.out.println(robot.getRobotStatus());
        }
    }

    private static Robot getValidRobot(Scanner keyboard, Map map) {
        while(true){
            try {
                Position position = getPosition(keyboard);
                Robot robot = new MartianRobot(position, map);
                return robot;
            }catch(Exception e){
                System.out.println("Wrong Input. Please try again");
            }
        }
    }

    private static Map getValidMap(Scanner keyboard) {
        Map map;
        while(true){
            try {
                map = getMap(keyboard);
                return map;
            }catch(Exception e){
                System.out.println("Wrong Input. Please try again");
            }
        }
    }

    private static Position getPosition(Scanner keyboard) {
        String[] positionArray = getPositionInput(keyboard);
        Position position = StringTranslator.createStartPosition(positionArray);
        return position;
    }

    private static Map getMap(Scanner keyboard) throws Exception{
        String[] size = getMapInput(keyboard, "Please enter the size of map [x y]");
        Map map = StringTranslator.createMap(size);
        return map;
    }

    private static String getInstructionsInput(Scanner keyboard) {
        System.out.println("Please enter the instructions for the robot");
        return keyboard.nextLine();
    }

    private static String[] getPositionInput(Scanner keyboard) {
        System.out.println("Please enter the robots start position [x y direction]");
        String positions = keyboard.nextLine();
        String[] positionArray = positions.split(" ");
        return positionArray;
    }

    private static String[] getMapInput(Scanner keyboard, String s) {
        System.out.println(s);
        String stringSize = keyboard.nextLine();
        return stringSize.split(" ");
    }

    private static void intro() {
        System.out.println("======================================");
        System.out.println("Welcome commander");
        System.out.println("The mission to mars has started");
        System.out.println("======================================");
    }

}
