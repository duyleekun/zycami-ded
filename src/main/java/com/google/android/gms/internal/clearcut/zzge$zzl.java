/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzl$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzl
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzl zzww;
    private int zzbb;
    private long zzwt;
    private long zzwu;
    private String zzwv = "";

    static {
        zzge$zzl zzge$zzl;
        zzww = zzge$zzl = new zzge$zzl();
        zzcg.zza(zzge$zzl.class, zzge$zzl);
    }

    private zzge$zzl() {
    }

    public static /* synthetic */ zzge$zzl zzfe() {
        return zzww;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzl>)zzgf.zzba;
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
                clazz = zzge$zzl.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzww;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzww;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzwt";
                objectArray[2] = "zzwu";
                objectArray[3] = "zzwv";
                return zzcg.zza(zzww, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\b\u0002", objectArray);
            }
            case 2: {
                return new zzge$zzl$zza(null);
            }
            case 1: 
        }
        return new zzge$zzl();
    }
}

