/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class BaseMediaChunk
extends MediaChunk {
    public final long clippedEndTimeUs;
    public final long clippedStartTimeUs;
    private int[] firstSampleIndices;
    private BaseMediaChunkOutput output;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int n10, Object object, long l10, long l11, long l12, long l13, long l14) {
        super(dataSource, dataSpec, format, n10, object, l10, l11, l14);
        this.clippedStartTimeUs = l12;
        this.clippedEndTimeUs = l13;
    }

    public final int getFirstSampleIndex(int n10) {
        return ((int[])Assertions.checkStateNotNull(this.firstSampleIndices))[n10];
    }

    public final BaseMediaChunkOutput getOutput() {
        return (BaseMediaChunkOutput)Assertions.checkStateNotNull(this.output);
    }

    public void init(BaseMediaChunkOutput object) {
        this.output = object;
        object = ((BaseMediaChunkOutput)object).getWriteIndices();
        this.firstSampleIndices = (int[])object;
    }
}

