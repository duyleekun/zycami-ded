/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.Cleaner;

public final class zzf
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzf zzf2 = new zzf();
        zza = zzf2;
    }

    private zzf() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return Cleaner.create();
    }
}

