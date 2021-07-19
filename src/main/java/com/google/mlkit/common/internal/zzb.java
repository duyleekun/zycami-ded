/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;

public final class zzb
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzb zzb2 = new zzb();
        zza = zzb2;
    }

    private zzb() {
    }

    public final Object create(ComponentContainer object) {
        object = (MlKitContext)object.get(MlKitContext.class);
        ModelFileHelper modelFileHelper = new ModelFileHelper((MlKitContext)object);
        return modelFileHelper;
    }
}

