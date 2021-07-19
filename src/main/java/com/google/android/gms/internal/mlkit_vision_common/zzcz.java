/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzfu;

public abstract class zzcz
implements zzfu {
    public /* synthetic */ Object clone() {
        return this.zzb();
    }

    public abstract zzcz zza(zzda var1);

    public final /* synthetic */ zzfu zza(zzfr object) {
        Class<?> clazz = this.zzi().getClass();
        boolean bl2 = clazz.isInstance(object);
        if (bl2) {
            object = (zzda)object;
            return this.zza((zzda)object);
        }
        object = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw object;
    }

    public abstract zzcz zzb();
}

