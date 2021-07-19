/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zze$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zze
extends zzgd
implements zzhn {
    private static final zzjp$zze zze;
    private static volatile zzhv zzf;
    private int zzc;
    private int zzd;

    static {
        zzjp$zze zzjp$zze;
        zze = zzjp$zze = new zzjp$zze();
        zzgd.zza(zzjp$zze.class, zzjp$zze);
    }

    private zzjp$zze() {
    }

    public static /* synthetic */ zzjp$zze zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zze>)zzjr.zza;
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
                Object object3 = zzf;
                if (object3 != null) return object3;
                clazz = zzjp$zze.class;
                synchronized (clazz) {
                    object3 = zzf;
                    if (object3 != null) return object3;
                    object2 = zze;
                    zzf = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zze;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                return zzgd.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u1004\u0000", objectArray);
            }
            case 2: {
                return new zzjp$zze$zza(null);
            }
            case 1: 
        }
        return new zzjp$zze();
    }
}

