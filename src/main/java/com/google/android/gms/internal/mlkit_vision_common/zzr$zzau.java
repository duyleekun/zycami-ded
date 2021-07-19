/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzai;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzau
extends zzej
implements zzft {
    private static final zzr$zzau zzh;
    private static volatile zzgb zzi;
    private int zzc;
    private zzr$zzaf zzd;
    private zzr$zzai zze;
    private zzr$zzau$zzc zzf;
    private zzr$zzau$zzd zzg;

    static {
        zzr$zzau zzr$zzau;
        zzh = zzr$zzau = new zzr$zzau();
        zzej.zza(zzr$zzau.class, zzr$zzau);
    }

    private zzr$zzau() {
    }

    public static /* synthetic */ zzr$zzau zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzau>)zzt.zza;
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
                clazz = zzr$zzau.class;
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
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                return zzej.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1009\u0003", objectArray);
            }
            case 2: {
                return new zzr$zzau$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzau();
    }
}

