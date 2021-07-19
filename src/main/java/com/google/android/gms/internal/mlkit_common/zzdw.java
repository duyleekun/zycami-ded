/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzdw
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzdw zzdw2 = new zzdw();
        zza = zzdw2;
    }

    private zzdw() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return zzdx.zza(componentContainer);
    }
}

