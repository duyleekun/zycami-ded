/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.SegmentDownloader$ProgressNotifier;
import com.google.android.exoplayer2.offline.SegmentDownloader$Segment;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.util.RunnableFutureTask;

public final class SegmentDownloader$SegmentDownloadRunnable
extends RunnableFutureTask {
    private final CacheWriter cacheWriter;
    public final CacheDataSource dataSource;
    private final SegmentDownloader$ProgressNotifier progressNotifier;
    public final SegmentDownloader$Segment segment;
    public final byte[] temporaryBuffer;

    public SegmentDownloader$SegmentDownloadRunnable(SegmentDownloader$Segment segmentDownloader$Segment, CacheDataSource cacheDataSource, SegmentDownloader$ProgressNotifier segmentDownloader$ProgressNotifier, byte[] byArray) {
        CacheWriter cacheWriter;
        this.segment = segmentDownloader$Segment;
        this.dataSource = cacheDataSource;
        this.progressNotifier = segmentDownloader$ProgressNotifier;
        this.temporaryBuffer = byArray;
        DataSpec dataSpec = segmentDownloader$Segment.dataSpec;
        this.cacheWriter = cacheWriter = new CacheWriter(cacheDataSource, dataSpec, false, byArray, segmentDownloader$ProgressNotifier);
    }

    public void cancelWork() {
        this.cacheWriter.cancel();
    }

    public Void doWork() {
        this.cacheWriter.cache();
        SegmentDownloader$ProgressNotifier segmentDownloader$ProgressNotifier = this.progressNotifier;
        if (segmentDownloader$ProgressNotifier != null) {
            segmentDownloader$ProgressNotifier.onSegmentDownloaded();
        }
        return null;
    }
}

