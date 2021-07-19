/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zza;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zza;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzb;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zzd;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc$zze;
import com.google.android.gms.internal.mlkit_common.zzjf$zzg;

public final class zzjf$zzc
extends zzfq
implements zzhd {
    private static final zzjf$zzc zzm;
    private static volatile zzhl zzn;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf;
    private String zzg;
    private zzjf$zza zzh;
    private zzjf$zzc$zzd zzi;
    private int zzj;
    private zzfy zzk;
    private int zzl;

    static {
        zzjf$zzc zzjf$zzc;
        zzm = zzjf$zzc = new zzjf$zzc();
        zzfq.zza(zzjf$zzc.class, zzjf$zzc);
    }

    private zzjf$zzc() {
        Object object = "";
        this.zzf = object;
        this.zzg = object;
        this.zzk = object = zzfq.zzl();
    }

    public static /* synthetic */ zzjf$zzc zza() {
        return zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzc>)zzje.zza;
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
                Object object3 = zzn;
                if (object3 != null) return object3;
                clazz = zzjf$zzc.class;
                synchronized (clazz) {
                    object3 = zzn;
                    if (object3 != null) return object3;
                    object2 = zzm;
                    zzn = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzm;
            }
            case 3: {
                Object[] objectArray = new Object[13];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzjf$zzc$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzjf$zzc$zze.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                objectArray[10] = "zzk";
                objectArray[11] = zzjf.zzg.class;
                objectArray[12] = "zzl";
                return zzfq.zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1009\u0004\u0006\u1009\u0005\u0007\u1004\u0006\b\u001b\t\u1004\u0007", objectArray);
            }
            case 2: {
                return new zzjf$zzc$zzb(null);
            }
            case 1: 
        }
        return new zzjf$zzc();
    }
}

