/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer;
import java.nio.ByteBuffer;

public final class AllocatedBuffer$1
extends AllocatedBuffer {
    public final /* synthetic */ ByteBuffer val$buffer;

    public AllocatedBuffer$1(ByteBuffer byteBuffer) {
        this.val$buffer = byteBuffer;
    }

    public byte[] array() {
        return this.val$buffer.array();
    }

    public int arrayOffset() {
        return this.val$buffer.arrayOffset();
    }

    public boolean hasArray() {
        return this.val$buffer.hasArray();
    }

    public boolean hasNioBuffer() {
        return true;
    }

    public int limit() {
        return this.val$buffer.limit();
    }

    public ByteBuffer nioBuffer() {
        return this.val$buffer;
    }

    public int position() {
        return this.val$buffer.position();
    }

    public AllocatedBuffer position(int n10) {
        this.val$buffer.position(n10);
        return this;
    }

    public int remaining() {
        return this.val$buffer.remaining();
    }
}

