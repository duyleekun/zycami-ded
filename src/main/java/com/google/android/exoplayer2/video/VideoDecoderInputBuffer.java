/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public class VideoDecoderInputBuffer
extends DecoderInputBuffer {
    public Format format;

    public VideoDecoderInputBuffer(int n10) {
        super(n10);
    }

    public VideoDecoderInputBuffer(int n10, int n11) {
        super(n10, n11);
    }
}

