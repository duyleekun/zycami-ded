/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzba$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzba$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzba$zzc;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzba
extends zzfq
implements zzhd {
    private static final zzav$zzba zzg;
    private static volatile zzhl zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzav$zzba zzav$zzba;
        zzg = zzav$zzba = new zzav$zzba();
        zzfq.zza(zzav$zzba.class, zzav$zzba);
    }

    private zzav$zzba() {
    }

    public static /* synthetic */ zzav$zzba zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzba>)zzau.zza;
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
                clazz = zzav$zzba.class;
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
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzav$zzba$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzav$zzba$zzc.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = object2 = zzav$zzba$zzc.zzb();
                return zzfq.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u100c\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzba$zzb(null);
            }
            case 1: 
        }
        return new zzav$zzba();
    }
}

