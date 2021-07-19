/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class AbstractStreamingHasher
extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    public AbstractStreamingHasher(int n10) {
        this(n10, n10);
    }

    /*
     * WARNING - void declaration
     */
    public AbstractStreamingHasher(int n10, int n11) {
        void var3_6;
        ByteBuffer byteBuffer;
        int bl2 = n11 % n10;
        if (bl2 == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            byteBuffer = null;
        }
        Preconditions.checkArgument((boolean)var3_6);
        byteBuffer = ByteBuffer.allocate(n11 + 7);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.buffer = byteBuffer = byteBuffer.order(byteOrder);
        this.bufferSize = n11;
        this.chunkSize = n10;
    }

    private void munch() {
        int n10;
        int n11;
        ByteBuffer byteBuffer = this.buffer;
        byteBuffer.flip();
        while ((n11 = (byteBuffer = this.buffer).remaining()) >= (n10 = this.chunkSize)) {
            byteBuffer = this.buffer;
            this.process(byteBuffer);
        }
        this.buffer.compact();
    }

    private void munchIfFull() {
        int n10;
        ByteBuffer byteBuffer = this.buffer;
        int n11 = byteBuffer.remaining();
        if (n11 < (n10 = 8)) {
            this.munch();
        }
    }

    private Hasher putBytesInternal(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int n10;
        int n11 = byteBuffer.remaining();
        if (n11 <= (n10 = (byteBuffer2 = this.buffer).remaining())) {
            this.buffer.put(byteBuffer);
            this.munchIfFull();
            return this;
        }
        n11 = this.bufferSize;
        n10 = this.buffer.position();
        n11 -= n10;
        byteBuffer2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            ByteBuffer byteBuffer3 = this.buffer;
            byte by2 = byteBuffer.get();
            byteBuffer3.put(by2);
        }
        this.munch();
        while ((n11 = byteBuffer.remaining()) >= (n10 = this.chunkSize)) {
            this.process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }

    public final HashCode hash() {
        this.munch();
        this.buffer.flip();
        ByteBuffer byteBuffer = this.buffer;
        int n10 = byteBuffer.remaining();
        if (n10 > 0) {
            byteBuffer = this.buffer;
            this.processRemaining(byteBuffer);
            byteBuffer = this.buffer;
            int n11 = byteBuffer.limit();
            byteBuffer.position(n11);
        }
        return this.makeHash();
    }

    public abstract HashCode makeHash();

    public abstract void process(ByteBuffer var1);

    public void processRemaining(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.limit();
        byteBuffer.position(n11);
        n11 = this.chunkSize + 7;
        byteBuffer.limit(n11);
        while ((n11 = byteBuffer.position()) < (n10 = this.chunkSize)) {
            long l10 = 0L;
            byteBuffer.putLong(l10);
        }
        byteBuffer.limit(n10);
        byteBuffer.flip();
        this.process(byteBuffer);
    }

    public final Hasher putByte(byte by2) {
        this.buffer.put(by2);
        this.munchIfFull();
        return this;
    }

    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder byteOrder = byteBuffer.order();
        try {
            Object object = ByteOrder.LITTLE_ENDIAN;
            byteBuffer.order((ByteOrder)object);
            object = this.putBytesInternal(byteBuffer);
            return object;
        }
        finally {
            byteBuffer.order(byteOrder);
        }
    }

    public final Hasher putBytes(byte[] object, int n10, int n11) {
        object = ByteBuffer.wrap((byte[])object, n10, n11);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        object = ((ByteBuffer)object).order(byteOrder);
        return this.putBytesInternal((ByteBuffer)object);
    }

    public final Hasher putChar(char c10) {
        this.buffer.putChar(c10);
        this.munchIfFull();
        return this;
    }

    public final Hasher putInt(int n10) {
        this.buffer.putInt(n10);
        this.munchIfFull();
        return this;
    }

    public final Hasher putLong(long l10) {
        this.buffer.putLong(l10);
        this.munchIfFull();
        return this;
    }

    public final Hasher putShort(short s10) {
        this.buffer.putShort(s10);
        this.munchIfFull();
        return this;
    }
}

