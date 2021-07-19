/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory;

public final class ExecutionModule_ExecutorFactory$InstanceHolder {
    private static final ExecutionModule_ExecutorFactory INSTANCE;

    static {
        ExecutionModule_ExecutorFactory executionModule_ExecutorFactory;
        INSTANCE = executionModule_ExecutorFactory = new ExecutionModule_ExecutorFactory();
    }

    private ExecutionModule_ExecutorFactory$InstanceHolder() {
    }

    public static /* synthetic */ ExecutionModule_ExecutorFactory access$000() {
        return INSTANCE;
    }
}

