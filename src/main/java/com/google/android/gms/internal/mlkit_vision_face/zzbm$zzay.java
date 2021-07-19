/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaw;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzay$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzay
extends zzgd
implements zzhn {
    private static final zzbm$zzay zzi;
    private static volatile zzhv zzj;
    private int zzc;
    private zzbm$zzaw zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private zzgm zzh;

    static {
        zzbm$zzay zzbm$zzay;
        zzi = zzbm$zzay = new zzbm$zzay();
        zzgd.zza(zzbm$zzay.class, zzbm$zzay);
    }

    private zzbm$zzay() {
        zzgm zzgm2;
        this.zzh = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzbm$zzay zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzay>)zzbo.zza;
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
                clazz = zzbm$zzay.class;
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
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzbx.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = zzbm$zzbf.class;
                return zzgd.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u100c\u0001\u0003\u1003\u0002\u0004\u1003\u0003\u0005\u001b", objectArray);
            }
            case 2: {
                return new zzbm$zzay$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzay();
    }
}

