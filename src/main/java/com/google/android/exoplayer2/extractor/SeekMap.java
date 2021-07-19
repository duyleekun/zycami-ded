/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;

public interface SeekMap {
    public long getDurationUs();

    public SeekMap$SeekPoints getSeekPoints(long var1);

    public boolean isSeekable();
}

