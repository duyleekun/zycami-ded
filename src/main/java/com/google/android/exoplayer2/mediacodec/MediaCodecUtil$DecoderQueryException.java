/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$1;

public class MediaCodecUtil$DecoderQueryException
extends Exception {
    private MediaCodecUtil$DecoderQueryException(Throwable throwable) {
        super("Failed to query underlying media codecs", throwable);
    }

    public /* synthetic */ MediaCodecUtil$DecoderQueryException(Throwable throwable, MediaCodecUtil$1 mediaCodecUtil$1) {
        this(throwable);
    }
}

