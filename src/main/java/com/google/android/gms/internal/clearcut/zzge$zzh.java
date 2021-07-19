/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzh$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzh
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzh zzvx;
    private int zzbb;
    private long zzvu;
    private long zzvv;
    private boolean zzvw;

    static {
        zzge$zzh zzge$zzh;
        zzvx = zzge$zzh = new zzge$zzh();
        zzcg.zza(zzge$zzh.class, zzge$zzh);
    }

    private zzge$zzh() {
    }

    public static /* synthetic */ zzge$zzh zzfa() {
        return zzvx;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzh>)zzgf.zzba;
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
                clazz = zzge$zzh.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzvx;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzvx;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzvv";
                objectArray[2] = "zzvw";
                objectArray[3] = "zzvu";
                return zzcg.zza(zzvx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0002\u0001\u0002\u0007\u0002\u0003\u0002\u0000", objectArray);
            }
            case 2: {
                return new zzge$zzh$zza(null);
            }
            case 1: 
        }
        return new zzge$zzh();
    }
}

