/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzau$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzau$zzd
extends zzgd
implements zzhn {
    private static final zzbm$zzau$zzd zzd;
    private static volatile zzhv zze;
    private zzgm zzc;

    static {
        zzbm$zzau$zzd zzbm$zzau$zzd;
        zzd = zzbm$zzau$zzd = new zzbm$zzau$zzd();
        zzgd.zza(zzbm$zzau$zzd.class, zzbm$zzau$zzd);
    }

    private zzbm$zzau$zzd() {
        zzgm zzgm2;
        this.zzc = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzbm$zzau$zzd zza() {
        return zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzau$zzd>)zzbo.zza;
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
                clazz = zzbm$zzau$zzd.class;
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
                objectArray[by2] = zzbm$zzau$zza.class;
                return zzgd.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzbm$zzau$zzd$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzau$zzd();
    }
}

