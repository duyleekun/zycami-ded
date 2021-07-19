/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzt$zza;
import com.google.android.gms.internal.clearcut.zzge$zzt$zzb;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzt
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzt zzbgx;
    private int zzbb;
    private String zzbgt;
    private int zzbgu;
    private String zzbgv;
    private String zzbgw;
    private String zzsx;

    static {
        zzge$zzt zzge$zzt;
        zzbgx = zzge$zzt = new zzge$zzt();
        zzcg.zza(zzge$zzt.class, zzge$zzt);
    }

    private zzge$zzt() {
        String string2;
        this.zzbgt = string2 = "";
        this.zzbgv = string2;
        this.zzbgw = string2;
        this.zzsx = string2;
    }

    public static /* synthetic */ zzge$zzt zzfm() {
        return zzbgx;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzt>)zzgf.zzba;
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
                clazz = zzge$zzt.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbgx;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbgx;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzbgt";
                objectArray[2] = "zzbgu";
                objectArray[3] = object2 = zzge$zzt$zzb.zzd();
                objectArray[4] = "zzbgv";
                objectArray[5] = "zzbgw";
                objectArray[6] = "zzsx";
                return zzcg.zza(zzbgx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", objectArray);
            }
            case 2: {
                return new zzge$zzt$zza(null);
            }
            case 1: 
        }
        return new zzge$zzt();
    }
}

