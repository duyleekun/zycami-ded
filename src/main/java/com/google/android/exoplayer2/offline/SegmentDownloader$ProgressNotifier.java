/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.Downloader$ProgressListener;
import com.google.android.exoplayer2.upstream.cache.CacheWriter$ProgressListener;

public final class SegmentDownloader$ProgressNotifier
implements CacheWriter$ProgressListener {
    private long bytesDownloaded;
    private final long contentLength;
    private final Downloader$ProgressListener progressListener;
    private int segmentsDownloaded;
    private final int totalSegments;

    public SegmentDownloader$ProgressNotifier(Downloader$ProgressListener downloader$ProgressListener, long l10, int n10, long l11, int n11) {
        this.progressListener = downloader$ProgressListener;
        this.contentLength = l10;
        this.totalSegments = n10;
        this.bytesDownloaded = l11;
        this.segmentsDownloaded = n11;
    }

    private float getPercentDownloaded() {
        long l10;
        long l11;
        long l12 = this.contentLength;
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        float f10 = 100.0f;
        if (l14 != false && (l14 = (l11 = l12 - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            float f11 = (float)this.bytesDownloaded * f10;
            float f12 = l12;
            return f11 / f12;
        }
        int n10 = this.totalSegments;
        if (n10 != 0) {
            float f13 = (float)this.segmentsDownloaded * f10;
            float f14 = n10;
            return f13 / f14;
        }
        return -1.0f;
    }

    public void onProgress(long l10, long l11, long l12) {
        long l13;
        this.bytesDownloaded = l13 = this.bytesDownloaded + l12;
        Downloader$ProgressListener downloader$ProgressListener = this.progressListener;
        long l14 = this.contentLength;
        float f10 = this.getPercentDownloaded();
        downloader$ProgressListener.onProgress(l14, l13, f10);
    }

    public void onSegmentDownloaded() {
        int n10;
        this.segmentsDownloaded = n10 = this.segmentsDownloaded + 1;
        Downloader$ProgressListener downloader$ProgressListener = this.progressListener;
        long l10 = this.contentLength;
        long l11 = this.bytesDownloaded;
        float f10 = this.getPercentDownloaded();
        downloader$ProgressListener.onProgress(l10, l11, f10);
    }
}

