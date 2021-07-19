/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzam
extends zzgd
implements zzhn {
    private static final zzbm$zzam zzh;
    private static volatile zzhv zzi;
    private int zzc;
    private zzbm$zzal zzd;
    private zzbm$zzam$zza zze;
    private zzbm$zzam$zza zzf;
    private boolean zzg;

    static {
        zzbm$zzam zzbm$zzam;
        zzh = zzbm$zzam = new zzbm$zzam();
        zzgd.zza(zzbm$zzam.class, zzbm$zzam);
    }

    private zzbm$zzam() {
    }

    public static /* synthetic */ zzbm$zzam zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzam>)zzbo.zza;
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
                Object object3 = zzi;
                if (object3 != null) return object3;
                clazz = zzbm$zzam.class;
                synchronized (clazz) {
                    object3 = zzi;
                    if (object3 != null) return object3;
                    object2 = zzh;
                    zzi = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzh;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                return zzgd.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1007\u0003", objectArray);
            }
            case 2: {
                return new zzbm$zzam$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzam();
    }
}

