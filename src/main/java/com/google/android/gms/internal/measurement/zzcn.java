/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcn
extends zzhs
implements zziy {
    private static final zzcn zzi;
    private int zza;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzcn zzcn2;
        zzi = zzcn2 = new zzcn();
        zzhs.zzby(zzcn.class, zzcn2);
    }

    private zzcn() {
    }

    public static /* synthetic */ zzcn zzf() {
        return zzi;
    }

    public static /* synthetic */ void zzg(zzcn zzcn2, String string2) {
        int n10;
        string2.getClass();
        zzcn2.zza = n10 = zzcn2.zza | 1;
        zzcn2.zze = string2;
    }

    public final String zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    public final boolean zzd() {
        int n10 = this.zza & 8;
        return n10 != 0;
    }

    public final int zze() {
        return this.zzh;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        byte by2 = 1;
        if ((n10 += -1) != 0) {
            int n11 = 5;
            int n12 = 4;
            int n13 = 3;
            int n14 = 2;
            if (n10 != n14) {
                if (n10 != n13) {
                    by2 = 0;
                    if (n10 != n12) {
                        if (n10 != n11) {
                            return null;
                        }
                        return zzi;
                    }
                    zzcm zzcm2 = new zzcm(null);
                    return zzcm2;
                }
                zzcn zzcn2 = new zzcn();
                return zzcn2;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = "zza";
            objectArray[by2] = "zze";
            objectArray[n14] = "zzf";
            objectArray[n13] = "zzg";
            objectArray[n12] = "zzh";
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u1004\u0003", objectArray);
        }
        return by2;
    }
}

