/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzf$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzf
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzf zzul;
    private int zzbb;
    private String zzsy;
    private String zzui;
    private String zzuj;
    private String zzuk;

    static {
        zzge$zzf zzge$zzf;
        zzul = zzge$zzf = new zzge$zzf();
        zzcg.zza(zzge$zzf.class, zzge$zzf);
    }

    private zzge$zzf() {
        String string2;
        this.zzsy = string2 = "";
        this.zzui = string2;
        this.zzuj = string2;
        this.zzuk = string2;
    }

    public static /* synthetic */ zzge$zzf zzey() {
        return zzul;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzf>)zzgf.zzba;
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
                clazz = zzge$zzf.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzul;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzul;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzsy";
                objectArray[2] = "zzui";
                objectArray[3] = "zzuj";
                objectArray[4] = "zzuk";
                return zzcg.zza(zzul, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003", objectArray);
            }
            case 2: {
                return new zzge$zzf$zza(null);
            }
            case 1: 
        }
        return new zzge$zzf();
    }
}

