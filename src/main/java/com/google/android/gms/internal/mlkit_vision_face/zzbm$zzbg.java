/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbg$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzds;
import com.google.android.gms.internal.mlkit_vision_face.zzdt;
import com.google.android.gms.internal.mlkit_vision_face.zzdu;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgj;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzbg
extends zzgd
implements zzhn {
    private static final zzgj zzf;
    private static final zzgj zzh;
    private static final zzgj zzj;
    private static final zzbm$zzbg zzl;
    private static volatile zzhv zzm;
    private int zzc;
    private long zzd;
    private zzgk zze;
    private zzgk zzg;
    private zzgk zzi;
    private int zzk;

    static {
        Object object;
        zzf = object = new zzdt();
        zzh = object = new zzds();
        zzj = object = new zzdu();
        zzl = object = new zzbm$zzbg();
        zzgd.zza(zzbm$zzbg.class, (zzgd)object);
    }

    private zzbm$zzbg() {
        zzgk zzgk2;
        this.zze = zzgk2 = zzgd.zzk();
        this.zzg = zzgk2 = zzgd.zzk();
        this.zzi = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzbm$zzbg zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzbg>)zzbo.zza;
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
                Object object3 = zzm;
                if (object3 != null) return object3;
                clazz = zzbm$zzbg.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzl;
            }
            case 3: {
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzbm$zzbg$zzb.zzb();
                objectArray[4] = "zzg";
                objectArray[5] = object2 = zzbm$zzbg$zzb.zzb();
                objectArray[6] = "zzi";
                objectArray[7] = object2 = zzbm$zzbg$zzb.zzb();
                objectArray[8] = "zzk";
                return zzgd.zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u1003\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzbm$zzbg$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzbg();
    }
}

