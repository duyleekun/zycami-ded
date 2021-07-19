/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.SafeLoggingExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ExecutionModule {
    public static Executor executor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        SafeLoggingExecutor safeLoggingExecutor = new SafeLoggingExecutor(executorService);
        return safeLoggingExecutor;
    }
}

