/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 */
package com.tencent.liteav.basic.structs;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

public class TXSNALPacket {
    public long arrivalTimeMs;
    public ByteBuffer buffer;
    public int codecId;
    public long dts;
    public long frameIndex;
    public long gopFrameIndex;
    public long gopIndex;
    public MediaCodec.BufferInfo info;
    public byte[] nalData = null;
    public int nalType = -1;
    public long pts;
    public long refFremeIndex;
    public int rotation;
    public long sequenceNum;
    public int streamType;

    public TXSNALPacket() {
        long l10;
        this.gopIndex = l10 = 0L;
        this.gopFrameIndex = l10;
        this.frameIndex = l10;
        this.refFremeIndex = l10;
        this.pts = l10;
        this.dts = l10;
        this.rotation = 0;
        this.sequenceNum = l10;
        this.arrivalTimeMs = l10;
        this.codecId = 0;
        this.buffer = null;
        this.info = null;
        this.streamType = 2;
    }
}

