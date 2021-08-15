/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.instructions.factory;

import com.example.mars.instructions.model.Instruction;

/**
 *
 * @author Malik
 */
public class InstructionCreator {

    private String inputInstruction;

    public InstructionCreator(String inputInstruction) {
        this.inputInstruction = inputInstruction;
    }

    public InstructionCreator() {
    }

    public void setInputInstruction(String inputInstruction) {
        this.inputInstruction = inputInstruction;
    }


    public Instruction createInstruction() throws Exception {
        InstructionFactory factory;
        switch(inputInstruction){
            case "F" : {
                factory = new ForwardInstructionFactory(inputInstruction);
                break;
            }
            case "L" : {
                factory = new LeftInstructionFactory(inputInstruction);
                break;
            }
            case "R" : {
                factory = new RightInstructionFactory(inputInstruction);
                break;
            }
            default : {
                throw new IllegalStateException("Wrong input: "+ inputInstruction +" is not a valid command");
            }
        }
        Instruction instruction = factory.createInstruction();
        return instruction;
    }
    
}
