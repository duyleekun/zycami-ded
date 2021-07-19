/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzc;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd$zza;

public final class zzjf$zzc$zzd
extends zzfq
implements zzhd {
    private static final zzjf$zzc$zzd zzg;
    private static volatile zzhl zzh;
    private int zzc;
    private zzjf$zzc$zzc zzd;
    private zzjf$zzc$zzc zze;
    private boolean zzf;

    static {
        zzjf$zzc$zzd zzjf$zzc$zzd;
        zzg = zzjf$zzc$zzd = new zzjf$zzc$zzd();
        zzfq.zza(zzjf$zzc$zzd.class, zzjf$zzc$zzd);
    }

    private zzjf$zzc$zzd() {
    }

    public static /* synthetic */ zzjf$zzc$zzd zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzc$zzd>)zzje.zza;
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
                clazz = zzjf$zzc$zzd.class;
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
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzfq.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1007\u0002", objectArray);
            }
            case 2: {
                return new zzjf$zzc$zzd$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzc$zzd();
    }
}

