/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzm$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzm
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzm zzxa;
    private int zzbb;
    private String zzso;
    private String zzsr;
    private String zzsw;
    private String zzsz;
    private String zzvy;
    private String zzwa;
    private String zzwb;
    private int zzwc;
    private int zzwd;
    private String zzwx;
    private String zzwy;
    private String zzwz;

    static {
        zzge$zzm zzge$zzm;
        zzxa = zzge$zzm = new zzge$zzm();
        zzcg.zza(zzge$zzm.class, zzge$zzm);
    }

    private zzge$zzm() {
        String string2;
        this.zzvy = string2 = "";
        this.zzso = string2;
        this.zzwa = string2;
        this.zzwb = string2;
        this.zzsw = string2;
        this.zzwx = string2;
        this.zzsz = string2;
        this.zzsr = string2;
        this.zzwy = string2;
        this.zzwz = string2;
    }

    public static /* synthetic */ zzge$zzm zzff() {
        return zzxa;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzm>)zzgf.zzba;
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
                clazz = zzge$zzm.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzxa;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzxa;
            }
            case 3: {
                Object[] objectArray = new Object[13];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzvy";
                objectArray[2] = "zzso";
                objectArray[3] = "zzwa";
                objectArray[4] = "zzwb";
                objectArray[5] = "zzsw";
                objectArray[6] = "zzsz";
                objectArray[7] = "zzsr";
                objectArray[8] = "zzwy";
                objectArray[9] = "zzwc";
                objectArray[10] = "zzwd";
                objectArray[11] = "zzwz";
                objectArray[12] = "zzwx";
                return zzcg.zza(zzxa, "\u0001\f\u0000\u0001\u0001\f\f\r\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0006\u0007\b\u0007\b\b\b\t\u0004\t\n\u0004\n\u000b\b\u000b\f\b\u0005", objectArray);
            }
            case 2: {
                return new zzge$zzm$zza(null);
            }
            case 1: 
        }
        return new zzge$zzm();
    }
}

