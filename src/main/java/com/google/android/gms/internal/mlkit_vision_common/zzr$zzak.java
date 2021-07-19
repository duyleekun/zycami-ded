/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzak$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzak$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzak
extends zzej
implements zzft {
    private static final zzr$zzak zzk;
    private static volatile zzgb zzl;
    private int zzc;
    private zzr$zzam zzd;
    private long zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private zzeq zzj;

    static {
        zzr$zzak zzr$zzak;
        zzk = zzr$zzak = new zzr$zzak();
        zzej.zza(zzr$zzak.class, zzr$zzak);
    }

    private zzr$zzak() {
        zzeq zzeq2;
        this.zzj = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzak zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzak>)zzt.zza;
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
                Object object3 = zzl;
                if (object3 != null) return object3;
                clazz = zzr$zzak.class;
                synchronized (clazz) {
                    object3 = zzl;
                    if (object3 != null) return object3;
                    object2 = zzk;
                    zzl = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzk;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzac.zzb();
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = object2 = zzr$zzak$zzb.zzb();
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                return zzej.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1003\u0001\u0003\u100c\u0002\u0004\u1003\u0003\u0005\u100c\u0004\u0006\u1002\u0005\u0007\u0016", objectArray);
            }
            case 2: {
                return new zzr$zzak$zza(null);
            }
            case 1: 
        }
        return new zzr$zzak();
    }
}

