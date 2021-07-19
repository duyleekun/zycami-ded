/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public class DownLoadHelper$1
implements Runnable {
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback val$callback;
    public final /* synthetic */ Throwable val$e;

    public DownLoadHelper$1(DownLoadHelper downLoadHelper, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, Throwable throwable) {
        this.this$0 = downLoadHelper;
        this.val$callback = downLoadHelper$OnDownloadCallback;
        this.val$e = throwable;
    }

    public void run() {
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.val$callback;
        if (downLoadHelper$OnDownloadCallback != null) {
            Throwable throwable = this.val$e;
            downLoadHelper$OnDownloadCallback.downloadFailed(throwable);
        }
    }
}

