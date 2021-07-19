/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zze$zza;
import com.google.android.gms.internal.clearcut.zzge$zze$zzb;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zze
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zze zzub;
    private int zzbb;
    private int zzty;
    private String zztz;
    private String zzua;

    static {
        zzge$zze zzge$zze;
        zzub = zzge$zze = new zzge$zze();
        zzcg.zza(zzge$zze.class, zzge$zze);
    }

    private zzge$zze() {
        String string2;
        this.zztz = string2 = "";
        this.zzua = string2;
    }

    public static /* synthetic */ zzge$zze zzex() {
        return zzub;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zze>)zzgf.zzba;
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
                clazz = zzge$zze.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzub;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzub;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzty";
                objectArray[2] = object2 = zzge$zze$zzb.zzd();
                objectArray[3] = "zztz";
                objectArray[4] = "zzua";
                return zzcg.zza(zzub, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002", objectArray);
            }
            case 2: {
                return new zzge$zze$zza(null);
            }
            case 1: 
        }
        return new zzge$zze();
    }
}

