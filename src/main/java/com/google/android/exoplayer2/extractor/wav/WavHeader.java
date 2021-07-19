/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.wav;

public final class WavHeader {
    public final int averageBytesPerSecond;
    public final int bitsPerSample;
    public final int blockSize;
    public final byte[] extraData;
    public final int formatType;
    public final int frameRateHz;
    public final int numChannels;

    public WavHeader(int n10, int n11, int n12, int n13, int n14, int n15, byte[] byArray) {
        this.formatType = n10;
        this.numChannels = n11;
        this.frameRateHz = n12;
        this.averageBytesPerSecond = n13;
        this.blockSize = n14;
        this.bitsPerSample = n15;
        this.extraData = byArray;
    }
}

