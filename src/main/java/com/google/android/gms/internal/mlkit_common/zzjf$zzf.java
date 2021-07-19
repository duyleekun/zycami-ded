/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzb;
import com.google.android.gms.internal.mlkit_common.zzjf$zzc;
import com.google.android.gms.internal.mlkit_common.zzjf$zzd;
import com.google.android.gms.internal.mlkit_common.zzjf$zzf$zza;
import com.google.android.gms.internal.mlkit_common.zzjf$zzi;
import com.google.android.gms.internal.mlkit_common.zzjf$zzl;
import com.google.android.gms.internal.mlkit_common.zzjl;

public final class zzjf$zzf
extends zzfq
implements zzhd {
    private static final zzjf$zzf zzo;
    private static volatile zzhl zzp;
    private int zzc;
    private zzjf$zzb zzd;
    private zzjf.zzi zze;
    private zzjf$zzd zzf;
    private int zzg;
    private zzjf$zzc zzh;
    private zzjf.zzl zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private byte zzn = (byte)2;

    static {
        zzjf$zzf zzjf$zzf;
        zzo = zzjf$zzf = new zzjf$zzf();
        zzfq.zza(zzjf$zzf.class, zzjf$zzf);
    }

    private zzjf$zzf() {
    }

    public static /* synthetic */ zzjf$zzf zza() {
        return zzo;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzje.zza;
        int n10 = 1;
        object -= n10;
        object = object2[object];
        object2 = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                }
                object = (byte)n10;
                this.zzn = (byte)object;
                return null;
            }
            case 6: {
                return this.zzn;
            }
            case 5: {
                Object object3 = zzp;
                if (object3 != null) return object3;
                clazz = zzjf$zzf.class;
                synchronized (clazz) {
                    object3 = zzp;
                    if (object3 != null) return object3;
                    object2 = zzo;
                    zzp = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzo;
            }
            case 3: {
                Object[] objectArray = new Object[12];
                objectArray[0] = "zzc";
                objectArray[n10] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzg";
                objectArray[4] = object2 = zzjl.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                objectArray[8] = "zzk";
                objectArray[9] = "zzl";
                objectArray[10] = "zzm";
                objectArray[11] = "zzf";
                return zzfq.zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u100c\u0003\u0004\u1009\u0004\u0005\u1409\u0005\u0006\u1002\u0006\u0007\u1002\u0007\b\u1007\b\t\u1004\t\n\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzjf$zzf$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzf();
    }
}

