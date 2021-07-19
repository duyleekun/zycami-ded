/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzcc$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;
import com.google.android.gms.internal.mlkit_vision_common.zzu;
import com.google.android.gms.internal.mlkit_vision_common.zzv;

public final class zzr$zzc$zza
extends zzej
implements zzft {
    private static final zzep zzj;
    private static final zzep zzl;
    private static final zzr$zzc$zza zzm;
    private static volatile zzgb zzn;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private zzr$zzae zzg;
    private zzcc$zza zzh;
    private zzeq zzi;
    private zzeq zzk;

    static {
        Object object;
        zzj = object = new zzv();
        zzl = object = new zzu();
        zzm = object = new zzr$zzc$zza();
        zzej.zza(zzr$zzc$zza.class, (zzej)object);
    }

    private zzr$zzc$zza() {
        zzeq zzeq2;
        this.zzi = zzeq2 = zzej.zzk();
        this.zzk = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzc$zza zza() {
        return zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzc$zza>)zzt.zza;
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
                Object object3 = zzn;
                if (object3 != null) return object3;
                clazz = zzr$zzc$zza.class;
                synchronized (clazz) {
                    object3 = zzn;
                    if (object3 != null) return object3;
                    object2 = zzm;
                    zzn = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzm;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzac.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = object2 = zzr$zzao$zza.zzb();
                objectArray[9] = "zzk";
                objectArray[10] = object2 = zzr$zzao$zzb.zzb();
                return zzej.zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u1009\u0003\u0005\u1009\u0004\u0006\u001e\u0007\u001e", objectArray);
            }
            case 2: {
                return new zzr$zzc$zza$zza(null);
            }
            case 1: 
        }
        return new zzr$zzc$zza();
    }
}

