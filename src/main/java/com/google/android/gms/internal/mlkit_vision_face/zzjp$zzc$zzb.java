/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzc$zzb
extends zzgd
implements zzhn {
    private static final zzjp$zzc$zzb zzf;
    private static volatile zzhv zzg;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzjp$zzc$zzb zzjp$zzc$zzb;
        zzf = zzjp$zzc$zzb = new zzjp$zzc$zzb();
        zzgd.zza(zzjp$zzc$zzb.class, zzjp$zzc$zzb);
    }

    private zzjp$zzc$zzb() {
    }

    public static /* synthetic */ zzjp$zzc$zzb zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzc$zzb>)zzjr.zza;
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
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzjp$zzc$zzb.class;
                synchronized (clazz) {
                    object3 = zzg;
                    if (object3 != null) return object3;
                    object2 = zzf;
                    zzg = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzf;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                return zzgd.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzjp$zzc$zzb$zza(null);
            }
            case 1: 
        }
        return new zzjp$zzc$zzb();
    }
}

