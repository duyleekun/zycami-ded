/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzav$zzy$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzy
extends zzfq
implements zzhd {
    private static final zzav$zzy zzi;
    private static volatile zzhl zzj;
    private int zzc;
    private zzav$zzaf zzd;
    private zzav$zzam zze;
    private zzfy zzf;
    private zzfy zzg;
    private long zzh;

    static {
        zzav$zzy zzav$zzy;
        zzi = zzav$zzy = new zzav$zzy();
        zzfq.zza(zzav$zzy.class, zzav$zzy);
    }

    private zzav$zzy() {
        zzfy zzfy2;
        this.zzf = zzfy2 = zzfq.zzl();
        this.zzg = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzav$zzy zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = zzav$zzy$zzb.class;
        object2 = zzau.zza;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                clazz = zzav$zzy.class;
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
                objectArray[3] = "zzf";
                objectArray[4] = clazz;
                objectArray[5] = "zzg";
                objectArray[6] = clazz;
                objectArray[7] = "zzh";
                return zzfq.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001b\u0004\u001b\u0005\u1003\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzy$zza(null);
            }
            case 1: 
        }
        return new zzav$zzy();
    }
}

