/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzf$zza
extends zzej
implements zzft {
    private static final zzr$zzf$zza zzi;
    private static volatile zzgb zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private zzr$zzae zzg;
    private zzr$zzaw zzh;

    static {
        zzr$zzf$zza zzr$zzf$zza;
        zzi = zzr$zzf$zza = new zzr$zzf$zza();
        zzej.zza(zzr$zzf$zza.class, zzr$zzf$zza);
    }

    private zzr$zzf$zza() {
    }

    public static /* synthetic */ zzr$zzf$zza zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzf$zza>)zzt.zza;
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
                Object object3 = zzj;
                if (object3 != null) return object3;
                clazz = zzr$zzf$zza.class;
                synchronized (clazz) {
                    object3 = zzj;
                    if (object3 != null) return object3;
                    object2 = zzi;
                    zzj = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzi;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzac.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                return zzej.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u1009\u0003\u0005\u1009\u0004", objectArray);
            }
            case 2: {
                return new zzr$zzf$zza$zza(null);
            }
            case 1: 
        }
        return new zzr$zzf$zza();
    }
}

