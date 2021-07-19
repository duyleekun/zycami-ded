/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zza$zza
extends zzej
implements zzft {
    private static final zzr$zza$zza zzh;
    private static volatile zzgb zzi;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzr.zzae zzf;
    private zzr.zzam zzg;

    static {
        zzr$zza$zza zzr$zza$zza;
        zzh = zzr$zza$zza = new zzr$zza$zza();
        zzej.zza(zzr$zza$zza.class, zzr$zza$zza);
    }

    private zzr$zza$zza() {
    }

    public static /* synthetic */ zzr$zza$zza zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zza$zza>)zzt.zza;
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
                clazz = zzr$zza$zza.class;
                synchronized (clazz) {
                    object3 = zzi;
                    if (object3 != null) return object3;
                    object2 = zzh;
                    zzi = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzh;
            }
            case 3: {
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzac.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                return zzej.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1009\u0002\u0004\u1009\u0003", objectArray);
            }
            case 2: {
                return new zzr$zza$zza$zza(null);
            }
            case 1: 
        }
        return new zzr$zza$zza();
    }
}

