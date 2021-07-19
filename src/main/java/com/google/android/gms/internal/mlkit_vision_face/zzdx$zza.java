/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdx$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzdy;
import com.google.android.gms.internal.mlkit_vision_face.zzdz;
import com.google.android.gms.internal.mlkit_vision_face.zzeq;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgj;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzdx$zza
extends zzgd
implements zzhn {
    private static final zzgj zzd;
    private static final zzdx$zza zze;
    private static volatile zzhv zzf;
    private zzgk zzc;

    static {
        Object object;
        zzd = object = new zzdz();
        zze = object = new zzdx$zza();
        zzgd.zza(zzdx$zza.class, (zzgd)object);
    }

    private zzdx$zza() {
        zzgk zzgk2;
        this.zzc = zzgk2 = zzgd.zzk();
    }

    public static /* synthetic */ zzdx$zza zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object object2, Object object3) {
        object2 = zzdy.zza;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                Object object4 = zzf;
                if (object4 != null) return object4;
                object2 = zzdx$zza.class;
                synchronized (object2) {
                    object4 = zzf;
                    if (object4 != null) return object4;
                    object3 = zze;
                    zzf = object4 = new zzgd$zzc((zzgd)object3);
                    return object4;
                }
            }
            case 4: {
                return zze;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = object2 = zzeq.zzb();
                return zzgd.zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", objectArray);
            }
            case 2: {
                return new zzdx$zza$zza(null);
            }
            case 1: 
        }
        return new zzdx$zza();
    }
}

