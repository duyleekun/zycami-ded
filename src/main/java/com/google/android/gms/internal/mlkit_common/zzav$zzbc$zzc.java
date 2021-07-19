/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc$zza;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzbc$zzc
extends zzfq
implements zzhd {
    private static final zzav$zzbc$zzc zze;
    private static volatile zzhl zzf;
    private int zzc;
    private float zzd;

    static {
        zzav$zzbc$zzc zzav$zzbc$zzc;
        zze = zzav$zzbc$zzc = new zzav$zzbc$zzc();
        zzfq.zza(zzav$zzbc$zzc.class, zzav$zzbc$zzc);
    }

    private zzav$zzbc$zzc() {
    }

    public static /* synthetic */ zzav$zzbc$zzc zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzbc$zzc>)zzau.zza;
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
                clazz = zzav$zzbc$zzc.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                return zzfq.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u1001\u0000", objectArray);
            }
            case 2: {
                return new zzav$zzbc$zzc$zza(null);
            }
            case 1: 
        }
        return new zzav$zzbc$zzc();
    }
}

