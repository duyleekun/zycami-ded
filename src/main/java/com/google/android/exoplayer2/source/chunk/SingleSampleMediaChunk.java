/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;

public final class SingleSampleMediaChunk
extends BaseMediaChunk {
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final Format sampleFormat;
    private final int trackType;

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int n10, Object object, long l10, long l11, long l12, int n11, Format format2) {
        super(dataSource, dataSpec, format, n10, object, l10, l11, -9223372036854775807L, -9223372036854775807L, l12);
        this.trackType = n11;
        this.sampleFormat = format2;
    }

    public void cancelLoad() {
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public void load() {
        boolean bl2;
        Object object = this.getOutput();
        long l10 = 0L;
        ((BaseMediaChunkOutput)object).setSampleOffsetUs(l10);
        int n10 = this.trackType;
        int n11 = 0;
        TrackOutput trackOutput = ((BaseMediaChunkOutput)object).track(0, n10);
        object = this.sampleFormat;
        trackOutput.format((Format)object);
        object = this.dataSpec;
        long l11 = this.nextLoadPosition;
        object = ((DataSpec)object).subrange(l11);
        StatsDataSource statsDataSource = this.dataSource;
        long l12 = statsDataSource.open((DataSpec)object);
        l11 = -1;
        long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (l13 != false) {
            l11 = this.nextLoadPosition;
            l12 += l11;
        }
        StatsDataSource statsDataSource2 = this.dataSource;
        long l14 = this.nextLoadPosition;
        object = new DefaultExtractorInput(statsDataSource2, l14, l12);
        while (true) {
            n10 = -1;
            bl2 = true;
            if (n11 == n10) break;
            l11 = this.nextLoadPosition;
            l10 = n11;
            l11 += l10;
            this.nextLoadPosition = l11;
            n10 = -1 >>> 1;
            n11 = trackOutput.sampleData((DataReader)object, n10, bl2);
            continue;
            break;
        }
        l12 = this.nextLoadPosition;
        int n12 = (int)l12;
        try {
            l11 = this.startTimeUs;
            int n13 = 1;
            trackOutput.sampleMetadata(l11, n13, n12, 0, null);
            this.loadCompleted = bl2;
            return;
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}

