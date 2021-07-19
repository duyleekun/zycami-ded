/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzct;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;

public final class zzcv
extends Enum
implements zzhu {
    public static final /* enum */ zzcv zza;
    public static final /* enum */ zzcv zzb;
    public static final /* enum */ zzcv zzc;
    public static final /* enum */ zzcv zzd;
    public static final /* enum */ zzcv zze;
    public static final /* enum */ zzcv zzf;
    private static final zzhv zzg;
    private static final /* synthetic */ zzcv[] zzi;
    private final int zzh;

    static {
        zzcv zzcv2;
        zzcv zzcv3;
        zzcv zzcv4;
        zzcv zzcv5;
        zzcv zzcv6;
        Object object = new zzcv("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcv6 = new zzcv("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED", n10, n10);
        int n11 = 2;
        zzc = zzcv5 = new zzcv("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED", n11, n11);
        int n12 = 3;
        zzd = zzcv4 = new zzcv("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED", n12, n12);
        int n13 = 4;
        zze = zzcv3 = new zzcv("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED", n13, n13);
        int n14 = 5;
        zzf = zzcv2 = new zzcv("AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED", n14, n14);
        zzcv[] zzcvArray = new zzcv[6];
        zzcvArray[0] = object;
        zzcvArray[n10] = zzcv6;
        zzcvArray[n11] = zzcv5;
        zzcvArray[n12] = zzcv4;
        zzcvArray[n13] = zzcv3;
        zzcvArray[n14] = zzcv2;
        zzi = zzcvArray;
        zzg = object = new zzct();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcv() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzcv[] values() {
        return (zzcv[])zzi.clone();
    }

    public static zzcv zza(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            n11 = 5;
                            if (n10 != n11) {
                                return null;
                            }
                            return zzf;
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
        return zzcu.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcv.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzh;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

