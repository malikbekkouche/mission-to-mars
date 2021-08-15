/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.instructions.factory;

import com.example.mars.instructions.model.Instruction;
import com.example.mars.instructions.model.LeftInstruction;

/**
 *
 * @author Malik
 */
public class LeftInstructionFactory extends InstructionFactory{

    public LeftInstructionFactory(String instruction) {
        super(instruction);
    }

    @Override
    public Instruction createInstruction() {
        return new LeftInstruction();
    }
    
}
