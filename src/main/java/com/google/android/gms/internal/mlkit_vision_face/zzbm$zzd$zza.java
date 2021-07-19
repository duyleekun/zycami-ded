/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzae;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzd$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzd$zza
extends zzgd
implements zzhn {
    private static final zzbm$zzd$zza zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private int zzd;
    private boolean zze;
    private zzbm$zzae zzf;
    private zzbm$zzac zzg;
    private int zzh;
    private int zzi;

    static {
        zzbm$zzd$zza zzbm$zzd$zza;
        zzj = zzbm$zzd$zza = new zzbm$zzd$zza();
        zzgd.zza(zzbm$zzd$zza.class, zzbm$zzd$zza);
    }

    private zzbm$zzd$zza() {
    }

    public static zzbm$zzd$zza$zza zza() {
        return (zzbm$zzd$zza$zza)zzj.zzh();
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

    public static /* synthetic */ void zza(zzbm$zzd$zza zzbm$zzd$zza, int n10) {
        zzbm$zzd$zza.zzb(n10);
    }

    public static /* synthetic */ void zza(zzbm$zzd$zza zzbm$zzd$zza, zzbm$zzac zzbm$zzac) {
        zzbm$zzd$zza.zza(zzbm$zzac);
    }

    public static /* synthetic */ void zza(zzbm$zzd$zza zzbm$zzd$zza, zzbm$zzae zzbm$zzae) {
        zzbm$zzd$zza.zza(zzbm$zzae);
    }

    public static /* synthetic */ void zza(zzbm$zzd$zza zzbm$zzd$zza, zzbx zzbx2) {
        zzbm$zzd$zza.zza(zzbx2);
    }

    public static /* synthetic */ void zza(zzbm$zzd$zza zzbm$zzd$zza, boolean bl2) {
        zzbm$zzd$zza.zza(bl2);
    }

    private final void zza(zzbx zzbx2) {
        int n10;
        this.zzd = n10 = zzbx2.zza();
        this.zzc = n10 = this.zzc | 1;
    }

    private final void zza(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 2;
        this.zze = bl2;
    }

    public static /* synthetic */ zzbm$zzd$zza zzb() {
        return zzj;
    }

    private final void zzb(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 0x10;
        this.zzh = n10;
    }

    public static /* synthetic */ void zzb(zzbm$zzd$zza zzbm$zzd$zza, int n10) {
        zzbm$zzd$zza.zzc(n10);
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
        clazz = (Class<zzbm$zzd$zza>)zzbo.zza;
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
                clazz = zzbm$zzd$zza.class;
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
                objectArray[2] = object2 = zzbx.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                return zzgd.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1009\u0002\u0004\u1009\u0003\u0005\u100b\u0004\u0006\u100b\u0005", objectArray);
            }
            case 2: {
                return new zzbm$zzd$zza$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzd$zza();
    }
}

