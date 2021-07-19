/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzg
extends zzej
implements zzft {
    private static final zzhv$zzg zzd;
    private static volatile zzgb zze;
    private zzeq zzc;

    static {
        zzhv$zzg zzhv$zzg;
        zzd = zzhv$zzg = new zzhv$zzg();
        zzej.zza(zzhv$zzg.class, zzhv$zzg);
    }

    private zzhv$zzg() {
        zzeq zzeq2;
        this.zzc = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzhv$zzg zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzg>)zzhx.zza;
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
                clazz = zzhv$zzg.class;
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
                Object[] objectArray = new Object[by2];
                objectArray[0] = "zzc";
                return zzej.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", objectArray);
            }
            case 2: {
                return new zzhv$zzg$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzg();
    }
}

