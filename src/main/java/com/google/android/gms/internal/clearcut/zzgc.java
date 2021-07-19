/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzcg$zzd;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzgc$zza;
import com.google.android.gms.internal.clearcut.zzgd;

public final class zzgc
extends zzcg$zzd
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzgc zzsg;
    private byte zzsf = (byte)2;

    static {
        zzgc zzgc2;
        zzsg = zzgc2 = new zzgc();
        zzcg.zza(zzgc.class, zzgc2);
    }

    private zzgc() {
    }

    public static zzgc zzer() {
        return zzsg;
    }

    public static /* synthetic */ zzgc zzes() {
        return zzsg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzgd.zzba;
        int n10 = 1;
        object -= n10;
        object = object2[object];
        object2 = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                }
                object = (byte)n10;
                this.zzsf = (byte)object;
                return null;
            }
            case 6: {
                return this.zzsf;
            }
            case 5: {
                Object object3 = zzbg;
                if (object3 != null) return object3;
                clazz = zzgc.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzsg;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzsg;
            }
            case 3: {
                return zzcg.zza(zzsg, "\u0003\u0000", null);
            }
            case 2: {
                return new zzgc$zza(null);
            }
            case 1: 
        }
        return new zzgc();
    }
}

