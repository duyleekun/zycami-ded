/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzc$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzc
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzc zztt;
    private int zzbb;
    private boolean zztr;
    private boolean zzts;

    static {
        zzge$zzc zzge$zzc;
        zztt = zzge$zzc = new zzge$zzc();
        zzcg.zza(zzge$zzc.class, zzge$zzc);
    }

    private zzge$zzc() {
    }

    public static /* synthetic */ zzge$zzc zzev() {
        return zztt;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzc>)zzgf.zzba;
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
                clazz = zzge$zzc.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zztt;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zztt;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zztr";
                objectArray[2] = "zzts";
                return zzcg.zza(zztt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001", objectArray);
            }
            case 2: {
                return new zzge$zzc$zza(null);
            }
            case 1: 
        }
        return new zzge$zzc();
    }
}

