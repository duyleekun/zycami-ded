/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzaw
extends zzgd
implements zzhn {
    private static final zzbm$zzaw zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private float zzh;
    private zzbm$zzam zzi;

    static {
        zzbm$zzaw zzbm$zzaw;
        zzj = zzbm$zzaw = new zzbm$zzaw();
        zzgd.zza(zzbm$zzaw.class, zzbm$zzaw);
    }

    private zzbm$zzaw() {
    }

    public static /* synthetic */ zzbm$zzaw zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzaw>)zzbo.zza;
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
                Object object3 = zzk;
                if (object3 != null) return object3;
                clazz = zzbm$zzaw.class;
                synchronized (clazz) {
                    object3 = zzk;
                    if (object3 != null) return object3;
                    object2 = zzj;
                    zzk = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzj;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbm$zzaw$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                return zzgd.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u100b\u0003\u0005\u1001\u0004\u0006\u1009\u0005", objectArray);
            }
            case 2: {
                return new zzbm$zzaw$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzaw();
    }
}

