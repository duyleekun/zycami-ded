/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadTask;
import java.io.IOException;

public class DownloadTask$2
implements Runnable {
    public final /* synthetic */ DownloadTask this$0;
    public final /* synthetic */ long val$endIndex;
    public final /* synthetic */ long val$startIndex;
    public final /* synthetic */ int val$threadId;

    public DownloadTask$2(DownloadTask downloadTask, long l10, long l11, int n10) {
        this.this$0 = downloadTask;
        this.val$startIndex = l10;
        this.val$endIndex = l11;
        this.val$threadId = n10;
    }

    public void run() {
        DownloadTask downloadTask = this.this$0;
        long l10 = this.val$startIndex;
        long l11 = this.val$endIndex;
        int n10 = this.val$threadId;
        try {
            DownloadTask.access$100(downloadTask, l10, l11, n10);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

