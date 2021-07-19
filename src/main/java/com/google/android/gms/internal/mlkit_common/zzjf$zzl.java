/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfq$zzc;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzjf$zzl$zza;
import com.google.android.gms.internal.mlkit_common.zzjf$zzl$zzb;

public final class zzjf$zzl
extends zzfq$zzc
implements zzhd {
    private static final zzjf$zzl zzf;
    private static volatile zzhl zzg;
    private zzfy zzd;
    private byte zze = (byte)2;

    static {
        zzjf$zzl zzjf$zzl;
        zzf = zzjf$zzl = new zzjf$zzl();
        zzfq.zza(zzjf$zzl.class, zzjf$zzl);
    }

    private zzjf$zzl() {
        zzfy zzfy2;
        this.zzd = zzfy2 = zzfq.zzl();
    }

    public static /* synthetic */ zzjf$zzl zza() {
        return zzf;
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
                this.zze = (byte)object;
                return null;
            }
            case 6: {
                return this.zze;
            }
            case 5: {
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzjf$zzl.class;
                synchronized (clazz) {
                    object3 = zzg;
                    if (object3 != null) return object3;
                    object2 = zzf;
                    zzg = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzf;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzd";
                objectArray[n10] = zzjf$zzl$zzb.class;
                return zzfq.zza(zzf, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzjf$zzl$zza(null);
            }
            case 1: 
        }
        return new zzjf$zzl();
    }
}

