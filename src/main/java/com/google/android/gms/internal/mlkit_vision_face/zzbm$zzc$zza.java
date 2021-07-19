/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzc$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbp;
import com.google.android.gms.internal.mlkit_vision_face.zzbq;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzdx$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgj;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzc$zza
extends zzgd
implements zzhn {
    private static final zzgj zzj;
    private static final zzgj zzl;
    private static final zzbm$zzc$zza zzm;
    private static volatile zzhv zzn;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private zzbm$zzae zzg;
    private zzdx$zza zzh;
    private zzgk zzi;
    private zzgk zzk;

    static {
        Object object;
        zzj = object = new zzbq();
        zzl = object = new zzbp();
        zzm = object = new zzbm$zzc$zza();
        zzgd.zza(zzbm$zzc$zza.class, (zzgd)object);
    }

    private zzbm$zzc$zza() {
        zzgk zzgk2;
        this.zzi = zzgk2 = zzgd.zzk();
        this.zzk = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzbm$zzc$zza zza() {
        return zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzc$zza>)zzbo.zza;
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
                Object object3 = zzn;
                if (object3 != null) return object3;
                clazz = zzbm$zzc$zza.class;
                synchronized (clazz) {
                    object3 = zzn;
                    if (object3 != null) return object3;
                    object2 = zzm;
                    zzn = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzm;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbx.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = object2 = zzbm$zzao$zza.zzb();
                objectArray[9] = "zzk";
                objectArray[10] = object2 = zzbm$zzao$zzb.zzb();
                return zzgd.zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u1009\u0003\u0005\u1009\u0004\u0006\u001e\u0007\u001e", objectArray);
            }
            case 2: {
                return new zzbm$zzc$zza$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzc$zza();
    }
}

