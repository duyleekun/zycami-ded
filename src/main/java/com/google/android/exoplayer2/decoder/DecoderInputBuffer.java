/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer$InsufficientCapacityException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DecoderInputBuffer
extends Buffer {
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo;
    public ByteBuffer data;
    private final int paddingSize;
    public ByteBuffer supplementalData;
    public long timeUs;
    public boolean waitingForKeys;

    public DecoderInputBuffer(int n10) {
        this(n10, 0);
    }

    public DecoderInputBuffer(int n10, int n11) {
        CryptoInfo cryptoInfo;
        this.cryptoInfo = cryptoInfo = new CryptoInfo();
        this.bufferReplacementMode = n10;
        this.paddingSize = n11;
    }

    private ByteBuffer createReplacementByteBuffer(int n10) {
        int n11 = this.bufferReplacementMode;
        int n12 = 1;
        if (n11 == n12) {
            return ByteBuffer.allocate(n10);
        }
        n12 = 2;
        if (n11 == n12) {
            return ByteBuffer.allocateDirect(n10);
        }
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            n11 = 0;
            byteBuffer = null;
        } else {
            n11 = byteBuffer.capacity();
        }
        DecoderInputBuffer$InsufficientCapacityException decoderInputBuffer$InsufficientCapacityException = new DecoderInputBuffer$InsufficientCapacityException(n11, n10);
        throw decoderInputBuffer$InsufficientCapacityException;
    }

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        DecoderInputBuffer decoderInputBuffer = new DecoderInputBuffer(0);
        return decoderInputBuffer;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        if ((byteBuffer = this.supplementalData) != null) {
            byteBuffer.clear();
        }
        this.waitingForKeys = false;
    }

    public void ensureSpaceForWrite(int n10) {
        int n11;
        int n12 = this.paddingSize;
        n10 += n12;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            ByteBuffer byteBuffer2;
            this.data = byteBuffer2 = this.createReplacementByteBuffer(n10);
            return;
        }
        int n13 = byteBuffer.capacity();
        if (n13 >= (n10 += (n11 = byteBuffer.position()))) {
            this.data = byteBuffer;
            return;
        }
        ByteBuffer byteBuffer3 = this.createReplacementByteBuffer(n10);
        ByteOrder byteOrder = byteBuffer.order();
        byteBuffer3.order(byteOrder);
        if (n11 > 0) {
            byteBuffer.flip();
            byteBuffer3.put(byteBuffer);
        }
        this.data = byteBuffer3;
    }

    public final void flip() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        if ((byteBuffer = this.supplementalData) != null) {
            byteBuffer.flip();
        }
    }

    public final boolean isEncrypted() {
        return this.getFlag(0x40000000);
    }

    public final boolean isFlagsOnly() {
        boolean bl2;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null && !(bl2 = this.bufferReplacementMode)) {
            bl2 = true;
        } else {
            bl2 = false;
            byteBuffer = null;
        }
        return bl2;
    }

    public void resetSupplementalData(int n10) {
        int n11;
        ByteBuffer byteBuffer = this.supplementalData;
        if (byteBuffer != null && (n11 = byteBuffer.capacity()) >= n10) {
            ByteBuffer byteBuffer2 = this.supplementalData;
            byteBuffer2.clear();
        } else {
            ByteBuffer byteBuffer3;
            this.supplementalData = byteBuffer3 = ByteBuffer.allocate(n10);
        }
    }
}

