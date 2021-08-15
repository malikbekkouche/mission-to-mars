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
public abstract class InstructionFactory {
    
    String instruction;

    public InstructionFactory(String instruction) {
        this.instruction = instruction;
    }
    
    public abstract Instruction createInstruction();
}
