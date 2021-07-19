/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

public final class zzn
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzn zzn2 = new zzn();
        zza = zzn2;
    }

    private zzn() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return SharedPrefManager.zza(componentContainer);
    }
}

