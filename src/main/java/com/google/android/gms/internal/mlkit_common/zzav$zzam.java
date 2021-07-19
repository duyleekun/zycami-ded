/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzal;
import com.google.android.gms.internal.mlkit_common.zzav$zzam$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzam$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzam
extends zzfq
implements zzhd {
    private static final zzav$zzam zzh;
    private static volatile zzhl zzi;
    private int zzc;
    private zzav$zzal zzd;
    private zzav$zzam$zzb zze;
    private zzav$zzam$zzb zzf;
    private boolean zzg;

    static {
        zzav$zzam zzav$zzam;
        zzh = zzav$zzam = new zzav$zzam();
        zzfq.zza(zzav$zzam.class, zzav$zzam);
    }

    private zzav$zzam() {
    }

    public static zzav$zzam$zza zza() {
        return (zzav$zzam$zza)zzh.zzh();
    }

    private final void zza(zzav$zzal zzav$zzal) {
        int n10;
        zzav$zzal.getClass();
        this.zzd = zzav$zzal;
        this.zzc = n10 = this.zzc | 1;
    }

    public static /* synthetic */ void zza(zzav$zzam zzav$zzam, zzav$zzal zzav$zzal) {
        zzav$zzam.zza(zzav$zzal);
    }

    public static /* synthetic */ zzav$zzam zzb() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzam>)zzau.zza;
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
                Object object3 = zzi;
                if (object3 != null) return object3;
                clazz = zzav$zzam.class;
                synchronized (clazz) {
                    object3 = zzi;
                    if (object3 != null) return object3;
                    object2 = zzh;
                    zzi = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzh;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                return zzfq.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1007\u0003", objectArray);
            }
            case 2: {
                return new zzav$zzam$zza(null);
            }
            case 1: 
        }
        return new zzav$zzam();
    }
}

