/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzn$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzn$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzn
extends zzej
implements zzft {
    private static final zzr$zzn zzf;
    private static volatile zzgb zzg;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzr$zzn zzr$zzn;
        zzf = zzr$zzn = new zzr$zzn();
        zzej.zza(zzr$zzn.class, zzr$zzn);
    }

    private zzr$zzn() {
    }

    public static /* synthetic */ zzr$zzn zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzn>)zzt.zza;
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
                clazz = zzr$zzn.class;
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
                objectArray[3] = object2 = zzr$zzn$zzb.zzb();
                return zzej.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u100c\u0001", objectArray);
            }
            case 2: {
                return new zzr$zzn$zza(null);
            }
            case 1: 
        }
        return new zzr$zzn();
    }
}

