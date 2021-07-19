/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzk$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzk
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzk zzws;
    private int zzbb;
    private zzbb zzwo;
    private String zzwp;
    private zzcn zzwq;
    private boolean zzwr;

    static {
        zzge$zzk zzge$zzk;
        zzws = zzge$zzk = new zzge$zzk();
        zzcg.zza(zzge$zzk.class, zzge$zzk);
    }

    private zzge$zzk() {
        Iterable iterable;
        this.zzwo = iterable = com.google.android.gms.internal.clearcut.zzbb.zzfi;
        this.zzwp = "";
        iterable = zzcg.zzbb();
        this.zzwq = iterable;
    }

    public static /* synthetic */ zzge$zzk zzfd() {
        return zzws;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzk>)zzgf.zzba;
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
                clazz = zzge$zzk.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzws;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzws;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzwo";
                objectArray[2] = "zzwq";
                objectArray[3] = "zzwr";
                objectArray[4] = "zzwp";
                return zzcg.zza(zzws, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0001\u0000\u0001\n\u0000\u0002\u001c\u0003\u0007\u0002\u0004\b\u0001", objectArray);
            }
            case 2: {
                return new zzge$zzk$zza(null);
            }
            case 1: 
        }
        return new zzge$zzk();
    }
}

