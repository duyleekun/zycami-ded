/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzar$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzar
extends zzgd
implements zzhn {
    private static final zzbm$zzar zzi;
    private static volatile zzhv zzj;
    private int zzc;
    private zzbm$zzaf zzd;
    private zzbm$zzat zze;
    private zzbm$zzae zzf;
    private int zzg;
    private float zzh;

    static {
        zzbm$zzar zzbm$zzar;
        zzi = zzbm$zzar = new zzbm$zzar();
        zzgd.zza(zzbm$zzar.class, zzbm$zzar);
    }

    private zzbm$zzar() {
    }

    public static /* synthetic */ zzbm$zzar zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzar>)zzbo.zza;
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
                Object object3 = zzj;
                if (object3 != null) return object3;
                clazz = zzbm$zzar.class;
                synchronized (clazz) {
                    object3 = zzj;
                    if (object3 != null) return object3;
                    object2 = zzi;
                    zzj = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzi;
            }
            case 3: {
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                return zzgd.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u100b\u0003\u0005\u1001\u0004", objectArray);
            }
            case 2: {
                return new zzbm$zzar$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzar();
    }
}

