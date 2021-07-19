/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public abstract class Chunk
implements Loader$Loadable {
    public final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    public final long endTimeUs;
    public final long loadTaskId;
    public final long startTimeUs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int type;

    public Chunk(DataSource object, DataSpec dataSpec, int n10, Format format, int n11, Object object2, long l10, long l11) {
        long l12;
        StatsDataSource statsDataSource;
        this.dataSource = statsDataSource = new StatsDataSource((DataSource)object);
        this.dataSpec = object = (DataSpec)Assertions.checkNotNull(dataSpec);
        this.type = n10;
        this.trackFormat = format;
        this.trackSelectionReason = n11;
        this.trackSelectionData = object2;
        this.startTimeUs = l10;
        this.endTimeUs = l11;
        this.loadTaskId = l12 = LoadEventInfo.getNewId();
    }

    public final long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    public final long getDurationUs() {
        long l10 = this.endTimeUs;
        long l11 = this.startTimeUs;
        return l10 - l11;
    }

    public final Map getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    public final Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }
}

