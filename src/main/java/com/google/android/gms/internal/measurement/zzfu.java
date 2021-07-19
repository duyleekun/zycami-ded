/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class zzfu
extends WeakReference {
    private final int zza;

    public zzfu(Throwable throwable, ReferenceQueue referenceQueue) {
        super(throwable, referenceQueue);
        int n10;
        this.zza = n10 = System.identityHashCode(throwable);
    }

    public final boolean equals(Object object) {
        Class clazz;
        Class<?> clazz2;
        if (object != null && (clazz2 = object.getClass()) == (clazz = zzfu.class)) {
            boolean bl2 = true;
            if (this == object) {
                return bl2;
            }
            object = (zzfu)object;
            int n10 = this.zza;
            int n11 = ((zzfu)object).zza;
            if (n10 == n11 && (clazz = this.get()) == (object = ((Reference)object).get())) {
                return bl2;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}

