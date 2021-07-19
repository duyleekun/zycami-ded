/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzaf$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzbf;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzbx;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzaf
extends zzgd
implements zzhn {
    private static final zzbm$zzaf zzl;
    private static volatile zzhv zzm;
    private int zzc;
    private long zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private zzgm zzk;

    static {
        zzbm$zzaf zzbm$zzaf;
        zzl = zzbm$zzaf = new zzbm$zzaf();
        zzgd.zza(zzbm$zzaf.class, zzbm$zzaf);
    }

    private zzbm$zzaf() {
        zzgm zzgm2;
        this.zzk = zzgm2 = zzgd.zzl();
    }

    public static zzbm$zzaf$zza zza() {
        return (zzbm$zzaf$zza)zzl.zzh();
    }

    private final void zza(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 1;
        this.zzd = l10;
    }

    public static /* synthetic */ void zza(zzbm$zzaf zzbm$zzaf, long l10) {
        zzbm$zzaf.zza(l10);
    }

    public static /* synthetic */ void zza(zzbm$zzaf zzbm$zzaf, zzbx zzbx2) {
        zzbm$zzaf.zza(zzbx2);
    }

    public static /* synthetic */ void zza(zzbm$zzaf zzbm$zzaf, boolean bl2) {
        zzbm$zzaf.zza(bl2);
    }

    private final void zza(zzbx zzbx2) {
        int n10;
        this.zze = n10 = zzbx2.zza();
        this.zzc = n10 = this.zzc | 2;
    }

    private final void zza(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 4;
        this.zzf = bl2;
    }

    public static /* synthetic */ zzbm$zzaf zzb() {
        return zzl;
    }

    public static /* synthetic */ void zzb(zzbm$zzaf zzbm$zzaf, boolean bl2) {
        zzbm$zzaf.zzb(true);
    }

    private final void zzb(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 8;
        this.zzg = true;
    }

    public static /* synthetic */ void zzc(zzbm$zzaf zzbm$zzaf, boolean bl2) {
        zzbm$zzaf.zzc(true);
    }

    private final void zzc(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 0x10;
        this.zzh = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzaf>)zzbo.zza;
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
                clazz = zzbm$zzaf.class;
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
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzbx.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = "zzj";
                objectArray[9] = "zzk";
                objectArray[10] = zzbm.zzbf.class;
                return zzgd.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u1003\u0000\u0002\u100c\u0001\u0003\u1007\u0002\u0004\u1007\u0003\u0005\u1007\u0004\u0006\u1007\u0005\u0007\u100b\u0006\b\u001b", objectArray);
            }
            case 2: {
                return new zzbm$zzaf$zza(null);
            }
            case 1: 
        }
        return new zzbm$zzaf();
    }
}

