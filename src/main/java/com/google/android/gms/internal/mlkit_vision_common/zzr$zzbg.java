/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbx;
import com.google.android.gms.internal.mlkit_vision_common.zzby;
import com.google.android.gms.internal.mlkit_vision_common.zzbz;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzbg
extends zzej
implements zzft {
    private static final zzep zzf;
    private static final zzep zzh;
    private static final zzep zzj;
    private static final zzr$zzbg zzl;
    private static volatile zzgb zzm;
    private int zzc;
    private long zzd;
    private zzeq zze;
    private zzeq zzg;
    private zzeq zzi;
    private int zzk;

    static {
        Object object;
        zzf = object = new zzby();
        zzh = object = new zzbx();
        zzj = object = new zzbz();
        zzl = object = new zzr$zzbg();
        zzej.zza(zzr$zzbg.class, (zzej)object);
    }

    private zzr$zzbg() {
        zzeq zzeq2;
        this.zze = zzeq2 = zzej.zzk();
        this.zzg = zzeq2 = zzej.zzk();
        this.zzi = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzbg zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzbg>)zzt.zza;
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
                Object object3 = zzm;
                if (object3 != null) return object3;
                clazz = zzr$zzbg.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzl;
            }
            case 3: {
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzr$zzbg$zzb.zzb();
                objectArray[4] = "zzg";
                objectArray[5] = object2 = zzr$zzbg$zzb.zzb();
                objectArray[6] = "zzi";
                objectArray[7] = object2 = zzr$zzbg$zzb.zzb();
                objectArray[8] = "zzk";
                return zzej.zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u1003\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzr$zzbg$zza(null);
            }
            case 1: 
        }
        return new zzr$zzbg();
    }
}

