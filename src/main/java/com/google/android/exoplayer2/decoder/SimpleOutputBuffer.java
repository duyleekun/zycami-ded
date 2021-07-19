/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleOutputBuffer
extends OutputBuffer {
    public ByteBuffer data;
    private final OutputBuffer$Owner owner;

    public SimpleOutputBuffer(OutputBuffer$Owner outputBuffer$Owner) {
        this.owner = outputBuffer$Owner;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer init(long l10, int n10) {
        int n11;
        this.timeUs = l10;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || (n11 = byteBuffer.capacity()) < n10) {
            byteBuffer = ByteBuffer.allocateDirect(n10);
            ByteOrder byteOrder = ByteOrder.nativeOrder();
            this.data = byteBuffer = byteBuffer.order(byteOrder);
        }
        this.data.position(0);
        this.data.limit(n10);
        return this.data;
    }

    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

