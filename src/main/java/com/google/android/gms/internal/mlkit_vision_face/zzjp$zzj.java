/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzj$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzj
extends zzgd
implements zzhn {
    private static final zzjp$zzj zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private int zzd;
    private zzjp$zzh zze;
    private zzjp$zze zzf;

    static {
        zzjp$zzj zzjp$zzj;
        zzg = zzjp$zzj = new zzjp$zzj();
        zzgd.zza(zzjp$zzj.class, zzjp$zzj);
    }

    private zzjp$zzj() {
    }

    public static /* synthetic */ zzjp$zzj zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzj>)zzjr.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzjp$zzj.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzjp$zzj$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzjp$zzj$zzb(null);
            }
            case 1: 
        }
        return new zzjp$zzj();
    }
}

