/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzz;
import java.io.Serializable;

public final class zzar
extends zzz
implements Serializable {
    private final Object zza;
    private final Object zzb;

    public zzar(Object object, Object object2) {
        this.zza = object;
        this.zzb = object2;
    }

    public final Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        return this.zzb;
    }

    public final Object setValue(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

