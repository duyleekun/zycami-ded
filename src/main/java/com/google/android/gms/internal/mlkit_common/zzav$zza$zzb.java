/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zza$zzb$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzae;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zza$zzb
extends zzfq
implements zzhd {
    private static final zzav$zza$zzb zzh;
    private static volatile zzhl zzi;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzav.zzae zzf;
    private zzav$zzam zzg;

    static {
        zzav$zza$zzb zzav$zza$zzb;
        zzh = zzav$zza$zzb = new zzav$zza$zzb();
        zzfq.zza(zzav$zza$zzb.class, zzav$zza$zzb);
    }

    private zzav$zza$zzb() {
    }

    public static /* synthetic */ zzav$zza$zzb zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zza$zzb>)zzau.zza;
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
                clazz = zzav$zza$zzb.class;
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
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbf.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                return zzfq.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1009\u0002\u0004\u1009\u0003", objectArray);
            }
            case 2: {
                return new zzav$zza$zzb$zza(null);
            }
            case 1: 
        }
        return new zzav$zza$zzb();
    }
}

