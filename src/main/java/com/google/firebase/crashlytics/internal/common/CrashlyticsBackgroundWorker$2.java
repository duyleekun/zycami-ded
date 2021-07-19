/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import java.util.concurrent.Callable;

public class CrashlyticsBackgroundWorker$2
implements Callable {
    public final /* synthetic */ CrashlyticsBackgroundWorker this$0;
    public final /* synthetic */ Runnable val$runnable;

    public CrashlyticsBackgroundWorker$2(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, Runnable runnable) {
        this.this$0 = crashlyticsBackgroundWorker;
        this.val$runnable = runnable;
    }

    public Void call() {
        this.val$runnable.run();
        return null;
    }
}

