/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class MediaChunk
extends Chunk {
    public final long chunkIndex;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int n10, Object object, long l10, long l11, long l12) {
        super(dataSource, dataSpec, 1, format, n10, object, l10, l11);
        Assertions.checkNotNull(format);
        this.chunkIndex = l12;
    }

    public long getNextChunkIndex() {
        long l10 = this.chunkIndex;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = 1L + l10;
        }
        return l11;
    }

    public abstract boolean isLoadCompleted();
}

