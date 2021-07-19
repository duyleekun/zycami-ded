/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zzf$zza;
import com.google.android.gms.internal.vision.zzci$zzg;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzci$zzf
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zzf zzlp;
    private int zzbm;
    private zzci$zzg zzll;
    private zzci$zzg zzlm;
    private zzci$zzg zzln;
    private zzci$zzg zzlo;

    static {
        zzci$zzf zzci$zzf;
        zzlp = zzci$zzf = new zzci$zzf();
        zzid.zza(zzci$zzf.class, zzci$zzf);
    }

    private zzci$zzf() {
    }

    public static /* synthetic */ void zza(zzci$zzf zzci$zzf, zzci$zzg zzci$zzg) {
        zzci$zzf.zzo(zzci$zzg);
    }

    public static /* synthetic */ void zzb(zzci$zzf zzci$zzf, zzci$zzg zzci$zzg) {
        zzci$zzf.zzp(zzci$zzg);
    }

    public static zzci$zzf$zza zzbx() {
        return (zzci$zzf$zza)zzlp.zzgy();
    }

    public static /* synthetic */ zzci$zzf zzby() {
        return zzlp;
    }

    public static /* synthetic */ void zzc(zzci$zzf zzci$zzf, zzci$zzg zzci$zzg) {
        zzci$zzf.zzq(zzci$zzg);
    }

    public static /* synthetic */ void zzd(zzci$zzf zzci$zzf, zzci$zzg zzci$zzg) {
        zzci$zzf.zzr(zzci$zzg);
    }

    private final void zzo(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzll = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 1;
    }

    private final void zzp(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzlm = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 2;
    }

    private final void zzq(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzln = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 4;
    }

    private final void zzr(zzci$zzg zzci$zzg) {
        int n10;
        zzci$zzg.getClass();
        this.zzlo = zzci$zzg;
        this.zzbm = n10 = this.zzbm | 8;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zzf>)zzcj.zzbl;
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
                clazz = zzci$zzf.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzlp;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzlp;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzll";
                objectArray[2] = "zzlm";
                objectArray[3] = "zzln";
                objectArray[4] = "zzlo";
                return zzid.zza((zzjn)zzlp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1009\u0003", objectArray);
            }
            case 2: {
                return new zzci$zzf$zza(null);
            }
            case 1: 
        }
        return new zzci$zzf();
    }
}

