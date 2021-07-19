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
import com.google.android.gms.internal.mlkit_common.zzjf$zzi$zza;
import com.google.android.gms.internal.mlkit_common.zzjf$zzi$zzb;

public final class zzjf$zzi
extends zzfq
implements zzhd {
    private static final zzjf$zzi zzd;
    private static volatile zzhl zze;
    private zzfy zzc;

    static {
        zzjf$zzi zzjf$zzi;
        zzd = zzjf$zzi = new zzjf$zzi();
        zzfq.zza(zzjf$zzi.class, zzjf$zzi);
    }

    private zzjf$zzi() {
        zzfy zzfy2;
        this.zzc = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzjf$zzi zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjf$zzi>)zzje.zza;
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
                clazz = zzjf$zzi.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = zzjf$zzi$zzb.class;
                return zzfq.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzjf$zzi$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzi();
    }
}

