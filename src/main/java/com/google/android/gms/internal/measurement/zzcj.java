/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzch;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;

public final class zzcj
extends Enum
implements zzhu {
    public static final /* enum */ zzcj zza;
    public static final /* enum */ zzcj zzb;
    public static final /* enum */ zzcj zzc;
    public static final /* enum */ zzcj zzd;
    public static final /* enum */ zzcj zze;
    public static final /* enum */ zzcj zzf;
    public static final /* enum */ zzcj zzg;
    private static final zzhv zzh;
    private static final /* synthetic */ zzcj[] zzj;
    private final int zzi;

    static {
        zzcj zzcj2;
        zzcj zzcj3;
        zzcj zzcj4;
        zzcj zzcj5;
        zzcj zzcj6;
        zzcj zzcj7;
        Object object = new zzcj("UNKNOWN_MATCH_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcj7 = new zzcj("REGEXP", n10, n10);
        int n11 = 2;
        zzc = zzcj6 = new zzcj("BEGINS_WITH", n11, n11);
        int n12 = 3;
        zzd = zzcj5 = new zzcj("ENDS_WITH", n12, n12);
        int n13 = 4;
        zze = zzcj4 = new zzcj("PARTIAL", n13, n13);
        int n14 = 5;
        zzf = zzcj3 = new zzcj("EXACT", n14, n14);
        int n15 = 6;
        zzg = zzcj2 = new zzcj("IN_LIST", n15, n15);
        zzcj[] zzcjArray = new zzcj[7];
        zzcjArray[0] = object;
        zzcjArray[n10] = zzcj7;
        zzcjArray[n11] = zzcj6;
        zzcjArray[n12] = zzcj5;
        zzcjArray[n13] = zzcj4;
        zzcjArray[n14] = zzcj3;
        zzcjArray[n15] = zzcj2;
        zzj = zzcjArray;
        zzh = object = new zzch();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcj() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzcj[] values() {
        return (zzcj[])zzj.clone();
    }

    public static zzcj zza(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 6: {
                return zzg;
            }
            case 5: {
                return zzf;
            }
            case 4: {
                return zze;
            }
            case 3: {
                return zzd;
            }
            case 2: {
                return zzc;
            }
            case 1: {
                return zzb;
            }
            case 0: 
        }
        return zza;
    }

    public static zzhw zzb() {
        return zzci.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcj.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzi;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

