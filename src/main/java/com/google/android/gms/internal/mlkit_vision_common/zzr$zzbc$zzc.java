/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzbc$zzc
extends zzej
implements zzft {
    private static final zzr$zzbc$zzc zze;
    private static volatile zzgb zzf;
    private int zzc;
    private float zzd;

    static {
        zzr$zzbc$zzc zzr$zzbc$zzc;
        zze = zzr$zzbc$zzc = new zzr$zzbc$zzc();
        zzej.zza(zzr$zzbc$zzc.class, zzr$zzbc$zzc);
    }

    private zzr$zzbc$zzc() {
    }

    public static /* synthetic */ zzr$zzbc$zzc zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzbc$zzc>)zzt.zza;
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
                clazz = zzr$zzbc$zzc.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                return zzej.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u1001\u0000", objectArray);
            }
            case 2: {
                return new zzr$zzbc$zzc$zza(null);
            }
            case 1: 
        }
        return new zzr$zzbc$zzc();
    }
}

