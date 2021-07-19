/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzx$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzx
extends zzej
implements zzft {
    private static final zzr$zzx zzf;
    private static volatile zzgb zzg;
    private int zzc;
    private zzr$zzam zzd;
    private int zze;

    static {
        zzr$zzx zzr$zzx;
        zzf = zzr$zzx = new zzr$zzx();
        zzej.zza(zzr$zzx.class, zzr$zzx);
    }

    private zzr$zzx() {
    }

    public static /* synthetic */ zzr$zzx zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzx>)zzt.zza;
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
                clazz = zzr$zzx.class;
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
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzac.zzb();
                return zzej.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u100c\u0001", objectArray);
            }
            case 2: {
                return new zzr$zzx$zza(null);
            }
            case 1: 
        }
        return new zzr$zzx();
    }
}

