/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Batch;
import java.util.LinkedList;

public class Batch$Chunk
extends Batch {
    public Batch$Chunk(int n10) {
        super(n10);
    }

    public void reset() {
        LinkedList linkedList;
        this.output = linkedList = new LinkedList();
    }
}

