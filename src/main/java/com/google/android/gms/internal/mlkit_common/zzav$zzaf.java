/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbf;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzaf
extends zzfq
implements zzhd {
    private static final zzav$zzaf zzl;
    private static volatile zzhl zzm;
    private int zzc;
    private long zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private zzfy zzk;

    static {
        zzav$zzaf zzav$zzaf;
        zzl = zzav$zzaf = new zzav$zzaf();
        zzfq.zza(zzav$zzaf.class, zzav$zzaf);
    }

    private zzav$zzaf() {
        zzfy zzfy2;
        this.zzk = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzav$zzaf zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzaf>)zzau.zza;
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
                clazz = zzav$zzaf.class;
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
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzbf.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = "zzj";
                objectArray[9] = "zzk";
                objectArray[10] = zzav.zzbf.class;
                return zzfq.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u1003\u0000\u0002\u100c\u0001\u0003\u1007\u0002\u0004\u1007\u0003\u0005\u1007\u0004\u0006\u1007\u0005\u0007\u100b\u0006\b\u001b", objectArray);
            }
            case 2: {
                return new zzav$zzaf$zza(null);
            }
            case 1: 
        }
        return new zzav$zzaf();
    }
}

