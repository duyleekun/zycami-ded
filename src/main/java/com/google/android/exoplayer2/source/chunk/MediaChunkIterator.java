/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.source.chunk.MediaChunkIterator$1;
import com.google.android.exoplayer2.upstream.DataSpec;

public interface MediaChunkIterator {
    public static final MediaChunkIterator EMPTY;

    static {
        MediaChunkIterator$1 mediaChunkIterator$1 = new MediaChunkIterator$1();
        EMPTY = mediaChunkIterator$1;
    }

    public long getChunkEndTimeUs();

    public long getChunkStartTimeUs();

    public DataSpec getDataSpec();

    public boolean isEnded();

    public boolean next();

    public void reset();
}

