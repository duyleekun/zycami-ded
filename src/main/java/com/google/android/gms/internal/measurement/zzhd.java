/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

public final class zzhd {
    private final Object zza;
    private final int zzb;

    public zzhd(Object object, int n10) {
        this.zza = object;
        this.zzb = n10;
    }

    public final boolean equals(Object object) {
        int n10;
        int n11 = object instanceof zzhd;
        if (n11 == 0) {
            return false;
        }
        object = (zzhd)object;
        Object object2 = this.zza;
        Object object3 = ((zzhd)object).zza;
        return object2 == object3 && (n11 = this.zzb) == (n10 = ((zzhd)object).zzb);
    }

    public final int hashCode() {
        int n10 = System.identityHashCode(this.zza) * (char)-1;
        int n11 = this.zzb;
        return n10 + n11;
    }
}

