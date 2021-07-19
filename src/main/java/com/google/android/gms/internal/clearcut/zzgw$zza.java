/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzgw$zza$zza;
import com.google.android.gms.internal.clearcut.zzgw$zza$zzb;
import com.google.android.gms.internal.clearcut.zzgx;
import java.util.List;

public final class zzgw$zza
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzgw$zza zzbir;
    private zzcn zzbiq;

    static {
        zzgw$zza zzgw$zza;
        zzbir = zzgw$zza = new zzgw$zza();
        zzcg.zza(zzgw$zza.class, zzgw$zza);
    }

    private zzgw$zza() {
        zzcn zzcn2;
        this.zzbiq = zzcn2 = zzcg.zzbb();
    }

    public static zzgw$zza zzft() {
        return zzbir;
    }

    public static /* synthetic */ zzgw$zza zzfu() {
        return zzbir;
    }

    public static zzgw$zza zzi(byte[] byArray) {
        return (zzgw$zza)zzcg.zzb(zzbir, byArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzgw$zza>)zzgx.zzba;
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
                clazz = zzgw$zza.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbir;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbir;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzbiq";
                objectArray[by2] = zzgw$zza$zzb.class;
                return zzcg.zza(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new zzgw$zza$zza(null);
            }
            case 1: 
        }
        return new zzgw$zza();
    }

    public final List zzfs() {
        return this.zzbiq;
    }
}

