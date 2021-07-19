/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.DownloadTask;

public class DownloadTask$4
implements Runnable {
    public final /* synthetic */ DownloadTask this$0;

    public DownloadTask$4(DownloadTask downloadTask) {
        this.this$0 = downloadTask;
    }

    public void run() {
        DownloadListener downloadListener = DownloadTask.access$300(this.this$0);
        if (downloadListener != null) {
            downloadListener = DownloadTask.access$300(this.this$0);
            downloadListener.onFail();
        }
    }
}

