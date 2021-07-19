/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AacUtil$1;

public final class AacUtil$Config {
    public final int channelCount;
    public final String codecs;
    public final int sampleRateHz;

    private AacUtil$Config(int n10, int n11, String string2) {
        this.sampleRateHz = n10;
        this.channelCount = n11;
        this.codecs = string2;
    }

    public /* synthetic */ AacUtil$Config(int n10, int n11, String string2, AacUtil$1 aacUtil$1) {
        this(n10, n11, string2);
    }
}

