/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zze;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzac
extends zzej
implements zzft {
    private static final zzr$zzac zzj;
    private static volatile zzgb zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private float zzi;

    static {
        zzr$zzac zzr$zzac;
        zzj = zzr$zzac = new zzr$zzac();
        zzej.zza(zzr$zzac.class, zzr$zzac);
    }

    private zzr$zzac() {
    }

    public static /* synthetic */ zzr$zzac zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzac>)zzt.zza;
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
                Object object3 = zzk;
                if (object3 != null) return object3;
                clazz = zzr$zzac.class;
                synchronized (clazz) {
                    object3 = zzk;
                    if (object3 != null) return object3;
                    object2 = zzj;
                    zzk = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzj;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzr$zzac$zzd.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzr$zzac$zza.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = object2 = zzr$zzac$zze.zzb();
                objectArray[7] = "zzg";
                objectArray[8] = object2 = zzr$zzac$zzc.zzb();
                objectArray[9] = "zzh";
                objectArray[10] = "zzi";
                return zzej.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u100c\u0003\u0005\u1007\u0004\u0006\u1001\u0005", objectArray);
            }
            case 2: {
                return new zzr$zzac$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzac();
    }
}

