/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer;
import com.google.protobuf.BufferAllocator;
import java.nio.ByteBuffer;

public final class BufferAllocator$1
extends BufferAllocator {
    public AllocatedBuffer allocateDirectBuffer(int n10) {
        return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(n10));
    }

    public AllocatedBuffer allocateHeapBuffer(int n10) {
        return AllocatedBuffer.wrap(new byte[n10]);
    }
}

