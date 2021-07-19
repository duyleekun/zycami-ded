/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzk;
import com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb$zza;

public final class zzjf$zzl$zzb
extends zzfq
implements zzhd {
    private static final zzjf$zzl$zzb zzg;
    private static volatile zzhl zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private zzfy zzf;

    static {
        zzjf$zzl$zzb zzjf$zzl$zzb;
        zzg = zzjf$zzl$zzb = new zzjf$zzl$zzb();
        zzfq.zza(zzjf$zzl$zzb.class, zzjf$zzl$zzb);
    }

    private zzjf$zzl$zzb() {
        zzfy zzfy2;
        this.zzf = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzjf$zzl$zzb zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzl$zzb>)zzje.zza;
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
                clazz = zzjf$zzl$zzb.class;
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
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = zzjf$zzk.class;
                return zzfq.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u1004\u0001\u0003\u001b", objectArray);
            }
            case 2: {
                return new zzjf$zzl$zzb$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzl$zzb();
    }
}

