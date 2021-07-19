/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import java.io.Serializable;
import java.util.Arrays;

public final class zzfr
implements Serializable,
zzfo {
    public final Object zza;

    public zzfr(Object object) {
        this.zza = object;
    }

    public final boolean equals(Object object) {
        boolean bl2 = object instanceof zzfr;
        if (bl2) {
            boolean bl3;
            object = (zzfr)object;
            Object object2 = this.zza;
            object = ((zzfr)object).zza;
            return object2 == object || (bl3 = object2.equals(object));
            {
            }
        }
        return false;
    }

    public final int hashCode() {
        Object object = this.zza;
        Object[] objectArray = new Object[]{object};
        return Arrays.hashCode(objectArray);
    }

    public final String toString() {
        String string2 = String.valueOf(this.zza);
        int n10 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += 22);
        stringBuilder.append("Suppliers.ofInstance(");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final Object zza() {
        return this.zza;
    }
}

