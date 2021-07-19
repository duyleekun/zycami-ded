/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzn$zza;
import com.google.android.gms.internal.clearcut.zzge$zzn$zzb;
import com.google.android.gms.internal.clearcut.zzge$zzn$zzc;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzn
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzn zzxe;
    private int zzbb;
    private String zzsy;
    private String zzsz;
    private String zztz;
    private String zzvz;
    private String zzxb;
    private int zzxc;
    private int zzxd;

    static {
        zzge$zzn zzge$zzn;
        zzxe = zzge$zzn = new zzge$zzn();
        zzcg.zza(zzge$zzn.class, zzge$zzn);
    }

    private zzge$zzn() {
        String string2;
        this.zzvz = string2 = "";
        this.zzxb = string2;
        this.zzsz = string2;
        this.zzsy = string2;
        this.zztz = string2;
    }

    public static /* synthetic */ zzge$zzn zzfg() {
        return zzxe;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzn>)zzgf.zzba;
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
                clazz = zzge$zzn.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzxe;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzxe;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzvz";
                objectArray[2] = "zzxb";
                objectArray[3] = "zzxc";
                objectArray[4] = object2 = zzge$zzn$zzb.zzd();
                objectArray[5] = "zzsz";
                objectArray[6] = "zzsy";
                objectArray[7] = "zzxd";
                objectArray[8] = object2 = zzge$zzn$zzc.zzd();
                objectArray[9] = "zztz";
                return zzcg.zza(zzxe, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\b\u0003\u0005\b\u0004\u0006\f\u0005\u0007\b\u0006", objectArray);
            }
            case 2: {
                return new zzge$zzn$zza(null);
            }
            case 1: 
        }
        return new zzge$zzn();
    }
}

