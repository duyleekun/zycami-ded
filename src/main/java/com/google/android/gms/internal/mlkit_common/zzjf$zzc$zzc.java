/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc$zza;

public final class zzjf$zzc$zzc
extends zzfq
implements zzhd {
    private static final zzjf$zzc$zzc zzf;
    private static volatile zzhl zzg;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzjf$zzc$zzc zzjf$zzc$zzc;
        zzf = zzjf$zzc$zzc = new zzjf$zzc$zzc();
        zzfq.zza(zzjf$zzc$zzc.class, zzjf$zzc$zzc);
    }

    private zzjf$zzc$zzc() {
    }

    public static /* synthetic */ zzjf$zzc$zzc zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzc$zzc>)zzje.zza;
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
                clazz = zzjf$zzc$zzc.class;
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
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                return zzfq.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzjf$zzc$zzc$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzc$zzc();
    }
}

