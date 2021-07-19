/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzg$zza;
import com.google.android.gms.internal.vision.zzfl$zzg$zzb;
import com.google.android.gms.internal.vision.zzfl$zzg$zzc;
import com.google.android.gms.internal.vision.zzfl$zzg$zzd;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzg
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzg zzpv;
    private int zzbm;
    private float zzkp;
    private boolean zzkt;
    private int zzpr;
    private int zzps;
    private int zzpt;
    private boolean zzpu;

    static {
        zzfl$zzg zzfl$zzg;
        zzpv = zzfl$zzg = new zzfl$zzg();
        zzid.zza(zzfl$zzg.class, zzfl$zzg);
    }

    private zzfl$zzg() {
    }

    private final void zza(zzfl$zzg$zza zzfl$zzg$zza) {
        int n10;
        this.zzpt = n10 = zzfl$zzg$zza.zzak();
        this.zzbm = n10 = this.zzbm | 4;
    }

    private final void zza(zzfl$zzg$zzc zzfl$zzg$zzc) {
        int n10;
        this.zzps = n10 = zzfl$zzg$zzc.zzak();
        this.zzbm = n10 = this.zzbm | 2;
    }

    private final void zza(zzfl$zzg$zzd zzfl$zzg$zzd) {
        int n10;
        this.zzpr = n10 = zzfl$zzg$zzd.zzak();
        this.zzbm = n10 = this.zzbm | 1;
    }

    public static /* synthetic */ void zza(zzfl$zzg zzfl$zzg, float f10) {
        zzfl$zzg.zzd(f10);
    }

    public static /* synthetic */ void zza(zzfl$zzg zzfl$zzg, zzfl$zzg$zza zzfl$zzg$zza) {
        zzfl$zzg.zza(zzfl$zzg$zza);
    }

    public static /* synthetic */ void zza(zzfl$zzg zzfl$zzg, zzfl$zzg$zzc zzfl$zzg$zzc) {
        zzfl$zzg.zza(zzfl$zzg$zzc);
    }

    public static /* synthetic */ void zza(zzfl$zzg zzfl$zzg, zzfl$zzg$zzd zzfl$zzg$zzd) {
        zzfl$zzg.zza(zzfl$zzg$zzd);
    }

    public static /* synthetic */ void zza(zzfl$zzg zzfl$zzg, boolean bl2) {
        zzfl$zzg.zza(bl2);
    }

    private final void zza(boolean bl2) {
        int n10;
        this.zzbm = n10 = this.zzbm | 8;
        this.zzkt = bl2;
    }

    public static /* synthetic */ void zzb(zzfl$zzg zzfl$zzg, boolean bl2) {
        zzfl$zzg.zzg(bl2);
    }

    private final void zzd(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x20;
        this.zzkp = f10;
    }

    public static zzfl$zzg$zzb zzdm() {
        return (zzfl$zzg$zzb)zzpv.zzgy();
    }

    public static /* synthetic */ zzfl$zzg zzdn() {
        return zzpv;
    }

    private final void zzg(boolean bl2) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x10;
        this.zzpu = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzg>)zzfk.zzbl;
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
                clazz = zzfl$zzg.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzpv;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzpv;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzpr";
                objectArray[2] = object2 = zzfl$zzg$zzd.zzal();
                objectArray[3] = "zzps";
                objectArray[4] = object2 = zzfl$zzg$zzc.zzal();
                objectArray[5] = "zzpt";
                objectArray[6] = object2 = zzfl$zzg$zza.zzal();
                objectArray[7] = "zzkt";
                objectArray[8] = "zzpu";
                objectArray[9] = "zzkp";
                return zzid.zza((zzjn)zzpv, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u1007\u0003\u0005\u1007\u0004\u0006\u1001\u0005", objectArray);
            }
            case 2: {
                return new zzfl$zzg$zzb(null);
            }
            case 1: 
        }
        return new zzfl$zzg();
    }
}

