/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.ExtractorInput;

public interface WavExtractor$OutputWriter {
    public void init(int var1, long var2);

    public void reset(long var1);

    public boolean sampleData(ExtractorInput var1, long var2);
}

