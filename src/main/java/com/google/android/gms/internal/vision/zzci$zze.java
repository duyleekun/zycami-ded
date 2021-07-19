/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zze$zza;
import com.google.android.gms.internal.vision.zzci$zzg;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzci$zze
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zze zzlf;
    private int zzbm;
    private zzci$zzg zzlc;
    private zzci$zzg zzld;
    private zzci$zzg zzle;

    static {
        zzci$zze zzci$zze;
        zzlf = zzci$zze = new zzci$zze();
        zzid.zza(zzci$zze.class, zzci$zze);
    }

    private zzci$zze() {
    }

    public static /* synthetic */ void zza(zzci$zze zzci$zze, zzci$zzg zzci$zzg) {
        zzci$zze.zze(zzci$zzg);
    }

    public static /* synthetic */ void zzb(zzci$zze zzci$zze, zzci$zzg zzci$zzg) {
        zzci$zze.zzf(zzci$zzg);
    }

    public static zzci$zze$zza zzbv() {
        return (zzci$zze$zza)zzlf.zzgy();
    }

    public static /* synthetic */ zzci$zze zzbw() {
        return zzlf;
    }

    public static /* synthetic */ void zzc(zzci$zze zzci$zze, zzci$zzg zzci$zzg) {
        zzci$zze.zzg(zzci$zzg);
    }

    private final void zze(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzlc = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 1;
    }

    private final void zzf(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzld = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 2;
    }

    private final void zzg(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzle = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zze>)zzcj.zzbl;
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
                clazz = zzci$zze.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzlf;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzlf;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzlc";
                objectArray[2] = "zzld";
                objectArray[3] = "zzle";
                return zzid.zza((zzjn)zzlf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzci$zze$zza(null);
            }
            case 1: 
        }
        return new zzci$zze();
    }
}

