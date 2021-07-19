/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ugc;

import java.nio.ByteBuffer;

public class TXAudioFrame {
    private ByteBuffer mByteBuffer;
    private int mLength;

    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    public void setLength(int n10) {
        this.mLength = n10;
    }
}

