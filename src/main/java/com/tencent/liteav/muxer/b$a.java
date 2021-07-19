/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 */
package com.tencent.liteav.muxer;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

public class b$a {
    public ByteBuffer a;
    public MediaCodec.BufferInfo b;

    public b$a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.a = byteBuffer;
        this.b = bufferInfo;
    }

    public ByteBuffer a() {
        return this.a;
    }

    public MediaCodec.BufferInfo b() {
        return this.b;
    }
}

