/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf;
import com.google.android.gms.internal.mlkit_common.zzav$zzbc$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzbc$zzc;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzbc
extends zzfq
implements zzhd {
    private static final zzav$zzbc zzi;
    private static volatile zzhl zzj;
    private int zzc;
    private zzav$zzaf zzd;
    private zzfy zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzav$zzbc zzav$zzbc;
        zzi = zzav$zzbc = new zzav$zzbc();
        zzfq.zza(zzav$zzbc.class, zzav$zzbc);
    }

    private zzav$zzbc() {
        zzfy zzfy2;
        this.zze = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzav$zzbc zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzbc>)zzau.zza;
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
                Object object3 = zzj;
                if (object3 != null) return object3;
                clazz = zzav$zzbc.class;
                synchronized (clazz) {
                    object3 = zzj;
                    if (object3 != null) return object3;
                    object2 = zzi;
                    zzj = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzi;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = zzav$zzbc$zzc.class;
                objectArray[4] = "zzf";
                objectArray[5] = object2 = zzav$zzbc$zza.zzb();
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                return zzfq.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u001b\u0003\u100c\u0001\u0004\u1004\u0002\u0005\u1004\u0003", objectArray);
            }
            case 2: {
                return new zzav$zzbc$zzb(null);
            }
            case 1: 
        }
        return new zzav$zzbc();
    }
}

