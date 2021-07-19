/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

public final class zzho$zza {
    private final int number;
    private final Object object;

    public zzho$zza(Object object, int n10) {
        this.object = object;
        this.number = n10;
    }

    public final boolean equals(Object object) {
        int n10;
        int n11 = object instanceof zzho$zza;
        if (n11 == 0) {
            return false;
        }
        object = (zzho$zza)object;
        Object object2 = this.object;
        Object object3 = ((zzho$zza)object).object;
        return object2 == object3 && (n11 = this.number) == (n10 = ((zzho$zza)object).number);
    }

    public final int hashCode() {
        int n10 = System.identityHashCode(this.object) * (char)-1;
        int n11 = this.number;
        return n10 + n11;
    }
}

