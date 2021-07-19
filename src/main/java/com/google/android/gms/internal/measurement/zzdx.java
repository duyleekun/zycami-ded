/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdw;
import com.google.android.gms.internal.measurement.zzdz;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdx
extends zzhs
implements zziy {
    private static final zzdx zze;
    private zzhz zza;

    static {
        zzdx zzdx2;
        zze = zzdx2 = new zzdx();
        zzhs.zzby(zzdx.class, zzdx2);
    }

    private zzdx() {
        zzhz zzhz2;
        this.zza = zzhz2 = zzhs.zzbE();
    }

    public static /* synthetic */ zzdx zza() {
        return zze;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        int n11 = 1;
        if ((n10 += -1) != 0) {
            int n12 = 2;
            if (n10 != n12) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    n12 = 0;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return null;
                        }
                        return zze;
                    }
                    zzdw zzdw2 = new zzdw(null);
                    return zzdw2;
                }
                zzdx zzdx2 = new zzdx();
                return zzdx2;
            }
            Object[] objectArray = new Object[n12];
            objectArray[0] = "zza";
            objectArray[n11] = zzdz.class;
            return zzhs.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
        }
        return (byte)n11;
    }
}

