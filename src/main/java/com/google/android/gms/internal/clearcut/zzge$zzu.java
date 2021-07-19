/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzu$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzu
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzu zzbhi;
    private int zzbb;
    private String zzbhg;
    private String zzbhh;
    private String zzso;
    private String zzsr;
    private String zzsw;
    private String zzsz;
    private String zzvy;

    static {
        zzge$zzu zzge$zzu;
        zzbhi = zzge$zzu = new zzge$zzu();
        zzcg.zza(zzge$zzu.class, zzge$zzu);
    }

    private zzge$zzu() {
        String string2;
        this.zzvy = string2 = "";
        this.zzso = string2;
        this.zzbhg = string2;
        this.zzsr = string2;
        this.zzsw = string2;
        this.zzbhh = string2;
        this.zzsz = string2;
    }

    public static /* synthetic */ zzge$zzu zzfn() {
        return zzbhi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzu>)zzgf.zzba;
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
                clazz = zzge$zzu.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbhi;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbhi;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzvy";
                objectArray[2] = "zzbhg";
                objectArray[3] = "zzsr";
                objectArray[4] = "zzsw";
                objectArray[5] = "zzbhh";
                objectArray[6] = "zzso";
                objectArray[7] = "zzsz";
                return zzcg.zza(zzbhi, "\u0001\u0007\u0000\u0001\u0001\b\b\t\u0000\u0000\u0000\u0001\b\u0000\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0001\b\b\u0006", objectArray);
            }
            case 2: {
                return new zzge$zzu$zza(null);
            }
            case 1: 
        }
        return new zzge$zzu();
    }
}

