/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzg
extends zzgd
implements zzhn {
    private static final zzjp$zzg zzd;
    private static volatile zzhv zze;
    private zzgk zzc;

    static {
        zzjp$zzg zzjp$zzg;
        zzd = zzjp$zzg = new zzjp$zzg();
        zzgd.zza(zzjp$zzg.class, zzjp$zzg);
    }

    private zzjp$zzg() {
        zzgk zzgk2;
        this.zzc = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzjp$zzg zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzg>)zzjr.zza;
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
                Object object3 = zze;
                if (object3 != null) return object3;
                clazz = zzjp$zzg.class;
                synchronized (clazz) {
                    object3 = zze;
                    if (object3 != null) return object3;
                    object2 = zzd;
                    zze = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzd;
            }
            case 3: {
                Object[] objectArray = new Object[by2];
                objectArray[0] = "zzc";
                return zzgd.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", objectArray);
            }
            case 2: {
                return new zzjp$zzg$zza(null);
            }
            case 1: 
        }
        return new zzjp$zzg();
    }
}

