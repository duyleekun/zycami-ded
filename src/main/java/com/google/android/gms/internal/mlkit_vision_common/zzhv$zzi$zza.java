/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzi$zza
extends zzej
implements zzft {
    private static final zzhv$zzi$zza zzh;
    private static volatile zzgb zzi;
    private int zzc;
    private String zzd;
    private int zze;
    private String zzf;
    private long zzg;

    static {
        zzhv$zzi$zza zzhv$zzi$zza;
        zzh = zzhv$zzi$zza = new zzhv$zzi$zza();
        zzej.zza(zzhv$zzi$zza.class, zzhv$zzi$zza);
    }

    private zzhv$zzi$zza() {
        String string2;
        this.zzd = string2 = "";
        this.zzf = string2;
    }

    public static /* synthetic */ zzhv$zzi$zza zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzi$zza>)zzhx.zza;
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
                clazz = zzhv$zzi$zza.class;
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
                return zzej.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1004\u0001\u0003\u1008\u0002\u0004\u1002\u0003", objectArray);
            }
            case 2: {
                return new zzhv$zzi$zza$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzi$zza();
    }
}

