/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

public final class zzfi
extends WeakReference {
    private final int zzoc;

    public zzfi(Throwable throwable, ReferenceQueue referenceQueue) {
        super(throwable, referenceQueue);
        int n10;
        Objects.requireNonNull(throwable, "The referent cannot be null");
        this.zzoc = n10 = System.identityHashCode(throwable);
    }

    public final boolean equals(Object object) {
        Class clazz;
        Class<?> clazz2;
        if (object != null && (clazz2 = object.getClass()) == (clazz = zzfi.class)) {
            boolean bl2 = true;
            if (this == object) {
                return bl2;
            }
            object = (zzfi)object;
            int n10 = this.zzoc;
            int n11 = ((zzfi)object).zzoc;
            if (n10 == n11 && (clazz = this.get()) == (object = ((Reference)object).get())) {
                return bl2;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzoc;
    }
}

