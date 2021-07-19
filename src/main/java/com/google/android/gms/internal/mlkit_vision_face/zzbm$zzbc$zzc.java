/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzbc$zzc
extends zzgd
implements zzhn {
    private static final zzbm$zzbc$zzc zze;
    private static volatile zzhv zzf;
    private int zzc;
    private float zzd;

    static {
        zzbm$zzbc$zzc zzbm$zzbc$zzc;
        zze = zzbm$zzbc$zzc = new zzbm$zzbc$zzc();
        zzgd.zza(zzbm$zzbc$zzc.class, zzbm$zzbc$zzc);
    }

    private zzbm$zzbc$zzc() {
    }

    public static /* synthetic */ zzbm$zzbc$zzc zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzbc$zzc>)zzbo.zza;
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
                clazz = zzbm$zzbc$zzc.class;
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
                return zzgd.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u1001\u0000", objectArray);
            }
            case 2: {
                return new zzbm$zzbc$zzc$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzbc$zzc();
    }
}

