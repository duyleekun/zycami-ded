/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdo;
import com.google.android.gms.internal.mlkit_common.zzdq;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzdp
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzdp zzdp2 = new zzdp();
        zza = zzdp2;
    }

    private zzdp() {
    }

    public final Object create(ComponentContainer object) {
        object = (zzdo)object.get(zzdo.class);
        zzdq zzdq2 = new zzdq((zzdo)object);
        return zzdq2;
    }
}

