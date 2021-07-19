/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap;

public interface Seeker
extends SeekMap {
    public long getDataEndPosition();

    public long getTimeUs(long var1);
}

