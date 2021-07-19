/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.Ac3Util$1;

public final class Ac3Util$SyncFrameInfo {
    public static final int STREAM_TYPE_TYPE0 = 0;
    public static final int STREAM_TYPE_TYPE1 = 1;
    public static final int STREAM_TYPE_TYPE2 = 2;
    public static final int STREAM_TYPE_UNDEFINED = 255;
    public final int channelCount;
    public final int frameSize;
    public final String mimeType;
    public final int sampleCount;
    public final int sampleRate;
    public final int streamType;

    private Ac3Util$SyncFrameInfo(String string2, int n10, int n11, int n12, int n13, int n14) {
        this.mimeType = string2;
        this.streamType = n10;
        this.channelCount = n11;
        this.sampleRate = n12;
        this.frameSize = n13;
        this.sampleCount = n14;
    }

    public /* synthetic */ Ac3Util$SyncFrameInfo(String string2, int n10, int n11, int n12, int n13, int n14, Ac3Util$1 ac3Util$1) {
        this(string2, n10, n11, n12, n13, n14);
    }
}

