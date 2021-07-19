/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzi$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzi
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzi zzwe;
    private int zzbb;
    private String zzso;
    private String zzsw;
    private String zzsz;
    private String zzvy;
    private String zzvz;
    private String zzwa;
    private String zzwb;
    private int zzwc;
    private int zzwd;

    static {
        zzge$zzi zzge$zzi;
        zzwe = zzge$zzi = new zzge$zzi();
        zzcg.zza(zzge$zzi.class, zzge$zzi);
    }

    private zzge$zzi() {
        String string2;
        this.zzvy = string2 = "";
        this.zzso = string2;
        this.zzvz = string2;
        this.zzwa = string2;
        this.zzwb = string2;
        this.zzsw = string2;
        this.zzsz = string2;
    }

    public static /* synthetic */ zzge$zzi zzfb() {
        return zzwe;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzi>)zzgf.zzba;
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
                clazz = zzge$zzi.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzwe;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzwe;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzvy";
                objectArray[2] = "zzso";
                objectArray[3] = "zzvz";
                objectArray[4] = "zzwa";
                objectArray[5] = "zzwb";
                objectArray[6] = "zzsw";
                objectArray[7] = "zzsz";
                objectArray[8] = "zzwc";
                objectArray[9] = "zzwd";
                return zzcg.zza(zzwe, "\u0001\t\u0000\u0001\u0001\t\t\n\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0004\u0007\t\u0004\b", objectArray);
            }
            case 2: {
                return new zzge$zzi$zza(null);
            }
            case 1: 
        }
        return new zzge$zzi();
    }
}

