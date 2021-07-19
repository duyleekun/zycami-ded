/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.NoSuchElementException;

public class MediaChunkIterator$1
implements MediaChunkIterator {
    public long getChunkEndTimeUs() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public long getChunkStartTimeUs() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public DataSpec getDataSpec() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public boolean isEnded() {
        return true;
    }

    public boolean next() {
        return false;
    }

    public void reset() {
    }
}

