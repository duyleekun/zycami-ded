/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zza;
import com.google.android.gms.internal.vision.zzci$zzd$zza;
import com.google.android.gms.internal.vision.zzci$zze;
import com.google.android.gms.internal.vision.zzci$zzf;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzck;
import com.google.android.gms.internal.vision.zzcp;
import com.google.android.gms.internal.vision.zzct;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzci$zzd
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zzd zzlb;
    private int zzbm;
    private float zzkp = 0.1f;
    private int zzkq;
    private int zzkr;
    private int zzks;
    private boolean zzkt;
    private boolean zzku;
    private float zzkv;
    private float zzkw;
    private boolean zzkx;
    private zzci$zze zzky;
    private zzci$zza zzkz;
    private zzci$zzf zzla;

    static {
        zzci$zzd zzci$zzd;
        zzlb = zzci$zzd = new zzci$zzd();
        zzid.zza(zzci$zzd.class, zzci$zzd);
    }

    private zzci$zzd() {
        int n10;
        this.zzkq = n10 = 1;
        this.zzkr = n10;
        this.zzks = n10;
        this.zzkv = 45.0f;
        this.zzkw = 0.5f;
    }

    private final void zza(zzci$zza zzci$zza) {
        int n10;
        zzci$zza.getClass();
        this.zzkz = zzci$zza;
        this.zzbm = n10 = this.zzbm | 0x400;
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, float f10) {
        zzci$zzd.zzd(f10);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, zzci$zza zzci$zza) {
        zzci$zzd.zza(zzci$zza);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, zzci$zze zzci$zze) {
        zzci$zzd.zza(zzci$zze);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, zzci$zzf zzci$zzf) {
        zzci$zzd.zza(zzci$zzf);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, zzck zzck2) {
        zzci$zzd.zza(zzck2);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, zzcp zzcp2) {
        zzci$zzd.zza(zzcp2);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, zzct zzct2) {
        zzci$zzd.zza(zzct2);
    }

    public static /* synthetic */ void zza(zzci$zzd zzci$zzd, boolean bl2) {
        zzci$zzd.zza(bl2);
    }

    private final void zza(zzci$zze zzci$zze) {
        int n10;
        zzci$zze.getClass();
        this.zzky = zzci$zze;
        this.zzbm = n10 = this.zzbm | 0x200;
    }

    private final void zza(zzci$zzf zzci$zzf) {
        int n10;
        zzci$zzf.getClass();
        this.zzla = zzci$zzf;
        this.zzbm = n10 = this.zzbm | 0x800;
    }

    private final void zza(zzck zzck2) {
        int n10;
        this.zzkr = n10 = zzck2.zzak();
        this.zzbm = n10 = this.zzbm | 4;
    }

    private final void zza(zzcp zzcp2) {
        int n10;
        this.zzkq = n10 = zzcp2.zzak();
        this.zzbm = n10 = this.zzbm | 2;
    }

    private final void zza(zzct zzct2) {
        int n10;
        this.zzks = n10 = zzct2.zzak();
        this.zzbm = n10 = this.zzbm | 8;
    }

    private final void zza(boolean bl2) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x10;
        this.zzkt = bl2;
    }

    public static /* synthetic */ void zzb(zzci$zzd zzci$zzd, boolean bl2) {
        zzci$zzd.zzb(bl2);
    }

    private final void zzb(boolean bl2) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x20;
        this.zzku = bl2;
    }

    public static zzci$zzd$zza zzbt() {
        return (zzci$zzd$zza)zzlb.zzgy();
    }

    public static /* synthetic */ zzci$zzd zzbu() {
        return zzlb;
    }

    public static /* synthetic */ void zzc(zzci$zzd zzci$zzd, boolean bl2) {
        zzci$zzd.zzc(true);
    }

    private final void zzc(boolean bl2) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x100;
        this.zzkx = true;
    }

    private final void zzd(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 1;
        this.zzkp = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zzd>)zzcj.zzbl;
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
                Object object3 = zzbk;
                if (object3 != null) return object3;
                clazz = zzci$zzd.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzlb;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzlb;
            }
            case 3: {
                Object[] objectArray = new Object[16];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzkp";
                objectArray[2] = "zzkq";
                objectArray[3] = object2 = zzcp.zzal();
                objectArray[4] = "zzkr";
                objectArray[5] = object2 = zzck.zzal();
                objectArray[6] = "zzks";
                objectArray[7] = object2 = zzct.zzal();
                objectArray[8] = "zzkt";
                objectArray[9] = "zzku";
                objectArray[10] = "zzkv";
                objectArray[11] = "zzkw";
                objectArray[12] = "zzkx";
                objectArray[13] = "zzky";
                objectArray[14] = "zzkz";
                objectArray[15] = "zzla";
                return zzid.zza((zzjn)zzlb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\u1001\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u100c\u0003\u0005\u1007\u0004\u0006\u1007\u0005\u0007\u1001\u0006\b\u1001\u0007\t\u1007\b\n\u1009\t\u000b\u1009\n\f\u1009\u000b", objectArray);
            }
            case 2: {
                return new zzci$zzd$zza(null);
            }
            case 1: 
        }
        return new zzci$zzd();
    }

    public final zzcp zzbr() {
        int n10 = this.zzkq;
        zzcp zzcp2 = zzcp.zzq(n10);
        if (zzcp2 == null) {
            zzcp2 = zzcp.zzlh;
        }
        return zzcp2;
    }

    public final zzck zzbs() {
        int n10 = this.zzkr;
        zzck zzck2 = zzck.zzo(n10);
        if (zzck2 == null) {
            zzck2 = zzck.zzjl;
        }
        return zzck2;
    }
}

