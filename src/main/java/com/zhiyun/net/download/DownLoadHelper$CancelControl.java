/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

public class DownLoadHelper$CancelControl {
    private boolean bCancel = false;

    public static /* synthetic */ boolean access$100(DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        return downLoadHelper$CancelControl.bCancel;
    }

    public void cancel() {
        this.bCancel = true;
    }

    public void reset() {
        this.bCancel = false;
    }
}

