/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzy$zza
extends zzej
implements zzft {
    private static final zzr$zzy$zza zzf;
    private static volatile zzgb zzg;
    private int zzc;
    private int zzd;
    private zzeq zze;

    static {
        zzr$zzy$zza zzr$zzy$zza;
        zzf = zzr$zzy$zza = new zzr$zzy$zza();
        zzej.zza(zzr$zzy$zza.class, zzr$zzy$zza);
    }

    private zzr$zzy$zza() {
        zzeq zzeq2;
        this.zze = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzy$zza zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzy$zza>)zzt.zza;
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
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzr$zzy$zza.class;
                synchronized (clazz) {
                    object3 = zzg;
                    if (object3 != null) return object3;
                    object2 = zzf;
                    zzg = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzf;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzr$zzy$zza$zza.zzb();
                objectArray[3] = "zze";
                return zzej.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u0016", objectArray);
            }
            case 2: {
                return new zzr$zzy$zza$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzy$zza();
    }
}

