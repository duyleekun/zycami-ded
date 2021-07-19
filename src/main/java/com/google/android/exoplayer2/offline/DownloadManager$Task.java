/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.google.android.exoplayer2.offline;

import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadManager$1;
import com.google.android.exoplayer2.offline.DownloadManager$InternalHandler;
import com.google.android.exoplayer2.offline.DownloadProgress;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.Downloader$ProgressListener;
import java.io.IOException;

public class DownloadManager$Task
extends Thread
implements Downloader$ProgressListener {
    private long contentLength;
    private final DownloadProgress downloadProgress;
    private final Downloader downloader;
    private Exception finalException;
    private volatile DownloadManager$InternalHandler internalHandler;
    private volatile boolean isCanceled;
    private final boolean isRemove;
    private final int minRetryCount;
    private final DownloadRequest request;

    private DownloadManager$Task(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean bl2, int n10, DownloadManager$InternalHandler downloadManager$InternalHandler) {
        this.request = downloadRequest;
        this.downloader = downloader;
        this.downloadProgress = downloadProgress;
        this.isRemove = bl2;
        this.minRetryCount = n10;
        this.internalHandler = downloadManager$InternalHandler;
        this.contentLength = -1;
    }

    public /* synthetic */ DownloadManager$Task(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean bl2, int n10, DownloadManager$InternalHandler downloadManager$InternalHandler, DownloadManager$1 downloadManager$1) {
        this(downloadRequest, downloader, downloadProgress, bl2, n10, downloadManager$InternalHandler);
    }

    public static /* synthetic */ boolean access$000(DownloadManager$Task downloadManager$Task) {
        return downloadManager$Task.isRemove;
    }

    public static /* synthetic */ DownloadRequest access$200(DownloadManager$Task downloadManager$Task) {
        return downloadManager$Task.request;
    }

    public static /* synthetic */ boolean access$300(DownloadManager$Task downloadManager$Task) {
        return downloadManager$Task.isCanceled;
    }

    public static /* synthetic */ Exception access$400(DownloadManager$Task downloadManager$Task) {
        return downloadManager$Task.finalException;
    }

    private static int getRetryDelayMillis(int n10) {
        return Math.min((n10 + -1) * 1000, 5000);
    }

    public void cancel(boolean bl2) {
        Downloader downloader;
        if (bl2) {
            bl2 = false;
            downloader = null;
            this.internalHandler = null;
        }
        if (!(bl2 = this.isCanceled)) {
            this.isCanceled = bl2 = true;
            downloader = this.downloader;
            downloader.cancel();
            this.interrupt();
        }
    }

    public void onProgress(long l10, long l11, float f10) {
        DownloadProgress downloadProgress = this.downloadProgress;
        downloadProgress.bytesDownloaded = l11;
        Object object = this.downloadProgress;
        object.percentDownloaded = f10;
        l11 = this.contentLength;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            this.contentLength = l10;
            object = this.internalHandler;
            if (object != null) {
                int n10 = 10;
                f10 = 4.5E-44f;
                long l13 = l10 >> 32;
                int n11 = (int)l13;
                int n12 = (int)l10;
                Message message = object.obtainMessage(n10, n11, n12, this);
                message.sendToTarget();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        Object object;
        block17: {
            boolean bl2 = this.isRemove;
            if (!bl2) break block17;
            object = this.downloader;
            object.remove();
        }
        long l10 = -1;
        int n10 = 0;
        while (true) {
            int n11 = this.isCanceled;
            if (n11 != 0) break;
            Downloader downloader = this.downloader;
            try {
                downloader.download(this);
            }
            catch (IOException iOException) {
                int n12 = this.isCanceled;
                if (n12 != 0) continue;
                DownloadProgress downloadProgress = this.downloadProgress;
                long l11 = downloadProgress.bytesDownloaded;
                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (l12 != false) {
                    n10 = 0;
                    l10 = l11;
                }
                ++n10;
                n12 = this.minRetryCount;
                if (n10 > n12) throw iOException;
                n11 = DownloadManager$Task.getRetryDelayMillis(n10);
                long l13 = n11;
                try {
                    Thread.sleep(l13);
                    continue;
                }
                catch (Exception exception) {
                    this.finalException = exception;
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                }
            }
            break;
        }
        object = this.internalHandler;
        if (object == null) return;
        int n13 = 9;
        object = object.obtainMessage(n13, (Object)this);
        object.sendToTarget();
    }
}

