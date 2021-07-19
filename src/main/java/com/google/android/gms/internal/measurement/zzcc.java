/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;

public final class zzcc
extends Enum
implements zzhu {
    public static final /* enum */ zzcc zza;
    public static final /* enum */ zzcc zzb;
    public static final /* enum */ zzcc zzc;
    public static final /* enum */ zzcc zzd;
    public static final /* enum */ zzcc zze;
    private static final zzhv zzf;
    private static final /* synthetic */ zzcc[] zzh;
    private final int zzg;

    static {
        zzcc zzcc2;
        zzcc zzcc3;
        zzcc zzcc4;
        zzcc zzcc5;
        Object object = new zzcc("UNKNOWN_COMPARISON_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcc5 = new zzcc("LESS_THAN", n10, n10);
        int n11 = 2;
        zzc = zzcc4 = new zzcc("GREATER_THAN", n11, n11);
        int n12 = 3;
        zzd = zzcc3 = new zzcc("EQUAL", n12, n12);
        int n13 = 4;
        zze = zzcc2 = new zzcc("BETWEEN", n13, n13);
        zzcc[] zzccArray = new zzcc[5];
        zzccArray[0] = object;
        zzccArray[n10] = zzcc5;
        zzccArray[n11] = zzcc4;
        zzccArray[n12] = zzcc3;
        zzccArray[n13] = zzcc2;
        zzh = zzccArray;
        zzf = object = new zzca();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzcc[] values() {
        return (zzcc[])zzh.clone();
    }

    public static zzcc zza(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return null;
                        }
                        return zze;
                    }
                    return zzd;
                }
                return zzc;
            }
            return zzb;
        }
        return zza;
    }

    public static zzhw zzb() {
        return zzcb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcc.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzg;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

