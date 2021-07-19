/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzd$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzd
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzd zztx;
    private int zzbb;
    private int zztu;
    private String zztv;
    private String zztw;

    static {
        zzge$zzd zzge$zzd;
        zztx = zzge$zzd = new zzge$zzd();
        zzcg.zza(zzge$zzd.class, zzge$zzd);
    }

    private zzge$zzd() {
        String string2;
        this.zztv = string2 = "";
        this.zztw = string2;
    }

    public static /* synthetic */ zzge$zzd zzew() {
        return zztx;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzd>)zzgf.zzba;
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
                clazz = zzge$zzd.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zztx;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zztx;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zztu";
                objectArray[2] = "zztv";
                objectArray[3] = "zztw";
                return zzcg.zza(zztx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002", objectArray);
            }
            case 2: {
                return new zzge$zzd$zza(null);
            }
            case 1: 
        }
        return new zzge$zzd();
    }
}

