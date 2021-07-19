/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$LiteralByteString;
import java.io.OutputStream;
import java.util.ArrayList;

public final class ByteString$Output
extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private byte[] buffer;
    private int bufferPos;
    private final ArrayList flushedBuffers;
    private int flushedBuffersTotalBytes;
    private final int initialCapacity;

    public ByteString$Output(int n10) {
        if (n10 >= 0) {
            ArrayList arrayList;
            this.initialCapacity = n10;
            this.flushedBuffers = arrayList = new ArrayList();
            byte[] byArray = new byte[n10];
            this.buffer = byArray;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Buffer size < 0");
        throw illegalArgumentException;
    }

    private byte[] copyArray(byte[] byArray, int n10) {
        byte[] byArray2 = new byte[n10];
        n10 = Math.min(byArray.length, n10);
        System.arraycopy(byArray, 0, byArray2, 0, n10);
        return byArray2;
    }

    private void flushFullBuffer(int n10) {
        ArrayList arrayList = this.flushedBuffers;
        byte[] byArray = this.buffer;
        ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString(byArray);
        arrayList.add(byteString$LiteralByteString);
        int n11 = this.flushedBuffersTotalBytes;
        int n12 = this.buffer.length;
        this.flushedBuffersTotalBytes = n11 += n12;
        n12 = this.initialCapacity;
        n10 = Math.max(n10, n11 >>>= 1);
        byte[] byArray2 = new byte[Math.max(n12, n10)];
        this.buffer = byArray2;
        this.bufferPos = 0;
    }

    private void flushLastBuffer() {
        int n10 = this.bufferPos;
        Object object = this.buffer;
        int n11 = ((byte[])object).length;
        if (n10 < n11) {
            if (n10 > 0) {
                byte[] byArray = this.copyArray((byte[])object, n10);
                object = this.flushedBuffers;
                ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString(byArray);
                object.add(byteString$LiteralByteString);
            }
        } else {
            Object object2 = this.flushedBuffers;
            object = new ByteString$LiteralByteString;
            byte[] byArray = this.buffer;
            object(byArray);
            ((ArrayList)object2).add(object);
            object2 = EMPTY_BYTE_ARRAY;
            this.buffer = (byte[])object2;
        }
        n10 = this.flushedBuffersTotalBytes;
        int n12 = this.bufferPos;
        this.flushedBuffersTotalBytes = n10 += n12;
        this.bufferPos = 0;
    }

    public void reset() {
        synchronized (this) {
            ArrayList arrayList = this.flushedBuffers;
            arrayList.clear();
            arrayList = null;
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
            return;
        }
    }

    public int size() {
        synchronized (this) {
            int n10 = this.flushedBuffersTotalBytes;
            int n11 = this.bufferPos;
            return n10 += n11;
        }
    }

    public ByteString toByteString() {
        synchronized (this) {
            this.flushLastBuffer();
            Iterable iterable = this.flushedBuffers;
            iterable = ByteString.copyFrom(iterable);
            return iterable;
        }
    }

    public String toString() {
        Object object = Integer.toHexString(System.identityHashCode(this));
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.size())};
        return String.format("<ByteString.Output@%s size=%d>", objectArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(int n10) {
        synchronized (this) {
            int n11;
            int n12 = this.bufferPos;
            byte[] byArray = this.buffer;
            int n13 = byArray.length;
            if (n12 == n13) {
                n12 = 1;
                this.flushFullBuffer(n12);
            }
            byte[] byArray2 = this.buffer;
            n13 = this.bufferPos;
            this.bufferPos = n11 = n13 + 1;
            byArray2[n13] = n10 = (int)((byte)n10);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(byte[] byArray, int n10, int n11) {
        synchronized (this) {
            void var2_2;
            void var3_3;
            byte[] byArray2 = this.buffer;
            int n12 = byArray2.length;
            int n13 = this.bufferPos;
            if (var3_3 <= (n12 -= n13)) {
                int n14;
                System.arraycopy(byArray, (int)var2_2, byArray2, n13, (int)var3_3);
                this.bufferPos = n14 = this.bufferPos + var3_3;
            } else {
                n12 = byArray2.length - n13;
                System.arraycopy(byArray, (int)var2_2, byArray2, n13, n12);
                var2_2 += n12;
                this.flushFullBuffer((int)(var3_3 -= n12));
                byArray2 = this.buffer;
                n12 = 0;
                System.arraycopy(byArray, (int)var2_2, byArray2, 0, (int)var3_3);
                this.bufferPos = var3_3;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeTo(OutputStream outputStream) {
        int n10;
        Object[] objectArray;
        Object[] objectArray2;
        synchronized (this) {
            objectArray2 = this.flushedBuffers;
            int n11 = objectArray2.size();
            objectArray = new ByteString[n11];
            objectArray2 = objectArray2.toArray(objectArray);
            objectArray = this.buffer;
            n10 = this.bufferPos;
        }
        int n12 = objectArray2.length;
        int n13 = 0;
        while (true) {
            if (n13 >= n12) {
                objectArray2 = this.copyArray((byte[])objectArray, n10);
                outputStream.write((byte[])objectArray2);
                return;
            }
            ByteString byteString = objectArray2[n13];
            byteString.writeTo(outputStream);
            ++n13;
        }
    }
}

