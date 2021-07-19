/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzf$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzf$zza
extends zzgd
implements zzhn {
    private static final zzbm$zzf$zza zzi;
    private static volatile zzhv zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private zzbm$zzae zzg;
    private zzbm$zzaw zzh;

    static {
        zzbm$zzf$zza zzbm$zzf$zza;
        zzi = zzbm$zzf$zza = new zzbm$zzf$zza();
        zzgd.zza(zzbm$zzf$zza.class, zzbm$zzf$zza);
    }

    private zzbm$zzf$zza() {
    }

    public static /* synthetic */ zzbm$zzf$zza zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzf$zza>)zzbo.zza;
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
                clazz = zzbm$zzf$zza.class;
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
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbx.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                return zzgd.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u1009\u0003\u0005\u1009\u0004", objectArray);
            }
            case 2: {
                return new zzbm$zzf$zza$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzf$zza();
    }
}

