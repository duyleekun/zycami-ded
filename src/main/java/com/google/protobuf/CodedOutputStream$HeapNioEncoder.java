/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedOutputStream$ArrayEncoder;
import java.nio.ByteBuffer;

public final class CodedOutputStream$HeapNioEncoder
extends CodedOutputStream$ArrayEncoder {
    private final ByteBuffer byteBuffer;
    private int initialPosition;

    public CodedOutputStream$HeapNioEncoder(ByteBuffer byteBuffer) {
        int n10;
        byte[] byArray = byteBuffer.array();
        int n11 = byteBuffer.arrayOffset();
        int n12 = byteBuffer.position();
        n11 += n12;
        n12 = byteBuffer.remaining();
        super(byArray, n11, n12);
        this.byteBuffer = byteBuffer;
        this.initialPosition = n10 = byteBuffer.position();
    }

    public void flush() {
        ByteBuffer byteBuffer = this.byteBuffer;
        int n10 = this.initialPosition;
        int n11 = this.getTotalBytesWritten();
        byteBuffer.position(n10 += n11);
    }
}

