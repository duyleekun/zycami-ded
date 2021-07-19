/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzeo
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzeo zzeo2 = new zzeo();
        zza = zzeo2;
    }

    private zzeo() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return zzel.zza(componentContainer);
    }
}

