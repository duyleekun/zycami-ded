/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import java.util.concurrent.Callable;

public class CrashlyticsBackgroundWorker$3
implements Continuation {
    public final /* synthetic */ CrashlyticsBackgroundWorker this$0;
    public final /* synthetic */ Callable val$callable;

    public CrashlyticsBackgroundWorker$3(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, Callable callable) {
        this.this$0 = crashlyticsBackgroundWorker;
        this.val$callable = callable;
    }

    public Object then(Task task) {
        return this.val$callable.call();
    }
}

