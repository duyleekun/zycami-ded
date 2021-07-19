/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzct
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzct zzct2 = new zzct();
        zza = zzct2;
    }

    private zzct() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return zzcq.zza(componentContainer);
    }
}

