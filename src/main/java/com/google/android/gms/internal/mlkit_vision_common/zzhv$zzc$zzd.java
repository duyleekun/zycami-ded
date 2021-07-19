/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzc$zzd
extends zzej
implements zzft {
    private static final zzhv$zzc$zzd zzg;
    private static volatile zzgb zzh;
    private int zzc;
    private zzhv$zzc$zzb zzd;
    private zzhv$zzc$zzb zze;
    private boolean zzf;

    static {
        zzhv$zzc$zzd zzhv$zzc$zzd;
        zzg = zzhv$zzc$zzd = new zzhv$zzc$zzd();
        zzej.zza(zzhv$zzc$zzd.class, zzhv$zzc$zzd);
    }

    private zzhv$zzc$zzd() {
    }

    public static /* synthetic */ zzhv$zzc$zzd zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzc$zzd>)zzhx.zza;
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
                clazz = zzhv$zzc$zzd.class;
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
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzej.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1007\u0002", objectArray);
            }
            case 2: {
                return new zzhv$zzc$zzd$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzc$zzd();
    }
}

