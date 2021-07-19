/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.SingleDownloadManager;
import com.zhiyun.net.download.SingleDownloadManager$SerialDownloadListener;
import m.a.a;

public class SingleDownloadManager$1
implements DownloadListener {
    public final /* synthetic */ SingleDownloadManager this$0;

    public SingleDownloadManager$1(SingleDownloadManager singleDownloadManager) {
        this.this$0 = singleDownloadManager;
    }

    public void onCancel() {
        SingleDownloadManager$SerialDownloadListener singleDownloadManager$SerialDownloadListener = SingleDownloadManager.access$100(this.this$0);
        if (singleDownloadManager$SerialDownloadListener != null) {
            singleDownloadManager$SerialDownloadListener = SingleDownloadManager.access$100(this.this$0);
            String string2 = SingleDownloadManager.access$200(this.this$0);
            singleDownloadManager$SerialDownloadListener.serialDownloadCancel(string2);
        }
        SingleDownloadManager.access$302(this.this$0, null);
        SingleDownloadManager.access$202(this.this$0, null);
        SingleDownloadManager.access$400(this.this$0);
    }

    public void onFail() {
        SingleDownloadManager$SerialDownloadListener singleDownloadManager$SerialDownloadListener = SingleDownloadManager.access$100(this.this$0);
        if (singleDownloadManager$SerialDownloadListener != null) {
            singleDownloadManager$SerialDownloadListener = SingleDownloadManager.access$100(this.this$0);
            String string2 = SingleDownloadManager.access$200(this.this$0);
            singleDownloadManager$SerialDownloadListener.serialDownloadFail(string2);
        }
        SingleDownloadManager.access$302(this.this$0, null);
        SingleDownloadManager.access$202(this.this$0, null);
        SingleDownloadManager.access$400(this.this$0);
    }

    public void onPause() {
    }

    public void onProgress(float f10) {
        Object object = this.this$0;
        float f11 = SingleDownloadManager.access$000((SingleDownloadManager)object);
        float f12 = f11 - f10;
        Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2 != false) {
            SingleDownloadManager.access$002(this.this$0, f10);
            object2 = true;
            f11 = Float.MIN_VALUE;
            object = new Object[object2];
            Float f13 = Float.valueOf(f10);
            object[0] = f13;
            String string2 = "serial download progress = %s";
            a.b(string2, (Object[])object);
            object = SingleDownloadManager.access$100(this.this$0);
            if (object != null) {
                object = SingleDownloadManager.access$100(this.this$0);
                string2 = SingleDownloadManager.access$200(this.this$0);
                object.serialDownloadProgress(string2, f10);
            }
        }
    }

    public void onSuccess(String string2) {
        SingleDownloadManager$SerialDownloadListener singleDownloadManager$SerialDownloadListener = SingleDownloadManager.access$100(this.this$0);
        if (singleDownloadManager$SerialDownloadListener != null) {
            singleDownloadManager$SerialDownloadListener = SingleDownloadManager.access$100(this.this$0);
            String string3 = SingleDownloadManager.access$200(this.this$0);
            singleDownloadManager$SerialDownloadListener.serialDownloadSuccess(string3, string2);
        }
        SingleDownloadManager.access$302(this.this$0, null);
        SingleDownloadManager.access$202(this.this$0, null);
        SingleDownloadManager.access$400(this.this$0);
    }
}

