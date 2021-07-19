/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzb;
import com.google.android.gms.internal.clearcut.zzcl;
import com.google.android.gms.internal.clearcut.zzcm;
import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzdq;
import com.google.android.gms.internal.clearcut.zzdz;
import com.google.android.gms.internal.clearcut.zzge$zza$zza;
import com.google.android.gms.internal.clearcut.zzgf;

public final class zzge$zza
extends zzcg
implements zzdq {
    private static volatile zzdz zzbg;
    private static final zzge$zza zzsm;
    private zzcn zzsh;
    private zzcn zzsi;
    private zzcl zzsj;
    private zzcm zzsk;
    private zzcm zzsl;

    static {
        zzge$zza zzge$zza;
        zzsm = zzge$zza = new zzge$zza();
        zzcg.zza(zzge$zza.class, zzge$zza);
    }

    private zzge$zza() {
        zzcn zzcn2;
        this.zzsh = zzcn2 = zzcg.zzbb();
        this.zzsi = zzcn2 = zzcg.zzbb();
        zzcn2 = zzcg.zzaz();
        this.zzsj = zzcn2;
        zzcn2 = zzcg.zzba();
        this.zzsk = zzcn2;
        zzcn2 = zzcg.zzba();
        this.zzsl = zzcn2;
    }

    public static /* synthetic */ zzge$zza zzet() {
        return zzsm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzge$zza>)zzgf.zzba;
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
                clazz = zzge$zza.class;
                synchronized (clazz) {
                    object3 = zzbg;
                    if (object3 != null) return object3;
                    object2 = zzsm;
                    zzbg = object3 = new zzcg$zzb((zzcg)object2);
                    return object3;
                }
            }
            case 4: {
                return zzsm;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzsh";
                objectArray[by2] = "zzsi";
                objectArray[2] = "zzsj";
                objectArray[3] = "zzsk";
                objectArray[4] = "zzsl";
                return zzcg.zza(zzsm, "\u0001\u0005\u0000\u0000\u0001\u0005\u0005\u0006\u0000\u0005\u0000\u0001\u001a\u0002\u001a\u0003\u0016\u0004\u0014\u0005\u0014", objectArray);
            }
            case 2: {
                return new zzge$zza$zza(null);
            }
            case 1: 
        }
        return new zzge$zza();
    }
}

