/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbe;
import com.google.android.gms.internal.mlkit_vision_common.zzbf;
import com.google.android.gms.internal.mlkit_vision_common.zzcc$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzep;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzao
extends zzej
implements zzft {
    private static final zzep zzg;
    private static final zzep zzi;
    private static final zzr$zzao zzk;
    private static volatile zzgb zzl;
    private int zzc;
    private zzr$zzaf zzd;
    private zzcc$zza zze;
    private zzeq zzf;
    private zzeq zzh;
    private zzr$zzae zzj;

    static {
        Object object;
        zzg = object = new zzbe();
        zzi = object = new zzbf();
        zzk = object = new zzr$zzao();
        zzej.zza(zzr$zzao.class, (zzej)object);
    }

    private zzr$zzao() {
        zzeq zzeq2;
        this.zzf = zzeq2 = zzej.zzk();
        this.zzh = zzeq2 = zzej.zzk();
    }

    public static /* synthetic */ zzr$zzao zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzao>)zzt.zza;
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
                clazz = zzr$zzao.class;
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
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzr$zzao$zza.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = object2 = zzr$zzao$zzb.zzb();
                objectArray[7] = "zzj";
                return zzej.zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u001e\u0005\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzr$zzao$zzc(null);
            }
            case 1: 
        }
        return new zzr$zzao();
    }
}

