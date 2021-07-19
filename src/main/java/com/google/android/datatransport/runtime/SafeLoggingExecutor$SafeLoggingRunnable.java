/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;

public class SafeLoggingExecutor$SafeLoggingRunnable
implements Runnable {
    private final Runnable delegate;

    public SafeLoggingExecutor$SafeLoggingRunnable(Runnable runnable) {
        this.delegate = runnable;
    }

    public void run() {
        Runnable runnable = this.delegate;
        try {
            runnable.run();
        }
        catch (Exception exception) {
            String string2 = "Executor";
            String string3 = "Background execution failure.";
            Logging.e(string2, string3, exception);
        }
    }
}

