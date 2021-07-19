/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadProgress;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.Assertions;

public final class Download {
    public static final int FAILURE_REASON_NONE = 0;
    public static final int FAILURE_REASON_UNKNOWN = 1;
    public static final int STATE_COMPLETED = 3;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_FAILED = 4;
    public static final int STATE_QUEUED = 0;
    public static final int STATE_REMOVING = 5;
    public static final int STATE_RESTARTING = 7;
    public static final int STATE_STOPPED = 1;
    public static final int STOP_REASON_NONE;
    public final long contentLength;
    public final int failureReason;
    public final DownloadProgress progress;
    public final DownloadRequest request;
    public final long startTimeMs;
    public final int state;
    public final int stopReason;
    public final long updateTimeMs;

    public Download(DownloadRequest downloadRequest, int n10, long l10, long l11, long l12, int n11, int n12) {
        DownloadProgress downloadProgress = new DownloadProgress();
        this(downloadRequest, n10, l10, l11, l12, n11, n12, downloadProgress);
    }

    public Download(DownloadRequest downloadRequest, int n10, long l10, long l11, long l12, int n11, int n12, DownloadProgress downloadProgress) {
        Assertions.checkNotNull(downloadProgress);
        int n13 = 1;
        int n14 = n12 == 0 ? n13 : 0;
        int n15 = 4;
        n15 = n10 != n15 ? n13 : 0;
        n14 = n14 == n15 ? n13 : 0;
        Assertions.checkArgument(n14 != 0);
        if (n11 != 0) {
            n14 = 2;
            if (n10 == n14 || n10 == 0) {
                n13 = 0;
            }
            Assertions.checkArgument(n13 != 0);
        }
        this.request = downloadRequest;
        this.state = n10;
        this.startTimeMs = l10;
        this.updateTimeMs = l11;
        this.contentLength = l12;
        this.stopReason = n11;
        this.failureReason = n12;
        this.progress = downloadProgress;
    }

    public long getBytesDownloaded() {
        return this.progress.bytesDownloaded;
    }

    public float getPercentDownloaded() {
        return this.progress.percentDownloaded;
    }

    public boolean isTerminalState() {
        int n10 = this.state;
        int n11 = 3;
        n10 = n10 != n11 && n10 != (n11 = 4) ? 0 : 1;
        return n10 != 0;
    }
}

