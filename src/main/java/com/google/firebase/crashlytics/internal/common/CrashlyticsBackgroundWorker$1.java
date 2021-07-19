/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;

public class CrashlyticsBackgroundWorker$1
implements Runnable {
    public final /* synthetic */ CrashlyticsBackgroundWorker this$0;

    public CrashlyticsBackgroundWorker$1(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.this$0 = crashlyticsBackgroundWorker;
    }

    public void run() {
        ThreadLocal threadLocal = CrashlyticsBackgroundWorker.access$000(this.this$0);
        Boolean bl2 = Boolean.TRUE;
        threadLocal.set(bl2);
    }
}

