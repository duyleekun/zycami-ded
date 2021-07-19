/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils$1;

public class ExecutorUtils$1$1
extends BackgroundPriorityRunnable {
    public final /* synthetic */ ExecutorUtils$1 this$0;
    public final /* synthetic */ Runnable val$runnable;

    public ExecutorUtils$1$1(ExecutorUtils$1 executorUtils$1, Runnable runnable) {
        this.this$0 = executorUtils$1;
        this.val$runnable = runnable;
    }

    public void onRun() {
        this.val$runnable.run();
    }
}

