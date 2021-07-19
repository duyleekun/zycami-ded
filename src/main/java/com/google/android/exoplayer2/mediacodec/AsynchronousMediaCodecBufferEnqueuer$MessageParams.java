/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CryptoInfo
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;

public class AsynchronousMediaCodecBufferEnqueuer$MessageParams {
    public final MediaCodec.CryptoInfo cryptoInfo;
    public int flags;
    public int index;
    public int offset;
    public long presentationTimeUs;
    public int size;

    public AsynchronousMediaCodecBufferEnqueuer$MessageParams() {
        MediaCodec.CryptoInfo cryptoInfo;
        this.cryptoInfo = cryptoInfo = new MediaCodec.CryptoInfo();
    }

    public void setQueueParams(int n10, int n11, int n12, long l10, int n13) {
        this.index = n10;
        this.offset = n11;
        this.size = n12;
        this.presentationTimeUs = l10;
        this.flags = n13;
    }
}

