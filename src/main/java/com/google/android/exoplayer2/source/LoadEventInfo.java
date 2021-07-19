/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class LoadEventInfo {
    private static final AtomicLong idSource;
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final long elapsedRealtimeMs;
    public final long loadDurationMs;
    public final long loadTaskId;
    public final Map responseHeaders;
    public final Uri uri;

    static {
        AtomicLong atomicLong;
        idSource = atomicLong = new AtomicLong();
    }

    public LoadEventInfo(long l10, DataSpec dataSpec, long l11) {
        Uri uri = dataSpec.uri;
        Map map = Collections.emptyMap();
        this(l10, dataSpec, uri, map, l11, 0L, 0L);
    }

    public LoadEventInfo(long l10, DataSpec dataSpec, Uri uri, Map map, long l11, long l12, long l13) {
        this.loadTaskId = l10;
        this.dataSpec = dataSpec;
        this.uri = uri;
        this.responseHeaders = map;
        this.elapsedRealtimeMs = l11;
        this.loadDurationMs = l12;
        this.bytesLoaded = l13;
    }

    public static long getNewId() {
        return idSource.getAndIncrement();
    }
}

