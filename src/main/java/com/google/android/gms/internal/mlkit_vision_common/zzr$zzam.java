/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzal;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzam
extends zzej
implements zzft {
    private static final zzr$zzam zzh;
    private static volatile zzgb zzi;
    private int zzc;
    private zzr$zzal zzd;
    private zzr$zzam$zza zze;
    private zzr$zzam$zza zzf;
    private boolean zzg;

    static {
        zzr$zzam zzr$zzam;
        zzh = zzr$zzam = new zzr$zzam();
        zzej.zza(zzr$zzam.class, zzr$zzam);
    }

    private zzr$zzam() {
    }

    public static /* synthetic */ zzr$zzam zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzam>)zzt.zza;
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
                clazz = zzr$zzam.class;
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
                return zzej.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1007\u0003", objectArray);
            }
            case 2: {
                return new zzr$zzam$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzam();
    }
}

