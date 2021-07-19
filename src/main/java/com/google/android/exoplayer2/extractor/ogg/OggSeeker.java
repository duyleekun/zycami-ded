/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;

public interface OggSeeker {
    public SeekMap createSeekMap();

    public long read(ExtractorInput var1);

    public void startSeek(long var1);
}

