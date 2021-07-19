/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzr$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzr
extends zzcg
implements zzdq {
    private static final zzge$zzr zzbez;
    private static volatile zzdz zzbg;
    private int zzbb;
    private String zzsw;
    private String zzsz;
    private String zzwa;
    private String zzwb;
    private int zzwc;
    private int zzwd;
    private String zzwz;

    static {
        zzge$zzr zzge$zzr;
        zzbez = zzge$zzr = new zzge$zzr();
        zzcg.zza(zzge$zzr.class, zzge$zzr);
    }

    private zzge$zzr() {
        String string2;
        this.zzwa = string2 = "";
        this.zzwb = string2;
        this.zzsw = string2;
        this.zzsz = string2;
        this.zzwz = string2;
    }

    public static /* synthetic */ zzge$zzr zzfk() {
        return zzbez;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzr>)zzgf.zzba;
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
                clazz = zzge$zzr.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbez;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbez;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzwa";
                objectArray[2] = "zzwb";
                objectArray[3] = "zzsw";
                objectArray[4] = "zzsz";
                objectArray[5] = "zzwc";
                objectArray[6] = "zzwd";
                objectArray[7] = "zzwz";
                return zzcg.zza(zzbez, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\b\u0006", objectArray);
            }
            case 2: {
                return new zzge$zzr$zza(null);
            }
            case 1: 
        }
        return new zzge$zzr();
    }
}

