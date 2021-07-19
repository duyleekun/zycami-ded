/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ExtractorOutput$1;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;

public interface ExtractorOutput {
    public static final ExtractorOutput PLACEHOLDER;

    static {
        ExtractorOutput$1 extractorOutput$1 = new ExtractorOutput$1();
        PLACEHOLDER = extractorOutput$1;
    }

    public void endTracks();

    public void seekMap(SeekMap var1);

    public TrackOutput track(int var1, int var2);
}

