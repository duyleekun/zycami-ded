/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcr
extends zzhs
implements zziy {
    private static final zzcr zzg;
    private int zza;
    private String zze;
    private String zzf;

    static {
        zzcr zzcr2;
        zzg = zzcr2 = new zzcr();
        zzhs.zzby(zzcr.class, zzcr2);
    }

    private zzcr() {
        String string2;
        this.zze = string2 = "";
        this.zzf = string2;
    }

    public static /* synthetic */ zzcr zzc() {
        return zzg;
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzf;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        int n11 = 1;
        if ((n10 += -1) != 0) {
            int n12 = 3;
            int n13 = 2;
            if (n10 != n13) {
                if (n10 != n12) {
                    n11 = 4;
                    n12 = 0;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return null;
                        }
                        return zzg;
                    }
                    zzcq zzcq2 = new zzcq(null);
                    return zzcq2;
                }
                zzcr zzcr2 = new zzcr();
                return zzcr2;
            }
            Object[] objectArray = new Object[n12];
            objectArray[0] = "zza";
            objectArray[n11] = "zze";
            objectArray[n13] = "zzf";
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001", objectArray);
        }
        return (byte)n11;
    }
}

