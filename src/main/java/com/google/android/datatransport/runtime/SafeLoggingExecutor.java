/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.SafeLoggingExecutor$SafeLoggingRunnable;
import java.util.concurrent.Executor;

public class SafeLoggingExecutor
implements Executor {
    private final Executor delegate;

    public SafeLoggingExecutor(Executor executor) {
        this.delegate = executor;
    }

    public void execute(Runnable runnable) {
        Executor executor = this.delegate;
        SafeLoggingExecutor$SafeLoggingRunnable safeLoggingExecutor$SafeLoggingRunnable = new SafeLoggingExecutor$SafeLoggingRunnable(runnable);
        executor.execute(safeLoggingExecutor$SafeLoggingRunnable);
    }
}

