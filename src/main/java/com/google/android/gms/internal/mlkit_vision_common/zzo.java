/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

public final class zzo
extends WeakReference {
    private final int zza;

    public zzo(Throwable throwable, ReferenceQueue referenceQueue) {
        super(throwable, referenceQueue);
        int n10;
        Objects.requireNonNull(throwable, "The referent cannot be null");
        this.zza = n10 = System.identityHashCode(throwable);
    }

    public final boolean equals(Object object) {
        Class clazz;
        Class<?> clazz2;
        if (object != null && (clazz2 = object.getClass()) == (clazz = zzo.class)) {
            boolean bl2 = true;
            if (this == object) {
                return bl2;
            }
            object = (zzo)object;
            int n10 = this.zza;
            int n11 = ((zzo)object).zza;
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

