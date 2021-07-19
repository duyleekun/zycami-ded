/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;

public final class zza
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zza zza2 = new zza();
        zza = zza2;
    }

    private zza() {
    }

    public final Object create(ComponentContainer object) {
        object = new MlKitThreadPool();
        return object;
    }
}

