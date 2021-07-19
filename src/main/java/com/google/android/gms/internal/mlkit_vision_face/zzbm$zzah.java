/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzah$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzah
extends zzgd
implements zzhn {
    private static final zzbm$zzah zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";

    static {
        zzbm$zzah zzbm$zzah;
        zzg = zzbm$zzah = new zzbm$zzah();
        zzgd.zza(zzbm$zzah.class, zzbm$zzah);
    }

    private zzbm$zzah() {
    }

    public static /* synthetic */ zzbm$zzah zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzah>)zzbo.zza;
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
                clazz = zzbm$zzah.class;
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
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbm$zzal$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1008\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzah$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzah();
    }
}

