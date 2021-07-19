/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzak$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzak
extends zzgd
implements zzhn {
    private static final zzbm$zzak zzk;
    private static volatile zzhv zzl;
    private int zzc;
    private zzbm$zzam zzd;
    private long zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private zzgk zzj;

    static {
        zzbm$zzak zzbm$zzak;
        zzk = zzbm$zzak = new zzbm$zzak();
        zzgd.zza(zzbm$zzak.class, zzbm$zzak);
    }

    private zzbm$zzak() {
        zzgk zzgk2;
        this.zzj = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzbm$zzak zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzak>)zzbo.zza;
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
                Object object3 = zzl;
                if (object3 != null) return object3;
                clazz = zzbm$zzak.class;
                synchronized (clazz) {
                    object3 = zzl;
                    if (object3 != null) return object3;
                    object2 = zzk;
                    zzl = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzk;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzbx.zzb();
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = object2 = zzbm$zzak$zzb.zzb();
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                return zzgd.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1003\u0001\u0003\u100c\u0002\u0004\u1003\u0003\u0005\u100c\u0004\u0006\u1002\u0005\u0007\u0016", objectArray);
            }
            case 2: {
                return new zzbm$zzak$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzak();
    }
}

