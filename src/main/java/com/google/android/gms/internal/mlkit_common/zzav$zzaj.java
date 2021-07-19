/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaj$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzaj$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzaj
extends zzfq
implements zzhd {
    private static final zzav$zzaj zze;
    private static volatile zzhl zzf;
    private int zzc;
    private int zzd;

    static {
        zzav$zzaj zzav$zzaj;
        zze = zzav$zzaj = new zzav$zzaj();
        zzfq.zza(zzav$zzaj.class, zzav$zzaj);
    }

    private zzav$zzaj() {
    }

    public static zzav$zzaj$zzb zza() {
        return (zzav$zzaj$zzb)zze.zzh();
    }

    private final void zza(zzav$zzaj$zza zzav$zzaj$zza) {
        int n10;
        this.zzd = n10 = zzav$zzaj$zza.zza();
        this.zzc = n10 = this.zzc | 1;
    }

    public static /* synthetic */ void zza(zzav$zzaj zzav$zzaj, zzav$zzaj$zza zzav$zzaj$zza) {
        zzav$zzaj.zza(zzav$zzaj$zza);
    }

    public static /* synthetic */ zzav$zzaj zzb() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzaj>)zzau.zza;
        byte by2 = 1;
        object -= by2;
        object = clazz[object];
        clazz = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                return null;
            }
            case 6: {
                return by2;
            }
            case 5: {
                Object object3 = zzf;
                if (object3 != null) return object3;
                clazz = zzav$zzaj.class;
                synchronized (clazz) {
                    object3 = zzf;
                    if (object3 != null) return object3;
                    object2 = zze;
                    zzf = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zze;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzav$zzaj$zza.zzb();
                return zzfq.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u100c\u0000", objectArray);
            }
            case 2: {
                return new zzav$zzaj$zzb(null);
            }
            case 1: 
        }
        return new zzav$zzaj();
    }
}

