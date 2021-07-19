/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzar$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzat;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzar
extends zzej
implements zzft {
    private static final zzr$zzar zzi;
    private static volatile zzgb zzj;
    private int zzc;
    private zzr$zzaf zzd;
    private zzr$zzat zze;
    private zzr$zzae zzf;
    private int zzg;
    private float zzh;

    static {
        zzr$zzar zzr$zzar;
        zzi = zzr$zzar = new zzr$zzar();
        zzej.zza(zzr$zzar.class, zzr$zzar);
    }

    private zzr$zzar() {
    }

    public static /* synthetic */ zzr$zzar zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzar>)zzt.zza;
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
                clazz = zzr$zzar.class;
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
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                return zzej.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u100b\u0003\u0005\u1001\u0004", objectArray);
            }
            case 2: {
                return new zzr$zzar$zza(null);
            }
            case 1: 
        }
        return new zzr$zzar();
    }
}

