/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzbk;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzas$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzat;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzas
extends zzej
implements zzft {
    private static final zzep zzf;
    private static final zzr$zzas zzj;
    private static volatile zzgb zzk;
    private int zzc;
    private zzr$zzat zzd;
    private zzeq zze;
    private long zzg;
    private long zzh;
    private zzes zzi;

    static {
        Object object;
        zzf = object = new zzbk();
        zzj = object = new zzr$zzas();
        zzej.zza(zzr$zzas.class, (zzej)object);
    }

    private zzr$zzas() {
        zzes zzes2;
        this.zze = zzes2 = zzej.zzk();
        zzes2 = zzej.zzl();
        this.zzi = zzes2;
    }

    public static /* synthetic */ zzr$zzas zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzas>)zzt.zza;
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
                clazz = zzr$zzas.class;
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
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzac.zzb();
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = zzr$zzbf.class;
                return zzej.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u001e\u0003\u1003\u0001\u0004\u1003\u0002\u0005\u001b", objectArray);
            }
            case 2: {
                return new zzr$zzas$zza(null);
            }
            case 1: 
        }
        return new zzr$zzas();
    }
}

