/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzba$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzba
extends zzgd
implements zzhn {
    private static final zzbm$zzba zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzbm$zzba zzbm$zzba;
        zzg = zzbm$zzba = new zzbm$zzba();
        zzgd.zza(zzbm$zzba.class, zzbm$zzba);
    }

    private zzbm$zzba() {
    }

    public static /* synthetic */ zzbm$zzba zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzba>)zzbo.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzbm$zzba.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbm$zzba$zzb.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzbm$zzba$zzc.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = object2 = zzbm$zzba$zzc.zzb();
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u100c\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzba$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzba();
    }
}

