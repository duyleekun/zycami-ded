/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzae$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzag$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzag$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzag
extends zzfq
implements zzhd {
    private static final zzav$zzag zzk;
    private static volatile zzhl zzl;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzav$zzag zzav$zzag;
        zzk = zzav$zzag = new zzav$zzag();
        zzfq.zza(zzav$zzag.class, zzav$zzag);
    }

    private zzav$zzag() {
    }

    public static /* synthetic */ zzav$zzag zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzag>)zzau.zza;
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
                Object object3 = zzl;
                if (object3 != null) return object3;
                clazz = zzav$zzag.class;
                synchronized (clazz) {
                    object3 = zzl;
                    if (object3 != null) return object3;
                    object2 = zzk;
                    zzl = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzk;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzav$zzag$zza.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = object2 = zzav$zzae$zzb.zzb();
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                return zzfq.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u1003\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u100b\u0003\u0005\u100b\u0004\u0006\u100b\u0005\u0007\u100b\u0006", objectArray);
            }
            case 2: {
                return new zzav$zzag$zzb(null);
            }
            case 1: 
        }
        return new zzav$zzag();
    }
}

