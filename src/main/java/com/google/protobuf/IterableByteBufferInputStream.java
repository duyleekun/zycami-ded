/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.UnsafeUtil;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;

public class IterableByteBufferInputStream
extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize;
    private boolean hasArray;
    private Iterator iterator;

    public IterableByteBufferInputStream(Iterable object) {
        int n10;
        Iterator iterator2;
        this.iterator = iterator2 = object.iterator();
        iterator2 = null;
        this.dataSize = 0;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            ByteBuffer cfr_ignored_0 = (ByteBuffer)object.next();
            this.dataSize = n10 = this.dataSize + 1;
        }
        this.currentIndex = -1;
        boolean bl2 = this.getNextByteBuffer();
        if (!bl2) {
            long l10;
            this.currentByteBuffer = object = Internal.EMPTY_BYTE_BUFFER;
            this.currentIndex = 0;
            this.currentByteBufferPos = 0;
            this.currentAddress = l10 = 0L;
        }
    }

    private boolean getNextByteBuffer() {
        int n10 = this.currentIndex;
        int n11 = 1;
        this.currentIndex = n10 += n11;
        Object object = this.iterator;
        n10 = (int)(object.hasNext() ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        this.currentByteBuffer = object = (ByteBuffer)this.iterator.next();
        this.currentByteBufferPos = n10 = ((Buffer)object).position();
        object = this.currentByteBuffer;
        n10 = (int)(((ByteBuffer)object).hasArray() ? 1 : 0);
        if (n10 != 0) {
            this.hasArray = n11;
            object = this.currentByteBuffer.array();
            this.currentArray = (byte[])object;
            object = this.currentByteBuffer;
            this.currentArrayOffset = n10 = ((ByteBuffer)object).arrayOffset();
        } else {
            long l10;
            this.hasArray = false;
            this.currentAddress = l10 = UnsafeUtil.addressOffset(this.currentByteBuffer);
            n10 = 0;
            object = null;
            this.currentArray = null;
        }
        return n11 != 0;
    }

    private void updateCurrentByteBufferPos(int n10) {
        int n11;
        this.currentByteBufferPos = n11 = this.currentByteBufferPos + n10;
        ByteBuffer byteBuffer = this.currentByteBuffer;
        n10 = byteBuffer.limit();
        if (n11 == n10) {
            this.getNextByteBuffer();
        }
    }

    public int read() {
        int n10 = this.currentIndex;
        int n11 = this.dataSize;
        if (n10 == n11) {
            return -1;
        }
        n10 = (int)(this.hasArray ? 1 : 0);
        n11 = 1;
        if (n10 != 0) {
            byte[] byArray = this.currentArray;
            int n12 = this.currentByteBufferPos;
            int n13 = this.currentArrayOffset;
            n10 = byArray[n12 += n13] & 0xFF;
            this.updateCurrentByteBufferPos(n11);
            return n10;
        }
        long l10 = this.currentByteBufferPos;
        long l11 = this.currentAddress;
        n10 = UnsafeUtil.getByte(l10 + l11) & 0xFF;
        this.updateCurrentByteBufferPos(n11);
        return n10;
    }

    public int read(byte[] object, int n10, int n11) {
        int n12 = this.currentIndex;
        int n13 = this.dataSize;
        if (n12 == n13) {
            return -1;
        }
        Object object2 = this.currentByteBuffer;
        n12 = ((Buffer)object2).limit();
        n13 = this.currentByteBufferPos;
        if (n11 > (n12 -= n13)) {
            n11 = n12;
        }
        if ((n12 = (int)(this.hasArray ? 1 : 0)) != 0) {
            object2 = this.currentArray;
            int n14 = this.currentArrayOffset;
            System.arraycopy(object2, n13 += n14, object, n10, n11);
            this.updateCurrentByteBufferPos(n11);
        } else {
            object2 = this.currentByteBuffer;
            n12 = ((Buffer)object2).position();
            ByteBuffer byteBuffer = this.currentByteBuffer;
            int n15 = this.currentByteBufferPos;
            byteBuffer.position(n15);
            byteBuffer = this.currentByteBuffer;
            byteBuffer.get((byte[])object, n10, n11);
            object = this.currentByteBuffer;
            ((ByteBuffer)object).position(n12);
            this.updateCurrentByteBufferPos(n11);
        }
        return n11;
    }
}

