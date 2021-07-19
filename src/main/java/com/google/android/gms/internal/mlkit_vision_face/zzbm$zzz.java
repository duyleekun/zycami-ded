/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzam;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzz$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbw;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgj;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzz
extends zzgd
implements zzhn {
    private static final zzgj zzg;
    private static final zzbm$zzz zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private zzbm$zzam zzd;
    private zzbm$zzam zze;
    private zzgk zzf;
    private long zzh;
    private boolean zzi;

    static {
        Object object;
        zzg = object = new zzbw();
        zzj = object = new zzbm$zzz();
        zzgd.zza(zzbm$zzz.class, (zzgd)object);
    }

    private zzbm$zzz() {
        zzgk zzgk2;
        this.zzf = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzbm$zzz zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzz>)zzbo.zza;
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
                clazz = zzbm$zzz.class;
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
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzbx.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                return zzgd.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u1003\u0002\u0005\u1007\u0003", objectArray);
            }
            case 2: {
                return new zzbm$zzz$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzz();
    }
}

