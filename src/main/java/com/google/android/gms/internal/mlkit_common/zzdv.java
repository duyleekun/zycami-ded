/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzdv
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzdv zzdv2 = new zzdv();
        zza = zzdv2;
    }

    private zzdv() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return zzds.zza(componentContainer);
    }
}

