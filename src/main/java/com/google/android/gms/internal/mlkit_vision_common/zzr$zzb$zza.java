/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzb$zza
extends zzej
implements zzft {
    private static final zzr$zzb$zza zzi;
    private static volatile zzgb zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzes zzf;
    private zzes zzg;
    private zzr$zzam zzh;

    static {
        zzr$zzb$zza zzr$zzb$zza;
        zzi = zzr$zzb$zza = new zzr$zzb$zza();
        zzej.zza(zzr$zzb$zza.class, zzr$zzb$zza);
    }

    private zzr$zzb$zza() {
        zzes zzes2;
        this.zzf = zzes2 = zzej.zzl();
        this.zzg = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzr$zzb$zza zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = zzr.zzy.zza.class;
        object2 = zzt.zza;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                clazz = zzr$zzb$zza.class;
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
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                zzen zzen2 = zzac.zzb();
                objectArray[2] = zzen2;
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = clazz;
                objectArray[6] = "zzg";
                objectArray[7] = clazz;
                objectArray[8] = "zzh";
                return zzej.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u001b\u0004\u001b\u0005\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzr$zzb$zza$zza(null);
            }
            case 1: 
        }
        return new zzr$zzb$zza();
    }
}

