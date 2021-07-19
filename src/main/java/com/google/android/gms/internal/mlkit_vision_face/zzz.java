/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzh;
import java.util.Map;

public abstract class zzz
implements Map.Entry {
    public boolean equals(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (bl2) {
            boolean bl3;
            Object k10;
            object = (Map.Entry)object;
            Object object2 = this.getKey();
            bl2 = zzh.zza(object2, k10 = object.getKey());
            if (bl2 && (bl3 = zzh.zza(object2 = this.getValue(), object = object.getValue()))) {
                return true;
            }
        }
        return false;
    }

    public abstract Object getKey();

    public abstract Object getValue();

    public int hashCode() {
        int n10;
        Object object = this.getKey();
        Object object2 = this.getValue();
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 ^ n11;
    }

    public Object setValue(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public String toString() {
        String string2 = String.valueOf(this.getKey());
        String string3 = String.valueOf(this.getValue());
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

