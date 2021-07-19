/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzd$zza;

public final class zzjf$zzd
extends zzfq
implements zzhd {
    private static final zzjf$zzd zzk;
    private static volatile zzhl zzl;
    private int zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private String zzi;
    private int zzj;

    static {
        zzjf$zzd zzjf$zzd;
        zzk = zzjf$zzd = new zzjf$zzd();
        zzfq.zza(zzjf$zzd.class, zzjf$zzd);
    }

    private zzjf$zzd() {
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzf = string2;
        this.zzi = string2;
    }

    public static /* synthetic */ zzjf$zzd zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzd>)zzje.zza;
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
                clazz = zzjf$zzd.class;
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
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                return zzfq.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1004\u0003\u0005\u1004\u0004\u0006\u1008\u0005\u0007\u1004\u0006", objectArray);
            }
            case 2: {
                return new zzjf$zzd$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzd();
    }
}

