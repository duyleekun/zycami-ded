/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import java.io.Serializable;
import java.util.Objects;

public final class zzfp
implements Serializable,
zzfo {
    public final zzfo zza;
    public volatile transient boolean zzb;
    public transient Object zzc;

    public zzfp(zzfo zzfo2) {
        Objects.requireNonNull(zzfo2);
        this.zza = zzfo2;
    }

    public final String toString() {
        StringBuilder stringBuilder;
        int n10;
        Object object;
        boolean bl2 = this.zzb;
        if (bl2) {
            object = String.valueOf(this.zzc);
            n10 = String.valueOf(object).length();
            stringBuilder = new StringBuilder(n10 += 25);
            String string2 = "<supplier that returned ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            stringBuilder.append(">");
            object = stringBuilder.toString();
        } else {
            object = this.zza;
        }
        object = String.valueOf(object);
        n10 = String.valueOf(object).length();
        stringBuilder = new StringBuilder(n10 += 19);
        stringBuilder.append("Suppliers.memoize(");
        stringBuilder.append((String)object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza() {
        boolean bl2 = this.zzb;
        if (bl2) return this.zzc;
        synchronized (this) {
            boolean bl3;
            bl2 = this.zzb;
            if (bl2) return this.zzc;
            Object object = this.zza;
            this.zzc = object = object.zza();
            this.zzb = bl3 = true;
            return object;
        }
    }
}

