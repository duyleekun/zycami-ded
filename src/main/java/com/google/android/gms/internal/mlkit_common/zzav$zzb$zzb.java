/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzav$zzb$zzb$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzy$zzb;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzb$zzb
extends zzfq
implements zzhd {
    private static final zzav$zzb$zzb zzi;
    private static volatile zzhl zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzfy zzf;
    private zzfy zzg;
    private zzav$zzam zzh;

    static {
        zzav$zzb$zzb zzav$zzb$zzb;
        zzi = zzav$zzb$zzb = new zzav$zzb$zzb();
        zzfq.zza(zzav$zzb$zzb.class, zzav$zzb$zzb);
    }

    private zzav$zzb$zzb() {
        zzfy zzfy2;
        this.zzf = zzfy2 = zzfq.zzl();
        this.zzg = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzav$zzb$zzb zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = zzav.zzy.zzb.class;
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
                clazz = zzav$zzb$zzb.class;
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
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                zzfx zzfx2 = zzbf.zzb();
                objectArray[2] = zzfx2;
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = clazz;
                objectArray[6] = "zzg";
                objectArray[7] = clazz;
                objectArray[8] = "zzh";
                return zzfq.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u001b\u0004\u001b\u0005\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzb$zzb$zza(null);
            }
            case 1: 
        }
        return new zzav$zzb$zzb();
    }
}

