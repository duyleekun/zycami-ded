/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public class DownLoadHelper$3
implements Runnable {
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback val$callback;
    public final /* synthetic */ int val$progress;

    public DownLoadHelper$3(DownLoadHelper downLoadHelper, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, int n10) {
        this.this$0 = downLoadHelper;
        this.val$callback = downLoadHelper$OnDownloadCallback;
        this.val$progress = n10;
    }

    public void run() {
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.val$callback;
        if (downLoadHelper$OnDownloadCallback != null) {
            int n10 = this.val$progress;
            downLoadHelper$OnDownloadCallback.downloadProgress(n10);
        }
    }
}

