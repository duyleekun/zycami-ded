/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzd$zza
extends zzej
implements zzft {
    private static final zzr$zzd$zza zzj;
    private static volatile zzgb zzk;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzr$zzae zzf;
    private zzr$zzac zzg;
    private int zzh;
    private int zzi;

    static {
        zzr$zzd$zza zzr$zzd$zza;
        zzj = zzr$zzd$zza = new zzr$zzd$zza();
        zzej.zza(zzr$zzd$zza.class, zzr$zzd$zza);
    }

    private zzr$zzd$zza() {
    }

    public static /* synthetic */ zzr$zzd$zza zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzd$zza>)zzt.zza;
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
                Object object3 = zzk;
                if (object3 != null) return object3;
                clazz = zzr$zzd$zza.class;
                synchronized (clazz) {
                    object3 = zzk;
                    if (object3 != null) return object3;
                    object2 = zzj;
                    zzk = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzj;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzac.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                return zzej.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1009\u0002\u0004\u1009\u0003\u0005\u100b\u0004\u0006\u100b\u0005", objectArray);
            }
            case 2: {
                return new zzr$zzd$zza$zza(null);
            }
            case 1: 
        }
        return new zzr$zzd$zza();
    }
}

