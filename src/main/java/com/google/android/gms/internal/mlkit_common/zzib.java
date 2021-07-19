/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzhs;
import java.util.Map;

public final class zzib
implements Comparable,
Map.Entry {
    private final Comparable zza;
    private Object zzb;
    private final /* synthetic */ zzhs zzc;

    public zzib(zzhs zzhs2, Comparable comparable, Object object) {
        this.zzc = zzhs2;
        this.zza = comparable;
        this.zzb = object;
    }

    public zzib(zzhs zzhs2, Map.Entry entry) {
        Comparable comparable = (Comparable)entry.getKey();
        entry = entry.getValue();
        this(zzhs2, comparable, entry);
    }

    private static boolean zza(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public final /* synthetic */ int compareTo(Object object) {
        object = (zzib)object;
        Comparable comparable = (Comparable)this.getKey();
        object = (Comparable)((zzib)object).getKey();
        return comparable.compareTo(object);
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
        Object object2 = this.zza;
        Object k10 = (object = (Map.Entry)object).getKey();
        bl4 = zzib.zza(object2, k10);
        if (bl4 && (bl2 = zzib.zza(object2 = this.zzb, object = object.getValue()))) {
            return bl3;
        }
        return false;
    }

    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        return this.zzb;
    }

    public final int hashCode() {
        int n10;
        Comparable comparable = this.zza;
        int n11 = 0;
        if (comparable == null) {
            n10 = 0;
            comparable = null;
        } else {
            n10 = comparable.hashCode();
        }
        Object object = this.zzb;
        if (object != null) {
            n11 = object.hashCode();
        }
        return n10 ^ n11;
    }

    public final Object setValue(Object object) {
        zzhs.zza(this.zzc);
        Object object2 = this.zzb;
        this.zzb = object;
        return object2;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zza);
        String string3 = String.valueOf(this.zzb);
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

