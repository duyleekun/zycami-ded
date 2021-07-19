/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer;
import java.nio.ByteBuffer;

public final class AllocatedBuffer$2
extends AllocatedBuffer {
    private int position;
    public final /* synthetic */ byte[] val$bytes;
    public final /* synthetic */ int val$length;
    public final /* synthetic */ int val$offset;

    public AllocatedBuffer$2(byte[] byArray, int n10, int n11) {
        this.val$bytes = byArray;
        this.val$offset = n10;
        this.val$length = n11;
    }

    public byte[] array() {
        return this.val$bytes;
    }

    public int arrayOffset() {
        return this.val$offset;
    }

    public boolean hasArray() {
        return true;
    }

    public boolean hasNioBuffer() {
        return false;
    }

    public int limit() {
        return this.val$length;
    }

    public ByteBuffer nioBuffer() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int position() {
        return this.position;
    }

    public AllocatedBuffer position(int n10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = this.val$length)) {
            this.position = n10;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid position: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public int remaining() {
        int n10 = this.val$length;
        int n11 = this.position;
        return n10 - n11;
    }
}

