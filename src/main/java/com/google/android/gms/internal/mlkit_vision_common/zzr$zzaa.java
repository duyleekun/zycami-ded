/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzaa
extends zzej
implements zzft {
    private static final zzr$zzaa zzg;
    private static volatile zzgb zzh;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";

    static {
        zzr$zzaa zzr$zzaa;
        zzg = zzr$zzaa = new zzr$zzaa();
        zzej.zza(zzr$zzaa.class, zzr$zzaa);
    }

    private zzr$zzaa() {
    }

    public static /* synthetic */ zzr$zzaa zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzaa>)zzt.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzr$zzaa.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzr$zzal$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzej.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1008\u0002", objectArray);
            }
            case 2: {
                return new zzr$zzaa$zza(null);
            }
            case 1: 
        }
        return new zzr$zzaa();
    }
}

