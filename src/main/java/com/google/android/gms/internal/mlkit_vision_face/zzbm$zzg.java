/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzg$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzg
extends zzgd
implements zzhn {
    private static final zzbm$zzg zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private zzbm$zzg$zza zzd;
    private int zze;
    private zzbm$zzab zzf;

    static {
        zzbm$zzg zzbm$zzg;
        zzg = zzbm$zzg = new zzbm$zzg();
        zzgd.zza(zzbm$zzg.class, zzbm$zzg);
    }

    private zzbm$zzg() {
    }

    public static /* synthetic */ zzbm$zzg zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzg>)zzbo.zza;
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
                clazz = zzbm$zzg.class;
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
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u100b\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzg$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzg();
    }
}

