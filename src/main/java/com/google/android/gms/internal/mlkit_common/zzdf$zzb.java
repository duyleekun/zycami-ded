/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzde;
import com.google.android.gms.internal.mlkit_common.zzdf$zzb$zza;
import com.google.android.gms.internal.mlkit_common.zzdf$zzb$zzb;
import com.google.android.gms.internal.mlkit_common.zzdf$zzb$zzc;
import com.google.android.gms.internal.mlkit_common.zzdf$zzb$zzd;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzdf$zzb
extends zzfq
implements zzhd {
    private static final zzdf$zzb zzj;
    private static volatile zzhl zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private float zzi;

    static {
        zzdf$zzb zzdf$zzb;
        zzj = zzdf$zzb = new zzdf$zzb();
        zzfq.zza(zzdf$zzb.class, zzdf$zzb);
    }

    private zzdf$zzb() {
    }

    public static /* synthetic */ zzdf$zzb zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzdf$zzb>)zzde.zza;
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
                Object object3 = zzk;
                if (object3 != null) return object3;
                clazz = zzdf$zzb.class;
                synchronized (clazz) {
                    object3 = zzk;
                    if (object3 != null) return object3;
                    object2 = zzj;
                    zzk = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzj;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzdf$zzb$zzd.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzdf$zzb$zzc.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = object2 = zzdf$zzb$zza.zzb();
                objectArray[7] = "zzg";
                objectArray[8] = "zzh";
                objectArray[9] = "zzi";
                return zzfq.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u1007\u0003\u0005\u1007\u0004\u0006\u1001\u0005", objectArray);
            }
            case 2: {
                return new zzdf$zzb$zzb(null);
            }
            case 1: 
        }
        return new zzdf$zzb();
    }
}

