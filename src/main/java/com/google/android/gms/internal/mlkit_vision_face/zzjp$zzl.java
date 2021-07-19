/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzl
extends zzgd$zze
implements zzhn {
    private static final zzjp$zzl zzf;
    private static volatile zzhv zzg;
    private zzgm zzd;
    private byte zze = (byte)2;

    static {
        zzjp$zzl zzjp$zzl;
        zzf = zzjp$zzl = new zzjp$zzl();
        zzgd.zza(zzjp$zzl.class, zzjp$zzl);
    }

    private zzjp$zzl() {
        zzgm zzgm2;
        this.zzd = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzjp$zzl zza() {
        return zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzjr.zza;
        int n10 = 1;
        object -= n10;
        object = object2[object];
        object2 = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                }
                object = (byte)n10;
                this.zze = (byte)object;
                return null;
            }
            case 6: {
                return this.zze;
            }
            case 5: {
                Object object3 = zzg;
                if (object3 != null) return object3;
                clazz = zzjp$zzl.class;
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
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzd";
                objectArray[n10] = zzjp$zzl$zza.class;
                return zzgd.zza(zzf, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzjp$zzl$zzb(null);
            }
            case 1: 
        }
        return new zzjp$zzl();
    }
}

