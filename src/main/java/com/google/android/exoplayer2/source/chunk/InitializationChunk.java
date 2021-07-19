/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;

public final class InitializationChunk
extends Chunk {
    private final ChunkExtractor chunkExtractor;
    private volatile boolean loadCanceled;
    private long nextLoadPosition;
    private ChunkExtractor$TrackOutputProvider trackOutputProvider;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int n10, Object object, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, n10, object, -9223372036854775807L, -9223372036854775807L);
        this.chunkExtractor = chunkExtractor;
    }

    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public void init(ChunkExtractor$TrackOutputProvider chunkExtractor$TrackOutputProvider) {
        this.trackOutputProvider = chunkExtractor$TrackOutputProvider;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void load() {
        DefaultExtractorInput defaultExtractorInput;
        long l10;
        long l11;
        Object object;
        Object object2;
        long l12 = this.nextLoadPosition;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 == false) {
            object2 = this.chunkExtractor;
            object = this.trackOutputProvider;
            l11 = -9223372036854775807L;
            l10 = -9223372036854775807L;
            object2.init((ChunkExtractor$TrackOutputProvider)object, l11, l10);
        }
        Object object4 = this.dataSpec;
        long l15 = this.nextLoadPosition;
        object4 = ((DataSpec)object4).subrange(l15);
        object = this.dataSource;
        l11 = ((DataSpec)object4).position;
        l10 = ((StatsDataSource)object).open((DataSpec)object4);
        object2 = defaultExtractorInput;
        defaultExtractorInput = new DefaultExtractorInput((DataReader)object, l11, l10);
        try {
            while ((object3 = (Object)this.loadCanceled) == false && (object3 = (Object)(object4 = this.chunkExtractor).read(defaultExtractorInput)) != false) {
            }
        }
        catch (Throwable throwable) {
            l15 = defaultExtractorInput.getPosition();
            DataSpec dataSpec = this.dataSpec;
            l11 = dataSpec.position;
            l15 -= l11;
            this.nextLoadPosition = l15;
            throw throwable;
        }
        try {
            l12 = defaultExtractorInput.getPosition();
            object = this.dataSpec;
            l13 = ((DataSpec)object).position;
            this.nextLoadPosition = l12 -= l13;
            return;
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}

