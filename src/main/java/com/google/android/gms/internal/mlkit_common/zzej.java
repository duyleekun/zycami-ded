/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzha;
import com.google.android.gms.internal.mlkit_common.zzhb;

public abstract class zzej
implements zzha {
    public /* synthetic */ Object clone() {
        return this.zzb();
    }

    public abstract zzej zza(zzeg var1);

    public final /* synthetic */ zzha zza(zzhb object) {
        Class<?> clazz = this.zzn().getClass();
        boolean bl2 = clazz.isInstance(object);
        if (bl2) {
            object = (zzeg)object;
            return this.zza((zzeg)object);
        }
        object = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw object;
    }

    public abstract zzej zzb();
}

