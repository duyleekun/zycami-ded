/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer;
import com.google.protobuf.BufferAllocator$1;

public abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED;

    static {
        BufferAllocator$1 bufferAllocator$1 = new BufferAllocator$1();
        UNPOOLED = bufferAllocator$1;
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int var1);

    public abstract AllocatedBuffer allocateHeapBuffer(int var1);
}

