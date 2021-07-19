/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzab;
import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzz$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzz
extends zzej
implements zzft {
    private static final zzep zzg;
    private static final zzr$zzz zzj;
    private static volatile zzgb zzk;
    private int zzc;
    private zzr$zzam zzd;
    private zzr$zzam zze;
    private zzeq zzf;
    private long zzh;
    private boolean zzi;

    static {
        Object object;
        zzg = object = new zzab();
        zzj = object = new zzr$zzz();
        zzej.zza(zzr$zzz.class, (zzej)object);
    }

    private zzr$zzz() {
        zzeq zzeq2;
        this.zzf = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzz zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzz>)zzt.zza;
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
                Object object3 = zzk;
                if (object3 != null) return object3;
                clazz = zzr$zzz.class;
                synchronized (clazz) {
                    object3 = zzk;
                    if (object3 != null) return object3;
                    object2 = zzj;
                    zzk = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzj;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzac.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                return zzej.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u1003\u0002\u0005\u1007\u0003", objectArray);
            }
            case 2: {
                return new zzr$zzz$zza(null);
            }
            case 1: 
        }
        return new zzr$zzz();
    }
}

