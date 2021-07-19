/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzq$zzb;
import com.google.android.gms.internal.clearcut.zzge$zzv$zza;
import com.google.android.gms.internal.clearcut.zzge$zzv$zzb;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzv
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzv zzbhj;
    private int zzbb;
    private int zzzg = -1;
    private String zzzh = "";
    private int zzzm;

    static {
        zzge$zzv zzge$zzv;
        zzbhj = zzge$zzv = new zzge$zzv();
        zzcg.zza(zzge$zzv.class, zzge$zzv);
    }

    private zzge$zzv() {
    }

    public static /* synthetic */ zzge$zzv zzfo() {
        return zzbhj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzv>)zzgf.zzba;
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
                clazz = zzge$zzv.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbhj;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbhj;
            }
            case 3: {
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzzh";
                objectArray[2] = "zzzm";
                objectArray[3] = object2 = zzge$zzv$zzb.zzd();
                objectArray[4] = "zzzg";
                objectArray[5] = object2 = zzge$zzq$zzb.zzd();
                return zzcg.zza(zzbhj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\f\u0002", objectArray);
            }
            case 2: {
                return new zzge$zzv$zza(null);
            }
            case 1: 
        }
        return new zzge$zzv();
    }
}

