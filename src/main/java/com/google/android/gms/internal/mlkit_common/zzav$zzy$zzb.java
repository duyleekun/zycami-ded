/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzy$zzb
extends zzfq
implements zzhd {
    private static final zzav$zzy$zzb zzf;
    private static volatile zzhl zzg;
    private int zzc;
    private int zzd;
    private zzfw zze;

    static {
        zzav$zzy$zzb zzav$zzy$zzb;
        zzf = zzav$zzy$zzb = new zzav$zzy$zzb();
        zzfq.zza(zzav$zzy$zzb.class, zzav$zzy$zzb);
    }

    private zzav$zzy$zzb() {
        zzfw zzfw2;
        this.zze = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzav$zzy$zzb zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzy$zzb>)zzau.zza;
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
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzav$zzy$zzb.class;
                synchronized (clazz) {
                    object3 = zzg;
                    if (object3 != null) return object3;
                    object2 = zzf;
                    zzg = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzf;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzav$zzy$zzb$zzb.zzb();
                objectArray[3] = "zze";
                return zzfq.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u0016", objectArray);
            }
            case 2: {
                return new zzav$zzy$zzb$zza(null);
            }
            case 1: 
        }
        return new zzav$zzy$zzb();
    }
}

