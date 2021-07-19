/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public class DownLoadHelper$2
implements Runnable {
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback val$callback;
    public final /* synthetic */ String val$savePath;

    public DownLoadHelper$2(DownLoadHelper downLoadHelper, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, String string2) {
        this.this$0 = downLoadHelper;
        this.val$callback = downLoadHelper$OnDownloadCallback;
        this.val$savePath = string2;
    }

    public void run() {
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.val$callback;
        if (downLoadHelper$OnDownloadCallback != null) {
            String string2 = this.val$savePath;
            downLoadHelper$OnDownloadCallback.downloadSuccess(string2);
        }
    }
}

