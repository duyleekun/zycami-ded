/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzk;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzl$zza
extends zzej
implements zzft {
    private static final zzhv$zzl$zza zzg;
    private static volatile zzgb zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private zzes zzf;

    static {
        zzhv$zzl$zza zzhv$zzl$zza;
        zzg = zzhv$zzl$zza = new zzhv$zzl$zza();
        zzej.zza(zzhv$zzl$zza.class, zzhv$zzl$zza);
    }

    private zzhv$zzl$zza() {
        zzes zzes2;
        this.zzf = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzhv$zzl$zza zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzl$zza>)zzhx.zza;
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
                clazz = zzhv$zzl$zza.class;
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
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = zzhv$zzk.class;
                return zzej.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u1004\u0001\u0003\u001b", objectArray);
            }
            case 2: {
                return new zzhv$zzl$zza$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzl$zza();
    }
}

