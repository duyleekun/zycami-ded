/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzan;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzax$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzax
extends zzgd
implements zzhn {
    private static final zzbm$zzax zzh;
    private static volatile zzhv zzi;
    private int zzc;
    private zzbm$zzaf zzd;
    private zzbm$zzae zze;
    private zzbm$zzaw zzf;
    private zzgm zzg;

    static {
        zzbm$zzax zzbm$zzax;
        zzh = zzbm$zzax = new zzbm$zzax();
        zzgd.zza(zzbm$zzax.class, zzbm$zzax);
    }

    private zzbm$zzax() {
        zzgm zzgm2;
        this.zzg = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzbm$zzax zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzax>)zzbo.zza;
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
                clazz = zzbm$zzax.class;
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
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = zzbm$zzan.class;
                return zzgd.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u001b", objectArray);
            }
            case 2: {
                return new zzbm$zzax$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzax();
    }
}

