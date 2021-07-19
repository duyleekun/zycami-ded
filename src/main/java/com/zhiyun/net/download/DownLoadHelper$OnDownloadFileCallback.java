/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;

public interface DownLoadHelper$OnDownloadFileCallback
extends DownLoadHelper$OnDownloadCallback {
    public void cancel();

    public void downloadCount(int var1);

    public void saveFailed(Throwable var1);
}

