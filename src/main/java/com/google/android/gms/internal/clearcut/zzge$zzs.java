/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzs$zza;
import com.google.android.gms.internal.clearcut.zzge$zzs$zzb;
import com.google.android.gms.internal.clearcut.zzge$zzs$zzc;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzs
extends zzcg
implements zzdq {
    private static final zzge$zzs zzbfc;
    private static volatile zzdz zzbg;
    private int zzbb;
    private int zzbfa = -1;
    private int zzbfb;

    static {
        zzge$zzs zzge$zzs;
        zzbfc = zzge$zzs = new zzge$zzs();
        zzcg.zza(zzge$zzs.class, zzge$zzs);
    }

    private zzge$zzs() {
    }

    public static /* synthetic */ zzge$zzs zzfl() {
        return zzbfc;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzs>)zzgf.zzba;
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
                clazz = zzge$zzs.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbfc;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbfc;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzbfa";
                objectArray[2] = object2 = zzge$zzs$zzc.zzd();
                objectArray[3] = "zzbfb";
                objectArray[4] = object2 = zzge$zzs$zzb.zzd();
                return zzcg.zza(zzbfc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", objectArray);
            }
            case 2: {
                return new zzge$zzs$zza(null);
            }
            case 1: 
        }
        return new zzge$zzs();
    }
}

