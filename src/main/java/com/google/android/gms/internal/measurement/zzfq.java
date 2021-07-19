/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfo;
import java.util.Objects;

public final class zzfq
implements zzfo {
    public volatile zzfo zza;
    public volatile boolean zzb;
    public Object zzc;

    public zzfq(zzfo zzfo2) {
        Objects.requireNonNull(zzfo2);
        this.zza = zzfo2;
    }

    public final String toString() {
        StringBuilder stringBuilder;
        int n10;
        Object object = this.zza;
        if (object == null) {
            object = String.valueOf(this.zzc);
            n10 = String.valueOf(object).length();
            stringBuilder = new StringBuilder(n10 += 25);
            String string2 = "<supplier that returned ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            stringBuilder.append(">");
            object = stringBuilder.toString();
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
            bl3 = false;
            this.zza = null;
            return object;
        }
    }
}

