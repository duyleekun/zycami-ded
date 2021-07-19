/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import java.util.concurrent.ThreadFactory;

public final class InternalRequestOperation$1
implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "oss-android-api-thread");
        return thread;
    }
}

