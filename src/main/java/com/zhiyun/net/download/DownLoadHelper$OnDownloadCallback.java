/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

public interface DownLoadHelper$OnDownloadCallback {
    public void downloadFailed(Throwable var1);

    public void downloadProgress(int var1);

    public void downloadSuccess(String var1);
}

