/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbc$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzbc
extends zzgd
implements zzhn {
    private static final zzbm$zzbc zzi;
    private static volatile zzhv zzj;
    private int zzc;
    private zzbm$zzaf zzd;
    private zzgm zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzbm$zzbc zzbm$zzbc;
        zzi = zzbm$zzbc = new zzbm$zzbc();
        zzgd.zza(zzbm$zzbc.class, zzbm$zzbc);
    }

    private zzbm$zzbc() {
        zzgm zzgm2;
        this.zze = zzgm2 = zzgd.zzl();
    }

    public static /* synthetic */ zzbm$zzbc zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzbc>)zzbo.zza;
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
                clazz = zzbm$zzbc.class;
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
                objectArray[3] = zzbm$zzbc$zzc.class;
                objectArray[4] = "zzf";
                objectArray[5] = object2 = zzbm$zzbc$zzb.zzb();
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                return zzgd.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u001b\u0003\u100c\u0001\u0004\u1004\u0002\u0005\u1004\u0003", objectArray);
            }
            case 2: {
                return new zzbm$zzbc$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzbc();
    }
}

