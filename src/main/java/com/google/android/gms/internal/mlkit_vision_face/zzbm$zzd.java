/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzd
extends zzgd
implements zzhn {
    private static final zzbm$zzd zzg;
    private static volatile zzhv zzh;
    private int zzc;
    private zzbm$zzd$zza zzd;
    private int zze;
    private zzbm$zzab zzf;

    static {
        zzbm$zzd zzbm$zzd;
        zzg = zzbm$zzd = new zzbm$zzd();
        zzgd.zza(zzbm$zzd.class, zzbm$zzd);
    }

    private zzbm$zzd() {
    }

    public static zzbm$zzd$zzb zza() {
        return (zzbm$zzd$zzb)zzg.zzh();
    }

    private final void zza(zzbm$zzab zzbm$zzab) {
        int n10;
        zzbm$zzab.getClass();
        this.zzf = zzbm$zzab;
        this.zzc = n10 = this.zzc | 4;
    }

    private final void zza(zzbm$zzd$zza zzbm$zzd$zza) {
        int n10;
        zzbm$zzd$zza.getClass();
        this.zzd = zzbm$zzd$zza;
        this.zzc = n10 = this.zzc | 1;
    }

    public static /* synthetic */ void zza(zzbm$zzd zzbm$zzd, int n10) {
        zzbm$zzd.zzb(n10);
    }

    public static /* synthetic */ void zza(zzbm$zzd zzbm$zzd, zzbm$zzab zzbm$zzab) {
        zzbm$zzd.zza(zzbm$zzab);
    }

    public static /* synthetic */ void zza(zzbm$zzd zzbm$zzd, zzbm$zzd$zza zzbm$zzd$zza) {
        zzbm$zzd.zza(zzbm$zzd$zza);
    }

    public static /* synthetic */ zzbm$zzd zzb() {
        return zzg;
    }

    private final void zzb(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 2;
        this.zze = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzd>)zzbo.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzbm$zzd.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzgd.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u100b\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzbm$zzd$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzd();
    }
}

