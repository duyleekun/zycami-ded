/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.ResumableUploadTask;

public class ResumableUploadTask$1
implements Runnable {
    public final /* synthetic */ ResumableUploadTask this$0;
    public final /* synthetic */ int val$byteCount;
    public final /* synthetic */ int val$partNumber;
    public final /* synthetic */ int val$readIndex;

    public ResumableUploadTask$1(ResumableUploadTask resumableUploadTask, int n10, int n11, int n12) {
        this.this$0 = resumableUploadTask;
        this.val$readIndex = n10;
        this.val$byteCount = n11;
        this.val$partNumber = n12;
    }

    public void run() {
        ResumableUploadTask resumableUploadTask = this.this$0;
        int n10 = this.val$readIndex;
        int n11 = this.val$byteCount;
        int n12 = this.val$partNumber;
        resumableUploadTask.uploadPart(n10, n11, n12);
    }
}

