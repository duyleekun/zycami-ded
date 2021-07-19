/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;

public final class zzc
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzc zzc2 = new zzc();
        zza = zzc2;
    }

    private zzc() {
    }

    public final Object create(ComponentContainer object) {
        object = object.getProvider(MlKitThreadPool.class);
        ExecutorSelector executorSelector = new ExecutorSelector((Provider)object);
        return executorSelector;
    }
}

