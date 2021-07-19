/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzg;
import com.google.android.gms.internal.mlkit_vision_face.zzj;

public final class zzi
extends zzg {
    private final Object zza;

    public zzi(Object object) {
        this.zza = object;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof zzi;
        if (bl2) {
            object = (zzi)object;
            Object object2 = this.zza;
            object = ((zzi)object).zza;
            return object2.equals(object);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zza);
        int n10 = String.valueOf(string2).length() + 13;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Optional.of(");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final Object zza(Object object) {
        zzj.zza(object, (Object)"use Optional.orNull() instead of Optional.or(null)");
        return this.zza;
    }

    public final boolean zza() {
        return true;
    }
}

