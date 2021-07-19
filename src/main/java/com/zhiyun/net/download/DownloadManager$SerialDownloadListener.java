/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

public interface DownloadManager$SerialDownloadListener {
    public void serialDownloadCancel(String var1);

    public void serialDownloadFail(String var1);

    public void serialDownloadProgress(String var1, float var2);

    public void serialDownloadSuccess(String var1, String var2);
}

