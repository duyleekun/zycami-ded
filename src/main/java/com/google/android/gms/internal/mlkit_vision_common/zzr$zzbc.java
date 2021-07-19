/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzbc
extends zzej
implements zzft {
    private static final zzr$zzbc zzi;
    private static volatile zzgb zzj;
    private int zzc;
    private zzr$zzaf zzd;
    private zzes zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzr$zzbc zzr$zzbc;
        zzi = zzr$zzbc = new zzr$zzbc();
        zzej.zza(zzr$zzbc.class, zzr$zzbc);
    }

    private zzr$zzbc() {
        zzes zzes2;
        this.zze = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzr$zzbc zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzbc>)zzt.zza;
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
                Object object3 = zzj;
                if (object3 != null) return object3;
                clazz = zzr$zzbc.class;
                synchronized (clazz) {
                    object3 = zzj;
                    if (object3 != null) return object3;
                    object2 = zzi;
                    zzj = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzi;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = zzr$zzbc$zzc.class;
                objectArray[4] = "zzf";
                objectArray[5] = object2 = zzr$zzbc$zzb.zzb();
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                return zzej.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u001b\u0003\u100c\u0001\u0004\u1004\u0002\u0005\u1004\u0003", objectArray);
            }
            case 2: {
                return new zzr$zzbc$zza(null);
            }
            case 1: 
        }
        return new zzr$zzbc();
    }
}

