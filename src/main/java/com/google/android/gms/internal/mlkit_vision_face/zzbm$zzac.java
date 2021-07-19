/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzac$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzac
extends zzgd
implements zzhn {
    private static final zzbm$zzac zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private float zzi;

    static {
        zzbm$zzac zzbm$zzac;
        zzj = zzbm$zzac = new zzbm$zzac();
        zzgd.zza(zzbm$zzac.class, zzbm$zzac);
    }

    private zzbm$zzac() {
    }

    public static zzbm$zzac$zzb zza() {
        return (zzbm$zzac$zzb)zzj.zzh();
    }

    private final void zza(float f10) {
        int n10;
        this.zzc = n10 = this.zzc | 0x20;
        this.zzi = f10;
    }

    private final void zza(zzbm$zzac$zza zzbm$zzac$zza) {
        int n10;
        this.zze = n10 = zzbm$zzac$zza.zza();
        this.zzc = n10 = this.zzc | 2;
    }

    private final void zza(zzbm$zzac$zzc zzbm$zzac$zzc) {
        int n10;
        this.zzg = n10 = zzbm$zzac$zzc.zza();
        this.zzc = n10 = this.zzc | 8;
    }

    private final void zza(zzbm$zzac$zzd zzbm$zzac$zzd) {
        int n10;
        this.zzd = n10 = zzbm$zzac$zzd.zza();
        this.zzc = n10 = this.zzc | 1;
    }

    private final void zza(zzbm$zzac$zze zzbm$zzac$zze) {
        int n10;
        this.zzf = n10 = zzbm$zzac$zze.zza();
        this.zzc = n10 = this.zzc | 4;
    }

    public static /* synthetic */ void zza(zzbm$zzac zzbm$zzac, float f10) {
        zzbm$zzac.zza(f10);
    }

    public static /* synthetic */ void zza(zzbm$zzac zzbm$zzac, zzbm$zzac$zza zzbm$zzac$zza) {
        zzbm$zzac.zza(zzbm$zzac$zza);
    }

    public static /* synthetic */ void zza(zzbm$zzac zzbm$zzac, zzbm$zzac$zzc zzbm$zzac$zzc) {
        zzbm$zzac.zza(zzbm$zzac$zzc);
    }

    public static /* synthetic */ void zza(zzbm$zzac zzbm$zzac, zzbm$zzac$zzd zzbm$zzac$zzd) {
        zzbm$zzac.zza(zzbm$zzac$zzd);
    }

    public static /* synthetic */ void zza(zzbm$zzac zzbm$zzac, zzbm$zzac$zze zzbm$zzac$zze) {
        zzbm$zzac.zza(zzbm$zzac$zze);
    }

    public static /* synthetic */ void zza(zzbm$zzac zzbm$zzac, boolean bl2) {
        zzbm$zzac.zza(bl2);
    }

    private final void zza(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 0x10;
        this.zzh = bl2;
    }

    public static /* synthetic */ zzbm$zzac zzb() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzac>)zzbo.zza;
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
                clazz = zzbm$zzac.class;
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
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbm$zzac$zzd.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzbm$zzac$zza.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = object2 = zzbm$zzac$zze.zzb();
                objectArray[7] = "zzg";
                objectArray[8] = object2 = zzbm$zzac$zzc.zzb();
                objectArray[9] = "zzh";
                objectArray[10] = "zzi";
                return zzgd.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u100c\u0003\u0005\u1007\u0004\u0006\u1001\u0005", objectArray);
            }
            case 2: {
                return new zzbm$zzac$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzac();
    }
}

