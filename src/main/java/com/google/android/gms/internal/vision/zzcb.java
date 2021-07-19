/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzbw;
import com.google.android.gms.internal.vision.zzca;
import com.google.android.gms.internal.vision.zzcb$zza;
import com.google.android.gms.internal.vision.zzcc;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzcb
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzcb zzib;
    private int zzbm;
    private int zzhu;
    private int zzhv;
    private int zzhw;
    private int zzhx;
    private boolean zzhy;
    private long zzhz;
    private String zzia = "";

    static {
        zzcb zzcb2;
        zzib = zzcb2 = new zzcb();
        zzid.zza(zzcb.class, zzcb2);
    }

    private zzcb() {
    }

    private final void setHeight(int n10) {
        int n11;
        this.zzbm = n11 = this.zzbm | 2;
        this.zzhv = n10;
    }

    private final void setWidth(int n10) {
        int n11;
        this.zzbm = n11 = this.zzbm | 1;
        this.zzhu = n10;
    }

    private final void zza(zzbw zzbw2) {
        int n10;
        this.zzhw = n10 = zzbw2.zzak();
        this.zzbm = n10 = this.zzbm | 4;
    }

    public static /* synthetic */ void zza(zzcb zzcb2, int n10) {
        zzcb2.setWidth(n10);
    }

    public static /* synthetic */ void zza(zzcb zzcb2, long l10) {
        zzcb2.zzb(l10);
    }

    public static /* synthetic */ void zza(zzcb zzcb2, zzbw zzbw2) {
        zzcb2.zza(zzbw2);
    }

    public static /* synthetic */ void zza(zzcb zzcb2, zzcc zzcc2) {
        zzcb2.zza(zzcc2);
    }

    private final void zza(zzcc zzcc2) {
        int n10;
        this.zzhx = n10 = zzcc2.zzak();
        this.zzbm = n10 = this.zzbm | 8;
    }

    public static zzcb$zza zzam() {
        return (zzcb$zza)zzib.zzgy();
    }

    public static /* synthetic */ zzcb zzan() {
        return zzib;
    }

    private final void zzb(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x20;
        this.zzhz = l10;
    }

    public static /* synthetic */ void zzb(zzcb zzcb2, int n10) {
        zzcb2.setHeight(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzcb>)zzca.zzbl;
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
                clazz = zzcb.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzib;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzib;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzhu";
                objectArray[2] = "zzhv";
                objectArray[3] = "zzhw";
                objectArray[4] = object2 = zzbw.zzal();
                objectArray[5] = "zzhx";
                objectArray[6] = object2 = zzcc.zzal();
                objectArray[7] = "zzhy";
                objectArray[8] = "zzhz";
                objectArray[9] = "zzia";
                return zzid.zza((zzjn)zzib, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001\u0003\u100c\u0002\u0004\u100c\u0003\u0005\u1007\u0004\u0006\u1002\u0005\u0007\u1008\u0006", objectArray);
            }
            case 2: {
                return new zzcb$zza(null);
            }
            case 1: 
        }
        return new zzcb();
    }
}

