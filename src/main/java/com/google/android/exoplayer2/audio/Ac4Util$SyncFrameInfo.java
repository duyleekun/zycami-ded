/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.Ac4Util$1;

public final class Ac4Util$SyncFrameInfo {
    public final int bitstreamVersion;
    public final int channelCount;
    public final int frameSize;
    public final int sampleCount;
    public final int sampleRate;

    private Ac4Util$SyncFrameInfo(int n10, int n11, int n12, int n13, int n14) {
        this.bitstreamVersion = n10;
        this.channelCount = n11;
        this.sampleRate = n12;
        this.frameSize = n13;
        this.sampleCount = n14;
    }

    public /* synthetic */ Ac4Util$SyncFrameInfo(int n10, int n11, int n12, int n13, int n14, Ac4Util$1 ac4Util$1) {
        this(n10, n11, n12, n13, n14);
    }
}

