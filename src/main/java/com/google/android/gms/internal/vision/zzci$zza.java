/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zza$zza;
import com.google.android.gms.internal.vision.zzci$zzg;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzci$zza
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zza zzjj;
    private int zzbm;
    private zzci$zzg zzjh;
    private zzci$zzg zzji;

    static {
        zzci$zza zzci$zza;
        zzjj = zzci$zza = new zzci$zza();
        zzid.zza(zzci$zza.class, zzci$zza);
    }

    private zzci$zza() {
    }

    public static /* synthetic */ void zza(zzci$zza zzci$zza, zzci$zzg zzci$zzg) {
        zzci$zza.zza(zzci$zzg);
    }

    private final void zza(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzjh = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 1;
    }

    public static /* synthetic */ void zzb(zzci$zza zzci$zza, zzci$zzg zzci$zzg) {
        zzci$zza.zzb(zzci$zzg);
    }

    private final void zzb(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzji = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 2;
    }

    public static zzci$zza$zza zzbh() {
        return (zzci$zza$zza)zzjj.zzgy();
    }

    public static /* synthetic */ zzci$zza zzbi() {
        return zzjj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zza>)zzcj.zzbl;
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
                Object object3 = zzbk;
                if (object3 != null) return object3;
                clazz = zzci$zza.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzjj;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzjj;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzjh";
                objectArray[2] = "zzji";
                return zzid.zza((zzjn)zzjj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001", objectArray);
            }
            case 2: {
                return new zzci$zza$zza(null);
            }
            case 1: 
        }
        return new zzci$zza();
    }
}

