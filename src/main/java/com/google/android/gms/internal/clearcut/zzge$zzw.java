/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzw$zza;
import com.google.android.gms.internal.clearcut.zzge$zzw$zzb;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzw
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzw zzbhw;
    private int zzbb;
    private int zzbhq;
    private String zzbhr;
    private String zzbhs;
    private String zzbht;
    private String zzbhu;
    private String zzbhv;
    private String zzsr;
    private String zzsz;
    private String zzta;
    private String zzte;

    static {
        zzge$zzw zzge$zzw;
        zzbhw = zzge$zzw = new zzge$zzw();
        zzcg.zza(zzge$zzw.class, zzge$zzw);
    }

    private zzge$zzw() {
        String string2;
        this.zzbhr = string2 = "";
        this.zzte = string2;
        this.zzbhs = string2;
        this.zzta = string2;
        this.zzsr = string2;
        this.zzbht = string2;
        this.zzsz = string2;
        this.zzbhu = string2;
        this.zzbhv = string2;
    }

    public static /* synthetic */ zzge$zzw zzfp() {
        return zzbhw;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzw>)zzgf.zzba;
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
                Object object3 = zzbg;
                if (object3 != null) return object3;
                clazz = zzge$zzw.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbhw;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbhw;
            }
            case 3: {
                Object[] objectArray = new Object[12];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzbhq";
                objectArray[2] = object2 = zzge$zzw$zzb.zzd();
                objectArray[3] = "zzbhr";
                objectArray[4] = "zzte";
                objectArray[5] = "zzbhs";
                objectArray[6] = "zzta";
                objectArray[7] = "zzsr";
                objectArray[8] = "zzbht";
                objectArray[9] = "zzsz";
                objectArray[10] = "zzbhu";
                objectArray[11] = "zzbhv";
                return zzcg.zza(zzbhw, "\u0001\n\u0000\u0001\u0001\n\n\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t", objectArray);
            }
            case 2: {
                return new zzge$zzw$zza(null);
            }
            case 1: 
        }
        return new zzge$zzw();
    }
}

