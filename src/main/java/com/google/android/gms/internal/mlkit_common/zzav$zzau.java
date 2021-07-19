/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf;
import com.google.android.gms.internal.mlkit_common.zzav$zzai;
import com.google.android.gms.internal.mlkit_common.zzav$zzau$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzau$zzc;
import com.google.android.gms.internal.mlkit_common.zzav$zzau$zzd;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzau
extends zzfq
implements zzhd {
    private static final zzav$zzau zzh;
    private static volatile zzhl zzi;
    private int zzc;
    private zzav$zzaf zzd;
    private zzav$zzai zze;
    private zzav$zzau$zzc zzf;
    private zzav$zzau$zzd zzg;

    static {
        zzav$zzau zzav$zzau;
        zzh = zzav$zzau = new zzav$zzau();
        zzfq.zza(zzav$zzau.class, zzav$zzau);
    }

    private zzav$zzau() {
    }

    public static /* synthetic */ zzav$zzau zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzau>)zzau.zza;
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
                clazz = zzav$zzau.class;
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
                return zzfq.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1009\u0003", objectArray);
            }
            case 2: {
                return new zzav$zzau$zza(null);
            }
            case 1: 
        }
        return new zzav$zzau();
    }
}

