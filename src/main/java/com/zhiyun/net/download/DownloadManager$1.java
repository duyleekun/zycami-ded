/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.DownloadManager;
import com.zhiyun.net.download.DownloadManager$SerialDownloadListener;
import m.a.a;

public class DownloadManager$1
implements DownloadListener {
    public final /* synthetic */ DownloadManager this$0;

    public DownloadManager$1(DownloadManager downloadManager) {
        this.this$0 = downloadManager;
    }

    public void onCancel() {
        DownloadManager$SerialDownloadListener downloadManager$SerialDownloadListener = DownloadManager.access$100(this.this$0);
        if (downloadManager$SerialDownloadListener != null) {
            downloadManager$SerialDownloadListener = DownloadManager.access$100(this.this$0);
            String string2 = DownloadManager.access$200(this.this$0);
            downloadManager$SerialDownloadListener.serialDownloadCancel(string2);
        }
        DownloadManager.access$302(this.this$0, null);
        DownloadManager.access$202(this.this$0, null);
        DownloadManager.access$400(this.this$0);
    }

    public void onFail() {
        DownloadManager$SerialDownloadListener downloadManager$SerialDownloadListener = DownloadManager.access$100(this.this$0);
        if (downloadManager$SerialDownloadListener != null) {
            downloadManager$SerialDownloadListener = DownloadManager.access$100(this.this$0);
            String string2 = DownloadManager.access$200(this.this$0);
            downloadManager$SerialDownloadListener.serialDownloadFail(string2);
        }
        DownloadManager.access$302(this.this$0, null);
        DownloadManager.access$202(this.this$0, null);
        DownloadManager.access$400(this.this$0);
    }

    public void onPause() {
    }

    public void onProgress(float f10) {
        Object object = this.this$0;
        float f11 = DownloadManager.access$000((DownloadManager)object);
        float f12 = f11 - f10;
        Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2 != false) {
            DownloadManager.access$002(this.this$0, f10);
            object2 = true;
            f11 = Float.MIN_VALUE;
            object = new Object[object2];
            Float f13 = Float.valueOf(f10);
            object[0] = f13;
            String string2 = "serial download progress = %s";
            a.b(string2, (Object[])object);
            object = DownloadManager.access$100(this.this$0);
            if (object != null) {
                object = DownloadManager.access$100(this.this$0);
                string2 = DownloadManager.access$200(this.this$0);
                object.serialDownloadProgress(string2, f10);
            }
        }
    }

    public void onSuccess(String string2) {
        DownloadManager$SerialDownloadListener downloadManager$SerialDownloadListener = DownloadManager.access$100(this.this$0);
        if (downloadManager$SerialDownloadListener != null) {
            downloadManager$SerialDownloadListener = DownloadManager.access$100(this.this$0);
            String string3 = DownloadManager.access$200(this.this$0);
            downloadManager$SerialDownloadListener.serialDownloadSuccess(string3, string2);
        }
        DownloadManager.access$302(this.this$0, null);
        DownloadManager.access$202(this.this$0, null);
        DownloadManager.access$400(this.this$0);
    }
}

