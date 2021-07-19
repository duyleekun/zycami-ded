/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zzp$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zzp
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zzp zzzc;
    private int zzbb;
    private String zzza;
    private String zzzb;

    static {
        zzge$zzp zzge$zzp;
        zzzc = zzge$zzp = new zzge$zzp();
        zzcg.zza(zzge$zzp.class, zzge$zzp);
    }

    private zzge$zzp() {
        String string2;
        this.zzza = string2 = "";
        this.zzzb = string2;
    }

    public static /* synthetic */ zzge$zzp zzfi() {
        return zzzc;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zzp>)zzgf.zzba;
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
                clazz = zzge$zzp.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzzc;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzzc;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbb";
                objectArray[by2] = "zzza";
                objectArray[2] = "zzzb";
                return zzcg.zza(zzzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", objectArray);
            }
            case 2: {
                return new zzge$zzp$zza(null);
            }
            case 1: 
        }
        return new zzge$zzp();
    }
}

