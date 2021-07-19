/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

public final class VorbisUtil$VorbisIdHeader {
    public final int bitrateMaximum;
    public final int bitrateMinimum;
    public final int bitrateNominal;
    public final int blockSize0;
    public final int blockSize1;
    public final int channels;
    public final byte[] data;
    public final boolean framingFlag;
    public final int sampleRate;
    public final int version;

    public VorbisUtil$VorbisIdHeader(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, boolean bl2, byte[] byArray) {
        this.version = n10;
        this.channels = n11;
        this.sampleRate = n12;
        this.bitrateMaximum = n13;
        this.bitrateNominal = n14;
        this.bitrateMinimum = n15;
        this.blockSize0 = n16;
        this.blockSize1 = n17;
        this.framingFlag = bl2;
        this.data = byArray;
    }
}

