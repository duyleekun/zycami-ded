/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzc$zzb
extends zzej
implements zzft {
    private static final zzhv$zzc$zzb zzf;
    private static volatile zzgb zzg;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzhv$zzc$zzb zzhv$zzc$zzb;
        zzf = zzhv$zzc$zzb = new zzhv$zzc$zzb();
        zzej.zza(zzhv$zzc$zzb.class, zzhv$zzc$zzb);
    }

    private zzhv$zzc$zzb() {
    }

    public static /* synthetic */ zzhv$zzc$zzb zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzc$zzb>)zzhx.zza;
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
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzhv$zzc$zzb.class;
                synchronized (clazz) {
                    object3 = zzg;
                    if (object3 != null) return object3;
                    object2 = zzf;
                    zzg = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzf;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                return zzej.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzhv$zzc$zzb$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzc$zzb();
    }
}

