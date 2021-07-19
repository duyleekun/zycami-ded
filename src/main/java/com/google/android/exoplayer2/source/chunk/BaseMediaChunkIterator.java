/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.NoSuchElementException;

public abstract class BaseMediaChunkIterator
implements MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long l10, long l11) {
        this.fromIndex = l10;
        this.toIndex = l11;
        this.reset();
    }

    public final void checkInBounds() {
        long l10;
        long l11;
        long l12 = this.currentIndex;
        long l13 = this.fromIndex;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object >= 0 && (l11 = (l10 = l12 - (l13 = this.toIndex)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0) {
            return;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final long getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean isEnded() {
        long l10 = this.currentIndex;
        long l11 = this.toIndex;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean next() {
        long l10;
        this.currentIndex = l10 = this.currentIndex + 1L;
        return this.isEnded() ^ true;
    }

    public void reset() {
        long l10;
        this.currentIndex = l10 = this.fromIndex - 1L;
    }
}

