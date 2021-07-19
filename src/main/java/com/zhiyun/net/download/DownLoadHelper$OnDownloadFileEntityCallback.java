/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.api.entity.DownloadEntity;

public interface DownLoadHelper$OnDownloadFileEntityCallback {
    public void cancel(DownloadEntity var1);

    public void downloadCount(DownloadEntity var1, int var2, int var3);

    public void downloadFailed(DownloadEntity var1, Throwable var2);

    public void downloadProgress(DownloadEntity var1, int var2, long var3, long var5);

    public void downloadSuccess(DownloadEntity var1);

    public void saveFailed(DownloadEntity var1, Throwable var2);
}

