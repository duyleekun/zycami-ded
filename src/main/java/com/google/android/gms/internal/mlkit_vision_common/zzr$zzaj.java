/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzaj
extends zzej
implements zzft {
    private static final zzr$zzaj zze;
    private static volatile zzgb zzf;
    private int zzc;
    private int zzd;

    static {
        zzr$zzaj zzr$zzaj;
        zze = zzr$zzaj = new zzr$zzaj();
        zzej.zza(zzr$zzaj.class, zzr$zzaj);
    }

    private zzr$zzaj() {
    }

    public static /* synthetic */ zzr$zzaj zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzaj>)zzt.zza;
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
                Object object3 = zzf;
                if (object3 != null) return object3;
                clazz = zzr$zzaj.class;
                synchronized (clazz) {
                    object3 = zzf;
                    if (object3 != null) return object3;
                    object2 = zze;
                    zzf = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zze;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzr$zzaj$zza.zzb();
                return zzej.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u100c\u0000", objectArray);
            }
            case 2: {
                return new zzr$zzaj$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzaj();
    }
}

