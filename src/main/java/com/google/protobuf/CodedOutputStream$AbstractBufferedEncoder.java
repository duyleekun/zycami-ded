/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.WireFormat;

public abstract class CodedOutputStream$AbstractBufferedEncoder
extends CodedOutputStream {
    public final byte[] buffer;
    public final int limit;
    public int position;
    public int totalBytesWritten;

    public CodedOutputStream$AbstractBufferedEncoder(int n10) {
        super(null);
        if (n10 >= 0) {
            byte[] byArray = new byte[Math.max(n10, 20)];
            this.buffer = byArray;
            this.limit = n10 = byArray.length;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bufferSize must be >= 0");
        throw illegalArgumentException;
    }

    public final void buffer(byte by2) {
        int n10;
        byte[] byArray = this.buffer;
        int n11 = this.position;
        this.position = n10 = n11 + 1;
        byArray[n11] = by2;
        by2 = (byte)(this.totalBytesWritten + 1);
        this.totalBytesWritten = by2;
    }

    public final void bufferFixed32NoTag(int n10) {
        byte by2;
        int n11;
        byte[] byArray = this.buffer;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        byArray[n12] = by2 = (byte)(n10 & 0xFF);
        this.position = n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >> 8 & 0xFF);
        this.position = n11 = n12 + 1;
        byArray[n12] = by2 = (byte)(n10 >> 16 & 0xFF);
        this.position = n12 = n11 + 1;
        byArray[n11] = n10 = (int)((byte)(n10 >> 24 & 0xFF));
        this.totalBytesWritten = n10 = this.totalBytesWritten + 4;
    }

    public final void bufferFixed64NoTag(long l10) {
        int n10;
        byte by2;
        byte by3;
        int n11;
        int n12;
        byte[] byArray = this.buffer;
        int n13 = this.position;
        this.position = n12 = n13 + 1;
        long l11 = 255L;
        byArray[n13] = n11 = (int)((int)(l10 & l11));
        this.position = n13 = n12 + 1;
        n11 = 8;
        byArray[n12] = by3 = (byte)(l10 >> n11 & l11);
        this.position = n12 = n13 + 1;
        byArray[n13] = by3 = (byte)(l10 >> 16 & l11);
        this.position = n13 = n12 + 1;
        long l12 = l10 >> 24;
        byArray[n12] = by2 = (byte)(l11 & l12);
        this.position = n12 = n13 + 1;
        byArray[n13] = by2 = (byte)((int)(l10 >> 32) & 0xFF);
        this.position = n13 = n12 + 1;
        byArray[n12] = by2 = (byte)((int)(l10 >> 40) & 0xFF);
        this.position = n12 = n13 + 1;
        byArray[n13] = by2 = (byte)((int)(l10 >> 48) & 0xFF);
        this.position = n13 = n12 + 1;
        byArray[n12] = n10 = (int)((int)(l10 >> 56) & 0xFF);
        this.totalBytesWritten = n10 = this.totalBytesWritten + n11;
    }

    public final void bufferInt32NoTag(int n10) {
        if (n10 >= 0) {
            this.bufferUInt32NoTag(n10);
        } else {
            long l10 = n10;
            this.bufferUInt64NoTag(l10);
        }
    }

    public final void bufferTag(int n10, int n11) {
        n10 = WireFormat.makeTag(n10, n11);
        this.bufferUInt32NoTag(n10);
    }

    public final void bufferUInt32NoTag(int n10) {
        int n11 = CodedOutputStream.access$100();
        if (n11 != 0) {
            n11 = this.position;
            long l10 = n11;
            while (true) {
                long l11;
                int n12;
                int n13;
                byte[] byArray;
                int n14;
                if ((n14 = n10 & 0xFFFFFF80) == 0) {
                    byArray = this.buffer;
                    n13 = this.position;
                    this.position = n12 = n13 + 1;
                    l11 = n13;
                    n10 = (byte)n10;
                    UnsafeUtil.putByte(byArray, l11, (byte)n10);
                    n10 = (int)((long)this.position - l10);
                    this.totalBytesWritten = n11 = this.totalBytesWritten + n10;
                    return;
                }
                byArray = this.buffer;
                n13 = this.position;
                this.position = n12 = n13 + 1;
                l11 = n13;
                byte by2 = (byte)(n10 & 0x7F | 0x80);
                UnsafeUtil.putByte(byArray, l11, by2);
                n10 >>>= 7;
            }
        }
        while (true) {
            int n15;
            int n16;
            byte[] byArray;
            if ((n11 = n10 & 0xFFFFFF80) == 0) {
                byArray = this.buffer;
                n16 = this.position;
                this.position = n15 = n16 + 1;
                byArray[n16] = n10 = (int)((byte)n10);
                this.totalBytesWritten = n10 = this.totalBytesWritten + 1;
                return;
            }
            byArray = this.buffer;
            n16 = this.position;
            this.position = n15 = n16 + 1;
            byArray[n16] = n15 = (int)((byte)(n10 & 0x7F | 0x80));
            this.totalBytesWritten = n11 = this.totalBytesWritten + 1;
            n10 >>>= 7;
        }
    }

    public final void bufferUInt64NoTag(long l10) {
        int n10 = CodedOutputStream.access$100();
        int n11 = 7;
        long l11 = 0L;
        long l12 = -128;
        if (n10 != 0) {
            n10 = this.position;
            long l13 = n10;
            while (true) {
                int n12;
                byte[] byArray;
                long l14;
                long l15;
                if ((n10 = (int)((l15 = (l14 = l10 & l12) - l11) == 0L ? 0 : (l15 < 0L ? -1 : 1))) == 0) {
                    int n13;
                    int n14;
                    byArray = this.buffer;
                    n11 = this.position;
                    this.position = n14 = n11 + 1;
                    long l16 = n11;
                    int n15 = (int)l10;
                    UnsafeUtil.putByte(byArray, l16, (byte)n15);
                    n15 = (int)((long)this.position - l13);
                    this.totalBytesWritten = n13 = this.totalBytesWritten + n15;
                    return;
                }
                byArray = this.buffer;
                int n16 = this.position;
                this.position = n12 = n16 + 1;
                l14 = n16;
                byte by2 = (byte)((int)l10 & 0x7F | 0x80);
                UnsafeUtil.putByte(byArray, l14, by2);
                l10 >>>= n11;
            }
        }
        while (true) {
            int n17;
            byte[] byArray;
            long l17;
            long l18;
            if ((n10 = (int)((l18 = (l17 = l10 & l12) - l11) == 0L ? 0 : (l18 < 0L ? -1 : 1))) == 0) {
                int n18;
                int n19;
                byArray = this.buffer;
                n11 = this.position;
                this.position = n19 = n11 + 1;
                byArray[n11] = n18 = (int)((int)l10);
                this.totalBytesWritten = n18 = this.totalBytesWritten + 1;
                return;
            }
            byArray = this.buffer;
            int n20 = this.position;
            this.position = n17 = n20 + 1;
            byArray[n20] = n17 = (int)((byte)((int)l10 & 0x7F | 0x80));
            this.totalBytesWritten = n10 = this.totalBytesWritten + 1;
            l10 >>>= n11;
        }
    }

    public final int getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public final int spaceLeft() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        throw unsupportedOperationException;
    }
}

