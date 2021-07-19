/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public String toString() {
        long l10 = this.zza();
        int n10 = this.zzb();
        long l11 = this.zzc();
        String string2 = this.zzd();
        int n11 = String.valueOf(string2).length() + 53;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(l10);
        String string3 = "\t";
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        stringBuilder.append(string3);
        stringBuilder.append(l11);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public abstract long zza();

    public abstract int zzb();

    public abstract long zzc();

    public abstract String zzd();
}

