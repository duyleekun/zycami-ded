/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzgt$zza$zza;
import com.google.android.gms.internal.clearcut.zzgu;

public final class zzgt$zza
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzgt$zza zzbil;

    static {
        zzgt$zza zzgt$zza;
        zzbil = zzgt$zza = new zzgt$zza();
        zzcg.zza(zzgt$zza.class, zzgt$zza);
    }

    private zzgt$zza() {
    }

    public static /* synthetic */ zzgt$zza zzfr() {
        return zzbil;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzgt$zza>)zzgu.zzba;
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
                clazz = zzgt$zza.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbil;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbil;
            }
            case 3: {
                return zzcg.zza(zzbil, "\u0001\u0000", null);
            }
            case 2: {
                return new zzgt$zza$zza(null);
            }
            case 1: 
        }
        return new zzgt$zza();
    }
}

