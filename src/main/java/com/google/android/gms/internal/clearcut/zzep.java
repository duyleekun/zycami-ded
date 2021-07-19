/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzei;
import java.util.Map;

public final class zzep
implements Comparable,
Map.Entry {
    private Object value;
    private final /* synthetic */ zzei zzos;
    private final Comparable zzov;

    public zzep(zzei zzei2, Comparable comparable, Object object) {
        this.zzos = zzei2;
        this.zzov = comparable;
        this.value = object;
    }

    public zzep(zzei zzei2, Map.Entry entry) {
        Comparable comparable = (Comparable)entry.getKey();
        entry = entry.getValue();
        this(zzei2, comparable, entry);
    }

    private static boolean equals(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public final /* synthetic */ int compareTo(Object object) {
        object = (zzep)object;
        Comparable comparable = (Comparable)this.getKey();
        object = (Comparable)((zzep)object).getKey();
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
        Object object2 = this.zzov;
        Object k10 = (object = (Map.Entry)object).getKey();
        bl4 = zzep.equals(object2, k10);
        if (bl4 && (bl2 = zzep.equals(object2 = this.value, object = object.getValue()))) {
            return bl3;
        }
        return false;
    }

    public final /* synthetic */ Object getKey() {
        return this.zzov;
    }

    public final Object getValue() {
        return this.value;
    }

    public final int hashCode() {
        int n10;
        Comparable comparable = this.zzov;
        int n11 = 0;
        if (comparable == null) {
            n10 = 0;
            comparable = null;
        } else {
            n10 = comparable.hashCode();
        }
        Object object = this.value;
        if (object != null) {
            n11 = object.hashCode();
        }
        return n10 ^ n11;
    }

    public final Object setValue(Object object) {
        zzei.zza(this.zzos);
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    public final String toString() {
        String string2 = String.valueOf(this.zzov);
        String string3 = String.valueOf(this.value);
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

