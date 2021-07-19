/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaw;
import com.google.android.gms.internal.mlkit_common.zzav$zzay$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbf;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzay
extends zzfq
implements zzhd {
    private static final zzav$zzay zzi;
    private static volatile zzhl zzj;
    private int zzc;
    private zzav$zzaw zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private zzfy zzh;

    static {
        zzav$zzay zzav$zzay;
        zzi = zzav$zzay = new zzav$zzay();
        zzfq.zza(zzav$zzay.class, zzav$zzay);
    }

    private zzav$zzay() {
        zzfy zzfy2;
        this.zzh = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzav$zzay zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzay>)zzau.zza;
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
                clazz = zzav$zzay.class;
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
                objectArray[3] = object2 = zzbf.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = zzav$zzbf.class;
                return zzfq.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u100c\u0001\u0003\u1003\u0002\u0004\u1003\u0003\u0005\u001b", objectArray);
            }
            case 2: {
                return new zzav$zzay$zza(null);
            }
            case 1: 
        }
        return new zzav$zzay();
    }
}

