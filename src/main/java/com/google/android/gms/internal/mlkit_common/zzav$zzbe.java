/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf;
import com.google.android.gms.internal.mlkit_common.zzav$zzbe$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbe$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzbi;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzbe
extends zzfq
implements zzhd {
    private static final zzav$zzbe zzl;
    private static volatile zzhl zzm;
    private int zzc;
    private zzav$zzaf zzd;
    private zzav.zzbi zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    static {
        zzav$zzbe zzav$zzbe;
        zzl = zzav$zzbe = new zzav$zzbe();
        zzfq.zza(zzav$zzbe.class, zzav$zzbe);
    }

    private zzav$zzbe() {
    }

    public static /* synthetic */ zzav$zzbe zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzbe>)zzau.zza;
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
                Object object3 = zzm;
                if (object3 != null) return object3;
                clazz = zzav$zzbe.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzl;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                objectArray[8] = object2 = zzav$zzbe$zzb.zzb();
                objectArray[9] = "zzk";
                return zzfq.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1004\u0002\u0004\u1004\u0003\u0005\u1004\u0004\u0006\u1004\u0005\u0007\u100c\u0006\b\u1004\u0007", objectArray);
            }
            case 2: {
                return new zzav$zzbe$zza(null);
            }
            case 1: 
        }
        return new zzav$zzbe();
    }
}

