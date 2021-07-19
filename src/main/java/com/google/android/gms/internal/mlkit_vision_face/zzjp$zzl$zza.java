/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzk;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzl$zza
extends zzgd
implements zzhn {
    private static final zzjp$zzl$zza zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private zzgm zzf;

    static {
        zzjp$zzl$zza zzjp$zzl$zza;
        zzg = zzjp$zzl$zza = new zzjp$zzl$zza();
        zzgd.zza(zzjp$zzl$zza.class, zzjp$zzl$zza);
    }

    private zzjp$zzl$zza() {
        zzgm zzgm2;
        this.zzf = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzjp$zzl$zza zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzl$zza>)zzjr.zza;
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
                clazz = zzjp$zzl$zza.class;
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
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = zzjp$zzk.class;
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u1004\u0001\u0003\u001b", objectArray);
            }
            case 2: {
                return new zzjp$zzl$zza$zza(null);
            }
            case 1: 
        }
        return new zzjp$zzl$zza();
    }
}

