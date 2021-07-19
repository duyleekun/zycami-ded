/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.face.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.internal.zzc;

public final class zzf
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzf zzf2 = new zzf();
        zza = zzf2;
    }

    private zzf() {
    }

    public final Object create(ComponentContainer object) {
        object = (MlKitContext)object.get(MlKitContext.class);
        zzc zzc2 = new zzc((MlKitContext)object);
        return zzc2;
    }
}

