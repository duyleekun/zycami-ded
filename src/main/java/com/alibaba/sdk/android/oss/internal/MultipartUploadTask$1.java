/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.MultipartUploadTask;

public class MultipartUploadTask$1
implements Runnable {
    public final /* synthetic */ MultipartUploadTask this$0;
    public final /* synthetic */ int val$byteCount;
    public final /* synthetic */ int val$partNumber;
    public final /* synthetic */ int val$readIndex;

    public MultipartUploadTask$1(MultipartUploadTask multipartUploadTask, int n10, int n11, int n12) {
        this.this$0 = multipartUploadTask;
        this.val$readIndex = n10;
        this.val$byteCount = n11;
        this.val$partNumber = n12;
    }

    public void run() {
        MultipartUploadTask multipartUploadTask = this.this$0;
        int n10 = this.val$readIndex;
        int n11 = this.val$byteCount;
        int n12 = this.val$partNumber;
        multipartUploadTask.uploadPart(n10, n11, n12);
    }
}

