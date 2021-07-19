/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzt$zza$zza;
import com.google.android.gms.internal.clearcut.zzt$zza$zzb;
import com.google.android.gms.internal.clearcut.zzt$zza$zzc;
import com.google.android.gms.internal.clearcut.zzt$zza$zzd;
import com.google.android.gms.internal.clearcut.zzu;

public final class zzt$zza
extends zzcg
implements zzdq {
    private static final zzt$zza zzbf;
    private static volatile zzdz zzbg;
    private int zzbb;
    private int zzbc;
    private int zzbd;
    private int zzbe;

    static {
        zzt$zza zzt$zza;
        zzbf = zzt$zza = new zzt$zza();
        zzcg.zza(zzt$zza.class, zzt$zza);
    }

    private zzt$zza() {
    }

    public static /* synthetic */ zzt$zza zzb() {
        return zzbf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzt$zza>)zzu.zzba;
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
                clazz = zzt$zza.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzbf;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzbf;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzbc";
                objectArray[2] = object2 = zzt$zza$zzc.zzd();
                objectArray[3] = "zzbd";
                objectArray[4] = object2 = zzt$zza$zzb.zzd();
                objectArray[5] = "zzbe";
                objectArray[6] = object2 = zzt$zza$zzd.zzd();
                return zzcg.zza(zzbf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002", objectArray);
            }
            case 2: {
                return new zzt$zza$zza(null);
            }
            case 1: 
        }
        return new zzt$zza();
    }
}

