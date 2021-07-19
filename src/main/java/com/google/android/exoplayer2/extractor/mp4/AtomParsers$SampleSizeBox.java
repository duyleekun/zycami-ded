/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

public interface AtomParsers$SampleSizeBox {
    public int getFixedSampleSize();

    public int getSampleCount();

    public int readNextSampleSize();
}

