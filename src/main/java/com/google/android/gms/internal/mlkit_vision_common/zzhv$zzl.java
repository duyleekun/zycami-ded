/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zze;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzl
extends zzej$zze
implements zzft {
    private static final zzhv$zzl zzf;
    private static volatile zzgb zzg;
    private zzes zzd;
    private byte zze = (byte)2;

    static {
        zzhv$zzl zzhv$zzl;
        zzf = zzhv$zzl = new zzhv$zzl();
        zzej.zza(zzhv$zzl.class, zzhv$zzl);
    }

    private zzhv$zzl() {
        zzes zzes2;
        this.zzd = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzhv$zzl zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzhx.zza;
        int n10 = 1;
        object -= n10;
        object = object2[object];
        object2 = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                }
                object = (byte)n10;
                this.zze = (byte)object;
                return null;
            }
            case 6: {
                return this.zze;
            }
            case 5: {
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzhv$zzl.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzd";
                objectArray[n10] = zzhv$zzl$zza.class;
                return zzej.zza(zzf, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzhv$zzl$zzb(null);
            }
            case 1: 
        }
        return new zzhv$zzl();
    }
}

