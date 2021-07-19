/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzi
extends zzej
implements zzft {
    private static final zzhv$zzi zzd;
    private static volatile zzgb zze;
    private zzes zzc;

    static {
        zzhv$zzi zzhv$zzi;
        zzd = zzhv$zzi = new zzhv$zzi();
        zzej.zza(zzhv$zzi.class, zzhv$zzi);
    }

    private zzhv$zzi() {
        zzes zzes2;
        this.zzc = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzhv$zzi zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzi>)zzhx.zza;
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
                clazz = zzhv$zzi.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = zzhv$zzi$zza.class;
                return zzej.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzhv$zzi$zzb(null);
            }
            case 1: 
        }
        return new zzhv$zzi();
    }
}

