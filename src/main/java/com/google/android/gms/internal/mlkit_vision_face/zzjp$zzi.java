/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzi
extends zzgd
implements zzhn {
    private static final zzjp$zzi zzd;
    private static volatile zzhv zze;
    private zzgm zzc;

    static {
        zzjp$zzi zzjp$zzi;
        zzd = zzjp$zzi = new zzjp$zzi();
        zzgd.zza(zzjp$zzi.class, zzjp$zzi);
    }

    private zzjp$zzi() {
        zzgm zzgm2;
        this.zzc = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzjp$zzi zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzi>)zzjr.zza;
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
                clazz = zzjp$zzi.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = zzjp$zzi$zza.class;
                return zzgd.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzjp$zzi$zzb(null);
            }
            case 1: 
        }
        return new zzjp$zzi();
    }
}

