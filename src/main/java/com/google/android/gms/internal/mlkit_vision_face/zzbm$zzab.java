/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzab$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzab
extends zzgd
implements zzhn {
    private static final zzbm$zzab zzj;
    private static volatile zzhv zzk;
    private int zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzbm$zzab zzbm$zzab;
        zzj = zzbm$zzab = new zzbm$zzab();
        zzgd.zza(zzbm$zzab.class, zzbm$zzab);
    }

    private zzbm$zzab() {
    }

    public static zzbm$zzab$zza zza() {
        return (zzbm$zzab$zza)zzj.zzh();
    }

    private final void zza(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 1;
        this.zzd = l10;
    }

    public static /* synthetic */ void zza(zzbm$zzab zzbm$zzab, long l10) {
        zzbm$zzab.zza(l10);
    }

    public static /* synthetic */ zzbm$zzab zzb() {
        return zzj;
    }

    private final void zzb(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 2;
        this.zze = l10;
    }

    public static /* synthetic */ void zzb(zzbm$zzab zzbm$zzab, long l10) {
        zzbm$zzab.zzb(l10);
    }

    private final void zzc(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 4;
        this.zzf = l10;
    }

    public static /* synthetic */ void zzc(zzbm$zzab zzbm$zzab, long l10) {
        zzbm$zzab.zzc(l10);
    }

    private final void zzd(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 8;
        this.zzg = l10;
    }

    public static /* synthetic */ void zzd(zzbm$zzab zzbm$zzab, long l10) {
        zzbm$zzab.zzd(l10);
    }

    private final void zze(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 0x10;
        this.zzh = l10;
    }

    public static /* synthetic */ void zze(zzbm$zzab zzbm$zzab, long l10) {
        zzbm$zzab.zze(l10);
    }

    private final void zzf(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 0x20;
        this.zzi = l10;
    }

    public static /* synthetic */ void zzf(zzbm$zzab zzbm$zzab, long l10) {
        zzbm$zzab.zzf(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzab>)zzbo.zza;
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
                clazz = zzbm$zzab.class;
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
                return zzgd.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1003\u0000\u0002\u1003\u0001\u0003\u1003\u0002\u0004\u1003\u0003\u0005\u1003\u0004\u0006\u1003\u0005", objectArray);
            }
            case 2: {
                return new zzbm$zzab$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzab();
    }
}

