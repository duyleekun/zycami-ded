/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzeu;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzho;

public abstract class zzet
implements zzho {
    public /* synthetic */ Object clone() {
        return this.zzb();
    }

    public abstract zzet zza(zzeu var1);

    public final /* synthetic */ zzho zza(zzhl object) {
        Class<?> clazz = this.zzi().getClass();
        boolean bl2 = clazz.isInstance(object);
        if (bl2) {
            object = (zzeu)object;
            return this.zza((zzeu)object);
        }
        object = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw object;
    }

    public abstract zzet zzb();
}

