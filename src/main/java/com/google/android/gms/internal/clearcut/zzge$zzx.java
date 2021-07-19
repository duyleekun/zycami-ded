/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzx$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzx
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzx zzbik;
    private int zzbb;
    private String zzbie;
    private String zzbif;
    private String zzbig;
    private String zzbih;
    private String zzbii;
    private String zzbij;
    private String zztz;

    static {
        zzge$zzx zzge$zzx;
        zzbik = zzge$zzx = new zzge$zzx();
        zzcg.zza(zzge$zzx.class, zzge$zzx);
    }

    private zzge$zzx() {
        String string2;
        this.zztz = string2 = "";
        this.zzbie = string2;
        this.zzbif = string2;
        this.zzbig = string2;
        this.zzbih = string2;
        this.zzbii = string2;
        this.zzbij = string2;
    }

    public static /* synthetic */ zzge$zzx zzfq() {
        return zzbik;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzx>)zzgf.zzba;
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
                clazz = zzge$zzx.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbik;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbik;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zztz";
                objectArray[2] = "zzbie";
                objectArray[3] = "zzbif";
                objectArray[4] = "zzbig";
                objectArray[5] = "zzbih";
                objectArray[6] = "zzbii";
                objectArray[7] = "zzbij";
                return zzcg.zza(zzbik, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006", objectArray);
            }
            case 2: {
                return new zzge$zzx$zza(null);
            }
            case 1: 
        }
        return new zzge$zzx();
    }
}

