/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzas$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzat;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzdf;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgj;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzas
extends zzgd
implements zzhn {
    private static final zzgj zzf;
    private static final zzbm$zzas zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private zzbm$zzat zzd;
    private zzgk zze;
    private long zzg;
    private long zzh;
    private zzgm zzi;

    static {
        Object object;
        zzf = object = new zzdf();
        zzj = object = new zzbm$zzas();
        zzgd.zza(zzbm$zzas.class, (zzgd)object);
    }

    private zzbm$zzas() {
        zzgm zzgm2;
        this.zze = zzgm2 = zzgd.zzk();
        zzgm2 = zzgd.zzl();
        this.zzi = zzgm2;
    }

    public static /* synthetic */ zzbm$zzas zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzas>)zzbo.zza;
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
                clazz = zzbm$zzas.class;
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
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzbx.zzb();
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = zzbm$zzbf.class;
                return zzgd.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u001e\u0003\u1003\u0001\u0004\u1003\u0002\u0005\u001b", objectArray);
            }
            case 2: {
                return new zzbm$zzas$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzas();
    }
}

