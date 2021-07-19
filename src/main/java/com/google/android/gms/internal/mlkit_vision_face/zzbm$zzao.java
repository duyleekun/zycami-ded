/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzao$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzcz;
import com.google.android.gms.internal.mlkit_vision_face.zzda;
import com.google.android.gms.internal.mlkit_vision_face.zzdx$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgj;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzao
extends zzgd
implements zzhn {
    private static final zzgj zzg;
    private static final zzgj zzi;
    private static final zzbm$zzao zzk;
    private static volatile zzhv zzl;
    private int zzc;
    private zzbm$zzaf zzd;
    private zzdx.zza zze;
    private zzgk zzf;
    private zzgk zzh;
    private zzbm$zzae zzj;

    static {
        Object object;
        zzg = object = new zzcz();
        zzi = object = new zzda();
        zzk = object = new zzbm$zzao();
        zzgd.zza(zzbm$zzao.class, (zzgd)object);
    }

    private zzbm$zzao() {
        zzgk zzgk2;
        this.zzf = zzgk2 = zzgd.zzk();
        this.zzh = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzbm$zzao zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzao>)zzbo.zza;
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
                clazz = zzbm$zzao.class;
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
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzbm$zzao$zza.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = object2 = zzbm$zzao$zzb.zzb();
                objectArray[7] = "zzj";
                return zzgd.zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u001e\u0005\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzao$zzc(null);
            }
            case 1: 
        }
        return new zzbm$zzao();
    }
}

