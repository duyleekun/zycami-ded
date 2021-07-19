/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcc$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzcd;
import com.google.android.gms.internal.mlkit_vision_common.zzce;
import com.google.android.gms.internal.mlkit_vision_common.zzcw;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;

public final class zzcc$zza
extends zzej
implements zzft {
    private static final zzep zzd;
    private static final zzcc$zza zze;
    private static volatile zzgb zzf;
    private zzeq zzc;

    static {
        Object object;
        zzd = object = new zzce();
        zze = object = new zzcc$zza();
        zzej.zza(zzcc$zza.class, (zzej)object);
    }

    private zzcc$zza() {
        zzeq zzeq2;
        this.zzc = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzcc$zza zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object object2, Object object3) {
        object2 = zzcd.zza;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                Object object4 = zzf;
                if (object4 != null) return object4;
                object2 = zzcc$zza.class;
                synchronized (object2) {
                    object4 = zzf;
                    if (object4 != null) return object4;
                    object3 = zze;
                    zzf = object4 = new zzej$zzc((zzej)object3);
                    return object4;
                }
            }
            case 4: {
                return zze;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = object2 = zzcw.zzb();
                return zzej.zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", objectArray);
            }
            case 2: {
                return new zzcc$zza$zza(null);
            }
            case 1: 
        }
        return new zzcc$zza();
    }
}

