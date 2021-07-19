/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzay$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzay
extends zzej
implements zzft {
    private static final zzr$zzay zzi;
    private static volatile zzgb zzj;
    private int zzc;
    private zzr$zzaw zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private zzes zzh;

    static {
        zzr$zzay zzr$zzay;
        zzi = zzr$zzay = new zzr$zzay();
        zzej.zza(zzr$zzay.class, zzr$zzay);
    }

    private zzr$zzay() {
        zzes zzes2;
        this.zzh = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzr$zzay zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzay>)zzt.zza;
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
                clazz = zzr$zzay.class;
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
                objectArray[3] = object2 = zzac.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = zzr$zzbf.class;
                return zzej.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u100c\u0001\u0003\u1003\u0002\u0004\u1003\u0003\u0005\u001b", objectArray);
            }
            case 2: {
                return new zzr$zzay$zza(null);
            }
            case 1: 
        }
        return new zzr$zzay();
    }
}

