/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcz;
import com.google.android.gms.internal.vision.zzdf;
import java.io.Serializable;
import java.util.Arrays;

public final class zzdj
implements zzdf,
Serializable {
    private final Object zzmd;

    public zzdj(Object object) {
        this.zzmd = object;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof zzdj;
        if (bl2) {
            object = (zzdj)object;
            Object object2 = this.zzmd;
            object = ((zzdj)object).zzmd;
            return zzcz.equal(object2, object);
        }
        return false;
    }

    public final Object get() {
        return this.zzmd;
    }

    public final int hashCode() {
        Object object = this.zzmd;
        Object[] objectArray = new Object[]{object};
        return Arrays.hashCode(objectArray);
    }

    public final String toString() {
        String string2 = String.valueOf(this.zzmd);
        int n10 = String.valueOf(string2).length() + 22;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Suppliers.ofInstance(");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

