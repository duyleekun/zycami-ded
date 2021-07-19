/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzc$zzd
extends zzgd
implements zzhn {
    private static final zzjp$zzc$zzd zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private zzjp$zzc$zzb zzd;
    private zzjp$zzc$zzb zze;
    private boolean zzf;

    static {
        zzjp$zzc$zzd zzjp$zzc$zzd;
        zzg = zzjp$zzc$zzd = new zzjp$zzc$zzd();
        zzgd.zza(zzjp$zzc$zzd.class, zzjp$zzc$zzd);
    }

    private zzjp$zzc$zzd() {
    }

    public static /* synthetic */ zzjp$zzc$zzd zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzc$zzd>)zzjr.zza;
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
                clazz = zzjp$zzc$zzd.class;
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
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1007\u0002", objectArray);
            }
            case 2: {
                return new zzjp$zzc$zzd$zza(null);
            }
            case 1: 
        }
        return new zzjp$zzc$zzd();
    }
}

