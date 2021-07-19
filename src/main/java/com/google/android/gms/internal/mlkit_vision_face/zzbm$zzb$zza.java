/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzb$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzy$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzb$zza
extends zzgd
implements zzhn {
    private static final zzbm$zzb$zza zzi;
    private static volatile zzhv zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzgm zzf;
    private zzgm zzg;
    private zzbm$zzam zzh;

    static {
        zzbm$zzb$zza zzbm$zzb$zza;
        zzi = zzbm$zzb$zza = new zzbm$zzb$zza();
        zzgd.zza(zzbm$zzb$zza.class, zzbm$zzb$zza);
    }

    private zzbm$zzb$zza() {
        zzgm zzgm2;
        this.zzf = zzgm2 = zzgd.zzl();
        this.zzg = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzbm$zzb$zza zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = zzbm.zzy.zza.class;
        object2 = zzbo.zza;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                clazz = zzbm$zzb$zza.class;
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
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                zzgh zzgh2 = zzbx.zzb();
                objectArray[2] = zzgh2;
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = clazz;
                objectArray[6] = "zzg";
                objectArray[7] = clazz;
                objectArray[8] = "zzh";
                return zzgd.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u001b\u0004\u001b\u0005\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzb$zza$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzb$zza();
    }
}

