/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzau$zzd
extends zzej
implements zzft {
    private static final zzr$zzau$zzd zzd;
    private static volatile zzgb zze;
    private zzes zzc;

    static {
        zzr$zzau$zzd zzr$zzau$zzd;
        zzd = zzr$zzau$zzd = new zzr$zzau$zzd();
        zzej.zza(zzr$zzau$zzd.class, zzr$zzau$zzd);
    }

    private zzr$zzau$zzd() {
        zzes zzes2;
        this.zzc = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzr$zzau$zzd zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzau$zzd>)zzt.zza;
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
                Object object3 = zze;
                if (object3 != null) return object3;
                clazz = zzr$zzau$zzd.class;
                synchronized (clazz) {
                    object3 = zze;
                    if (object3 != null) return object3;
                    object2 = zzd;
                    zze = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzd;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = zzr$zzau$zza.class;
                return zzej.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzr$zzau$zzd$zza(null);
            }
            case 1: 
        }
        return new zzr$zzau$zzd();
    }
}

