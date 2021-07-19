/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzap$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzdx$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzap
extends zzgd
implements zzhn {
    private static final zzbm$zzap zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private zzbm$zzaf zzd;
    private zzdx.zzb zze;
    private zzbm$zzae zzf;
    private zzbm$zzac zzg;
    private int zzh;
    private int zzi;

    static {
        zzbm$zzap zzbm$zzap;
        zzj = zzbm$zzap = new zzbm$zzap();
        zzgd.zza(zzbm$zzap.class, zzbm$zzap);
    }

    private zzbm$zzap() {
    }

    public static zzbm$zzap$zza zza() {
        return (zzbm$zzap$zza)zzj.zzh();
    }

    private final void zza(zzbm$zzac zzbm$zzac) {
        int n10;
        zzbm$zzac.getClass();
        this.zzg = zzbm$zzac;
        this.zzc = n10 = this.zzc | 8;
    }

    private final void zza(zzbm$zzae zzbm$zzae) {
        int n10;
        zzbm$zzae.getClass();
        this.zzf = zzbm$zzae;
        this.zzc = n10 = this.zzc | 4;
    }

    private final void zza(zzbm$zzaf zzbm$zzaf) {
        int n10;
        zzbm$zzaf.getClass();
        this.zzd = zzbm$zzaf;
        this.zzc = n10 = this.zzc | 1;
    }

    public static /* synthetic */ void zza(zzbm$zzap zzbm$zzap, int n10) {
        zzbm$zzap.zzb(n10);
    }

    public static /* synthetic */ void zza(zzbm$zzap zzbm$zzap, zzbm$zzac zzbm$zzac) {
        zzbm$zzap.zza(zzbm$zzac);
    }

    public static /* synthetic */ void zza(zzbm$zzap zzbm$zzap, zzbm$zzae zzbm$zzae) {
        zzbm$zzap.zza(zzbm$zzae);
    }

    public static /* synthetic */ void zza(zzbm$zzap zzbm$zzap, zzbm$zzaf zzbm$zzaf) {
        zzbm$zzap.zza(zzbm$zzaf);
    }

    public static /* synthetic */ zzbm$zzap zzb() {
        return zzj;
    }

    private final void zzb(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 0x10;
        this.zzh = n10;
    }

    public static /* synthetic */ void zzb(zzbm$zzap zzbm$zzap, int n10) {
        zzbm$zzap.zzc(n10);
    }

    private final void zzc(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 0x20;
        this.zzi = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzap>)zzbo.zza;
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
                clazz = zzbm$zzap.class;
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
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                return zzgd.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1009\u0003\u0005\u100b\u0004\u0006\u100b\u0005", objectArray);
            }
            case 2: {
                return new zzbm$zzap$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzap();
    }
}

