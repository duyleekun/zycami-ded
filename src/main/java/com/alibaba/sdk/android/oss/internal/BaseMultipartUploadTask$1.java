/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask;
import java.util.concurrent.ThreadFactory;

public class BaseMultipartUploadTask$1
implements ThreadFactory {
    public final /* synthetic */ BaseMultipartUploadTask this$0;

    public BaseMultipartUploadTask$1(BaseMultipartUploadTask baseMultipartUploadTask) {
        this.this$0 = baseMultipartUploadTask;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "oss-android-multipart-thread");
        return thread;
    }
}

