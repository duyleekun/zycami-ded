/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zze;
import com.google.android.gms.internal.mlkit_common.zzjf$zzh;
import com.google.android.gms.internal.mlkit_common.zzjf$zzj$zza;
import com.google.android.gms.internal.mlkit_common.zzjf$zzj$zzb;

public final class zzjf$zzj
extends zzfq
implements zzhd {
    private static final zzjf$zzj zzg;
    private static volatile zzhl zzh;
    private int zzc;
    private int zzd;
    private zzjf$zzh zze;
    private zzjf$zze zzf;

    static {
        zzjf$zzj zzjf$zzj;
        zzg = zzjf$zzj = new zzjf$zzj();
        zzfq.zza(zzjf$zzj.class, zzjf$zzj);
    }

    private zzjf$zzj() {
    }

    public static /* synthetic */ zzjf$zzj zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzj>)zzje.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzjf$zzj.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzjf$zzj$zzb.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzfq.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzjf$zzj$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzj();
    }
}

