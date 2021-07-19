/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb$zza;

public final class zzjf$zzi$zzb
extends zzfq
implements zzhd {
    private static final zzjf$zzi$zzb zzh;
    private static volatile zzhl zzi;
    private int zzc;
    private String zzd;
    private int zze;
    private String zzf;
    private long zzg;

    static {
        zzjf$zzi$zzb zzjf$zzi$zzb;
        zzh = zzjf$zzi$zzb = new zzjf$zzi$zzb();
        zzfq.zza(zzjf$zzi$zzb.class, zzjf$zzi$zzb);
    }

    private zzjf$zzi$zzb() {
        String string2;
        this.zzd = string2 = "";
        this.zzf = string2;
    }

    public static /* synthetic */ zzjf$zzi$zzb zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzi$zzb>)zzje.zza;
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
                clazz = zzjf$zzi$zzb.class;
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
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                return zzfq.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1004\u0001\u0003\u1008\u0002\u0004\u1002\u0003", objectArray);
            }
            case 2: {
                return new zzjf$zzi$zzb$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzi$zzb();
    }
}

