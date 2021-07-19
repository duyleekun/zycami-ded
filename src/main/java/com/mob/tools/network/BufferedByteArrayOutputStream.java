/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class BufferedByteArrayOutputStream
extends ByteArrayOutputStream {
    public BufferedByteArrayOutputStream() {
    }

    public BufferedByteArrayOutputStream(int n10) {
        super(n10);
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public int getBufferSize() {
        return this.buf.length;
    }

    public boolean switchBuffer(byte[] byArray) {
        byte[] byArray2;
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) == (n10 = (byArray2 = this.buf).length)) {
            this.buf = byArray;
            return true;
        }
        return false;
    }

    public void write(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.limit();
        this.write(byteBuffer, n10);
    }

    public void write(ByteBuffer byteBuffer, int n10) {
        byte[] byArray = this.buf;
        int n11 = byArray.length;
        int n12 = this.count;
        if ((n11 -= n12) >= n10) {
            int n13;
            byteBuffer.get(byArray, n12, n10);
            this.count = n13 = this.count + n10;
        } else {
            byte[] byArray2 = new byte[n10];
            byteBuffer.get(byArray2);
            this.write(byArray2);
        }
    }
}

