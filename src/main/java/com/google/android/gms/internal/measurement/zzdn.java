/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdm;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;

public final class zzdn
extends Enum
implements zzhu {
    public static final /* enum */ zzdn zza;
    public static final /* enum */ zzdn zzb;
    private static final zzhv zzc;
    private static final /* synthetic */ zzdn[] zze;
    private final int zzd;

    static {
        zzdn zzdn2;
        int n10 = 1;
        Object object = new zzdn("RADS", 0, n10);
        zza = object;
        int n11 = 2;
        zzb = zzdn2 = new zzdn("PROVISIONING", n10, n11);
        zzdn[] zzdnArray = new zzdn[n11];
        zzdnArray[0] = object;
        zzdnArray[n10] = zzdn2;
        zze = zzdnArray;
        zzc = object = new zzdl();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdn() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzdn[] values() {
        return (zzdn[])zze.clone();
    }

    public static zzdn zza(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return null;
            }
            return zzb;
        }
        return zza;
    }

    public static zzhw zzb() {
        return zzdm.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdn.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzd;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

