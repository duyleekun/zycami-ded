/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.DownloadTask;

public class DownloadTask$5
implements Runnable {
    public final /* synthetic */ DownloadTask this$0;
    public final /* synthetic */ String val$savePath;

    public DownloadTask$5(DownloadTask downloadTask, String string2) {
        this.this$0 = downloadTask;
        this.val$savePath = string2;
    }

    public void run() {
        DownloadListener downloadListener = DownloadTask.access$300(this.this$0);
        if (downloadListener != null) {
            downloadListener = DownloadTask.access$300(this.this$0);
            String string2 = this.val$savePath;
            downloadListener.onSuccess(string2);
        }
    }
}

