/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzk
extends zzej
implements zzft {
    private static final zzhv$zzk zzf;
    private static volatile zzgb zzg;
    private int zzc;
    private int zzd;
    private float zze;

    static {
        zzhv$zzk zzhv$zzk;
        zzf = zzhv$zzk = new zzhv$zzk();
        zzej.zza(zzhv$zzk.class, zzhv$zzk);
    }

    private zzhv$zzk() {
    }

    public static /* synthetic */ zzhv$zzk zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzk>)zzhx.zza;
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
                clazz = zzhv$zzk.class;
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
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzhv$zzk$zzb.zzb();
                objectArray[3] = "zze";
                return zzej.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1001\u0001", objectArray);
            }
            case 2: {
                return new zzhv$zzk$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzk();
    }
}

