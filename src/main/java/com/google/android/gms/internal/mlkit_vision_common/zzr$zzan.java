/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzan$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzan$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzan
extends zzej
implements zzft {
    private static final zzr$zzan zzh;
    private static volatile zzgb zzi;
    private int zzc;
    private int zzd;
    private float zze;
    private int zzf;
    private int zzg;

    static {
        zzr$zzan zzr$zzan;
        zzh = zzr$zzan = new zzr$zzan();
        zzej.zza(zzr$zzan.class, zzr$zzan);
    }

    private zzr$zzan() {
    }

    public static /* synthetic */ zzr$zzan zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzan>)zzt.zza;
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
                clazz = zzr$zzan.class;
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
                objectArray[2] = object2 = zzr$zzan$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                return zzej.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1001\u0001\u0003\u1004\u0002\u0004\u100b\u0003", objectArray);
            }
            case 2: {
                return new zzr$zzan$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzan();
    }
}

