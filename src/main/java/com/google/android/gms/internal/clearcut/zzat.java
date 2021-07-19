/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzas;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzdp;

public abstract class zzat
implements zzdp {
    public /* synthetic */ Object clone() {
        return this.zzt();
    }

    public abstract zzat zza(zzas var1);

    public final /* synthetic */ zzdp zza(zzdo object) {
        Class<?> clazz = this.zzbe().getClass();
        boolean bl2 = clazz.isInstance(object);
        if (bl2) {
            object = (zzas)object;
            return this.zza((zzas)object);
        }
        object = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw object;
    }

    public abstract zzat zzt();
}

