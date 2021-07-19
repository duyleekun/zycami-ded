/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zze;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzh;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzj$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzj
extends zzej
implements zzft {
    private static final zzhv$zzj zzg;
    private static volatile zzgb zzh;
    private int zzc;
    private int zzd;
    private zzhv$zzh zze;
    private zzhv$zze zzf;

    static {
        zzhv$zzj zzhv$zzj;
        zzg = zzhv$zzj = new zzhv$zzj();
        zzej.zza(zzhv$zzj.class, zzhv$zzj);
    }

    private zzhv$zzj() {
    }

    public static /* synthetic */ zzhv$zzj zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzj>)zzhx.zza;
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
                clazz = zzhv$zzj.class;
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
                objectArray[2] = object2 = zzhv$zzj$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzej.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzhv$zzj$zzb(null);
            }
            case 1: 
        }
        return new zzhv$zzj();
    }
}

