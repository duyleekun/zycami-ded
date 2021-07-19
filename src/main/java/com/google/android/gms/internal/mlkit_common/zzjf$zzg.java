/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzg$zza;

public final class zzjf$zzg
extends zzfq
implements zzhd {
    private static final zzjf$zzg zzd;
    private static volatile zzhl zze;
    private zzfw zzc;

    static {
        zzjf$zzg zzjf$zzg;
        zzd = zzjf$zzg = new zzjf$zzg();
        zzfq.zza(zzjf$zzg.class, zzjf$zzg);
    }

    private zzjf$zzg() {
        zzfw zzfw2;
        this.zzc = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzjf$zzg zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzg>)zzje.zza;
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
                Object object3 = zze;
                if (object3 != null) return object3;
                clazz = zzjf$zzg.class;
                synchronized (clazz) {
                    object3 = zze;
                    if (object3 != null) return object3;
                    object2 = zzd;
                    zze = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzd;
            }
            case 3: {
                Object[] objectArray = new Object[by2];
                objectArray[0] = "zzc";
                return zzfq.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", objectArray);
            }
            case 2: {
                return new zzjf$zzg$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzg();
    }
}

