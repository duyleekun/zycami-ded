/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;

public class ContainerMediaChunk
extends BaseMediaChunk {
    private final int chunkCount;
    private final ChunkExtractor chunkExtractor;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int n10, Object object, long l10, long l11, long l12, long l13, long l14, int n11, long l15, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, n10, object, l10, l11, l12, l13, l14);
        this.chunkCount = n11;
        this.sampleOffsetUs = l15;
        this.chunkExtractor = chunkExtractor;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public long getNextChunkIndex() {
        long l10 = this.chunkIndex;
        long l11 = this.chunkCount;
        return l10 + l11;
    }

    public ChunkExtractor$TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void load() {
        long l10;
        Object object;
        long l11;
        Object object2;
        long l12 = this.nextLoadPosition;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 == false) {
            long l15;
            object2 = this.getOutput();
            l11 = this.sampleOffsetUs;
            ((BaseMediaChunkOutput)object2).setSampleOffsetUs(l11);
            object = this.chunkExtractor;
            ChunkExtractor$TrackOutputProvider chunkExtractor$TrackOutputProvider = this.getTrackOutputProvider((BaseMediaChunkOutput)object2);
            l12 = this.clippedStartTimeUs;
            l10 = -9223372036854775807L;
            long l16 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
            if (l16 == false) {
                l12 = l10;
            } else {
                l15 = this.sampleOffsetUs;
                l12 -= l15;
            }
            l15 = this.clippedEndTimeUs;
            l16 = l15 == l10 ? 0 : (l15 < l10 ? -1 : 1);
            if (l16 == false) {
                l15 = l10;
            } else {
                l10 = this.sampleOffsetUs;
                l15 -= l10;
            }
            l10 = l12;
            object.init(chunkExtractor$TrackOutputProvider, l12, l15);
        }
        object2 = this.dataSpec;
        l11 = this.nextLoadPosition;
        object2 = ((DataSpec)object2).subrange(l11);
        Object object4 = this.dataSource;
        long l17 = ((DataSpec)object2).position;
        l10 = ((StatsDataSource)object4).open((DataSpec)object2);
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput((DataReader)object4, l17, l10);
        try {
            while ((object3 = (Object)this.loadCanceled) == false && (object3 = (Object)(object2 = this.chunkExtractor).read(defaultExtractorInput)) != false) {
            }
        }
        catch (Throwable throwable) {
            l11 = defaultExtractorInput.getPosition();
            object = this.dataSpec;
            l17 = ((DataSpec)object).position;
            l11 -= l17;
            this.nextLoadPosition = l11;
            throw throwable;
        }
        try {
            l12 = defaultExtractorInput.getPosition();
            object4 = this.dataSpec;
            l13 = ((DataSpec)object4).position;
            this.nextLoadPosition = l12 -= l13;
            object3 = this.loadCanceled ^ 1;
            this.loadCompleted = object3;
            return;
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}

