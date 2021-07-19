/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzl;
import com.google.android.gms.internal.common.zzo;

public final class zzp
implements zzo {
    private volatile zzo zza;
    private volatile boolean zzb;
    private Object zzc;

    public zzp(zzo zzo2) {
        this.zza = zzo2 = (zzo)zzl.zza(zzo2);
    }

    public final String toString() {
        StringBuilder stringBuilder;
        int n10;
        Object object = this.zza;
        if (object == null) {
            object = String.valueOf(this.zzc);
            n10 = String.valueOf(object).length() + 25;
            stringBuilder = new StringBuilder(n10);
            String string2 = "<supplier that returned ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            stringBuilder.append(">");
            object = stringBuilder.toString();
        }
        object = String.valueOf(object);
        n10 = String.valueOf(object).length() + 19;
        stringBuilder = new StringBuilder(n10);
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

