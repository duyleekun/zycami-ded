/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfm;

public final class zzfn
extends zzfm {
    private final Object zza;

    public zzfn(Object object) {
        this.zza = object;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof zzfn;
        if (bl2) {
            object = (zzfn)object;
            Object object2 = this.zza;
            object = ((zzfn)object).zza;
            return object2.equals(object);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zza);
        int n10 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += 13);
        stringBuilder.append("Optional.of(");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final boolean zza() {
        return true;
    }

    public final Object zzb() {
        return this.zza;
    }
}

