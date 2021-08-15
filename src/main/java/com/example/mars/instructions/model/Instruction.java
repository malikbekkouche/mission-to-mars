/*
 * Copyright (c) 2020 Wincom Consulting S.L.
 * All Rights Reserved.
 * This source is subject to the terms of a software license agreement.
 * You shall not disclose such confidential information and shall use it only in accordance with the terms and conditions of the license agreement.
 */
package com.example.mars.instructions.model;

import com.example.mars.spacialdata.Position;

/**
 *
 * @author Malik
 */
public interface Instruction {
    
    
    public abstract Position execute(Position startPosition);
    
}
