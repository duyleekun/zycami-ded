/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public class DownLoadHelper$4
implements Runnable {
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ DownLoadHelper$OnDownloadCallback val$callback;
    public final /* synthetic */ String val$destFileDir;
    public final /* synthetic */ String val$fileName;
    public final /* synthetic */ String val$url;

    public DownLoadHelper$4(DownLoadHelper downLoadHelper, String string2, String string3, String string4, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        this.this$0 = downLoadHelper;
        this.val$url = string2;
        this.val$destFileDir = string3;
        this.val$fileName = string4;
        this.val$callback = downLoadHelper$OnDownloadCallback;
    }

    public void run() {
        DownLoadHelper downLoadHelper = this.this$0;
        String string2 = this.val$url;
        String string3 = this.val$destFileDir;
        String string4 = this.val$fileName;
        DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback = this.val$callback;
        DownLoadHelper.access$000(downLoadHelper, string2, string3, string4, downLoadHelper$OnDownloadCallback);
    }
}

