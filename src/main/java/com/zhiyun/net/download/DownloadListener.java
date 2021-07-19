/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

public interface DownloadListener {
    public void onCancel();

    public void onFail();

    public void onPause();

    public void onProgress(float var1);

    public void onSuccess(String var1);
}

