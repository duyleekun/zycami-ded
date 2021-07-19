/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzeh;
import com.google.android.gms.internal.mlkit_vision_face.zzej;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class zzei
implements ComponentFactory {
    public static final ComponentFactory zza;

    static {
        zzei zzei2 = new zzei();
        zza = zzei2;
    }

    private zzei() {
    }

    public final Object create(ComponentContainer object) {
        object = (zzeh)object.get(zzeh.class);
        zzej zzej2 = new zzej((zzeh)object);
        return zzej2;
    }
}

