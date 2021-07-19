/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdr;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzds
extends zzhs
implements zziy {
    private static final zzds zzg;
    private int zza;
    private int zze;
    private zzhy zzf;

    static {
        zzds zzds2;
        zzg = zzds2 = new zzds();
        zzhs.zzby(zzds.class, zzds2);
    }

    private zzds() {
        zzhy zzhy2;
        this.zzf = zzhy2 = zzhs.zzbC();
    }

    public static zzdr zzf() {
        return (zzdr)zzg.zzbt();
    }

    public static /* synthetic */ zzds zzg() {
        return zzg;
    }

    public static /* synthetic */ void zzh(zzds zzds2, int n10) {
        int n11;
        zzds2.zza = n11 = zzds2.zza | 1;
        zzds2.zze = n10;
    }

    public static /* synthetic */ void zzi(zzds object, Iterable iterable) {
        zzhy zzhy2 = ((zzds)object).zzf;
        boolean bl2 = zzhy2.zza();
        if (!bl2) {
            ((zzds)object).zzf = zzhy2 = zzhs.zzbD(zzhy2);
        }
        object = ((zzds)object).zzf;
        zzgb.zzbs(iterable, (List)object);
    }

    public final boolean zza() {
        int n10 = this.zza;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final long zze(int n10) {
        return this.zzf.zzc(n10);
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
                    zzdr zzdr2 = new zzdr(null);
                    return zzdr2;
                }
                zzds zzds2 = new zzds();
                return zzds2;
            }
            Object[] objectArray = new Object[n12];
            objectArray[0] = "zza";
            objectArray[n11] = "zze";
            objectArray[n13] = "zzf";
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u0014", objectArray);
        }
        return (byte)n11;
    }
}

