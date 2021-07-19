/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcm;
import com.google.android.gms.internal.mlkit_vision_common.zzco;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzcn
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzcn zzcn2 = new zzcn();
        zza = zzcn2;
    }

    private zzcn() {
    }

    public final Object create(ComponentContainer object) {
        object = (zzcm)object.get(zzcm.class);
        zzco zzco2 = new zzco((zzcm)object);
        return zzco2;
    }
}

