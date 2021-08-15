package com.example.mars;


import com.example.mars.instructions.model.ForwardInstruction;
import com.example.mars.instructions.model.Instruction;
import com.example.mars.instructions.model.LeftInstruction;
import com.example.mars.instructions.model.RightInstruction;
import com.example.mars.instructions.factory.InstructionCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstructionCreatorTests {

    private InstructionCreator underTest;

    @BeforeEach
    public void before(){
        underTest = new InstructionCreator();
    }

    @Test
    public void createsForwardInstruction() throws Exception{
       String direction = "F";
       underTest.setInputInstruction(direction);
       Instruction instruction = underTest.createInstruction();
       assertTrue(instruction instanceof ForwardInstruction);
    }

    @Test
    public void createsLeftInstruction() throws Exception{
        String direction = "L";
        underTest.setInputInstruction(direction);
        Instruction instruction = underTest.createInstruction();
        assertTrue(instruction instanceof LeftInstruction);
    }

    @Test
    public void createsRightInstruction() throws Exception{
        String direction = "R";
        underTest.setInputInstruction(direction);
        Instruction instruction = underTest.createInstruction();
        assertTrue(instruction instanceof RightInstruction);
    }

    @Test
    public void createsInstructionWithWrongInput() throws Exception{
        String direction = "NW";
        underTest.setInputInstruction(direction);
        Exception exception = assertThrows(Exception.class, () -> {
            underTest.createInstruction();
        });
        String expectedMessage = "is not a valid command";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
