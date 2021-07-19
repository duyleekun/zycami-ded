/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzan;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzax$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzax
extends zzej
implements zzft {
    private static final zzr$zzax zzh;
    private static volatile zzgb zzi;
    private int zzc;
    private zzr$zzaf zzd;
    private zzr$zzae zze;
    private zzr$zzaw zzf;
    private zzes zzg;

    static {
        zzr$zzax zzr$zzax;
        zzh = zzr$zzax = new zzr$zzax();
        zzej.zza(zzr$zzax.class, zzr$zzax);
    }

    private zzr$zzax() {
        zzes zzes2;
        this.zzg = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzr$zzax zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzax>)zzt.zza;
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
                clazz = zzr$zzax.class;
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
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = zzr$zzan.class;
                return zzej.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u001b", objectArray);
            }
            case 2: {
                return new zzr$zzax$zza(null);
            }
            case 1: 
        }
        return new zzr$zzax();
    }
}

