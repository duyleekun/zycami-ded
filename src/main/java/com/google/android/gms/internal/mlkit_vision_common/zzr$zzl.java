/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzl$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;
import com.google.android.gms.internal.mlkit_vision_common.zzw;

public final class zzr$zzl
extends zzej
implements zzft {
    private static final zzep zzg;
    private static final zzr$zzl zzi;
    private static volatile zzgb zzj;
    private int zzc;
    private zzr$zzam zzd;
    private zzr$zzam zze;
    private zzeq zzf;
    private long zzh;

    static {
        Object object;
        zzg = object = new zzw();
        zzi = object = new zzr$zzl();
        zzej.zza(zzr$zzl.class, (zzej)object);
    }

    private zzr$zzl() {
        zzeq zzeq2;
        this.zzf = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzl zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzl>)zzt.zza;
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
                clazz = zzr$zzl.class;
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
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzac.zzb();
                objectArray[5] = "zzh";
                return zzej.zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u1003\u0002", objectArray);
            }
            case 2: {
                return new zzr$zzl$zza(null);
            }
            case 1: 
        }
        return new zzr$zzl();
    }
}

