/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzed;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;

public final class zzef
extends Enum
implements zzhu {
    public static final /* enum */ zzef zza;
    public static final /* enum */ zzef zzb;
    public static final /* enum */ zzef zzc;
    public static final /* enum */ zzef zzd;
    public static final /* enum */ zzef zze;
    private static final zzhv zzf;
    private static final /* synthetic */ zzef[] zzh;
    private final int zzg;

    static {
        zzef zzef2;
        zzef zzef3;
        zzef zzef4;
        zzef zzef5;
        Object object = new zzef("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzef5 = new zzef("STRING", n10, n10);
        int n11 = 2;
        zzc = zzef4 = new zzef("NUMBER", n11, n11);
        int n12 = 3;
        zzd = zzef3 = new zzef("BOOLEAN", n12, n12);
        int n13 = 4;
        zze = zzef2 = new zzef("STATEMENT", n13, n13);
        zzef[] zzefArray = new zzef[5];
        zzefArray[0] = object;
        zzefArray[n10] = zzef5;
        zzefArray[n11] = zzef4;
        zzefArray[n12] = zzef3;
        zzefArray[n13] = zzef2;
        zzh = zzefArray;
        zzf = object = new zzed();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzef() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzef[] values() {
        return (zzef[])zzh.clone();
    }

    public static zzef zza(int n10) {
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
        return zzee.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzef.class.getName();
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

