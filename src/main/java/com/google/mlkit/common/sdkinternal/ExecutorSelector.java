/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

public class ExecutorSelector {
    private final Provider zza;

    public ExecutorSelector(Provider provider) {
        this.zza = provider;
    }

    public Executor getExecutorToUse(Executor executor) {
        if (executor != null) {
            return executor;
        }
        return (Executor)this.zza.get();
    }
}

