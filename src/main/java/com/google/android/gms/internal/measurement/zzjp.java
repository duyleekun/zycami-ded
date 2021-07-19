/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjs;
import java.util.Map;

public final class zzjp
implements Map.Entry,
Comparable {
    public final /* synthetic */ zzjs zza;
    private final Comparable zzb;
    private Object zzc;

    public zzjp(zzjs zzjs2, Comparable comparable, Object object) {
        this.zza = zzjs2;
        this.zzb = comparable;
        this.zzc = object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean zzb(Object object, Object object2) {
        if (object != null) return object.equals(object2);
        if (object2 == null) return true;
        return false;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof Map.Entry;
        if (!bl4) {
            return false;
        }
        Object object2 = this.zzb;
        Object k10 = (object = (Map.Entry)object).getKey();
        bl4 = zzjp.zzb(object2, k10);
        if (bl4 && (bl2 = zzjp.zzb(object2 = this.zzc, object = object.getValue()))) {
            return bl3;
        }
        return false;
    }

    public final Object getValue() {
        return this.zzc;
    }

    public final int hashCode() {
        int n10;
        Comparable comparable = this.zzb;
        int n11 = 0;
        if (comparable == null) {
            n10 = 0;
            comparable = null;
        } else {
            n10 = comparable.hashCode();
        }
        Object object = this.zzc;
        if (object != null) {
            n11 = object.hashCode();
        }
        return n10 ^ n11;
    }

    public final Object setValue(Object object) {
        zzjs.zzg(this.zza);
        Object object2 = this.zzc;
        this.zzc = object;
        return object2;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zzb);
        String string3 = String.valueOf(this.zzc);
        int n10 = String.valueOf(string2).length();
        int n11 = String.valueOf(string3).length();
        n10 = n10 + 1 + n11;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final Comparable zza() {
        return this.zzb;
    }
}

