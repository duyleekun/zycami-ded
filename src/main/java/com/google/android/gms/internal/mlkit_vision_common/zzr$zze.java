/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzab;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zze
extends zzej
implements zzft {
    private static final zzr$zze zzg;
    private static volatile zzgb zzh;
    private int zzc;
    private zzr$zze$zza zzd;
    private int zze;
    private zzr$zzab zzf;

    static {
        zzr$zze zzr$zze;
        zzg = zzr$zze = new zzr$zze();
        zzej.zza(zzr$zze.class, zzr$zze);
    }

    private zzr$zze() {
    }

    public static /* synthetic */ zzr$zze zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zze>)zzt.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzr$zze.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzej.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u100b\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzr$zze$zzb(null);
            }
            case 1: 
        }
        return new zzr$zze();
    }
}

