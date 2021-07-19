/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzc;
import com.google.android.gms.internal.vision.zzfl$zzd;
import com.google.android.gms.internal.vision.zzfl$zzh;
import com.google.android.gms.internal.vision.zzfl$zzn$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzn
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzn zzrs;
    private int zzbm;
    private zzfl$zzd zzro;
    private int zzrp;
    private zzfl$zzh zzrq;
    private zzfl$zzc zzrr;

    static {
        zzfl$zzn zzfl$zzn;
        zzrs = zzfl$zzn = new zzfl$zzn();
        zzid.zza(zzfl$zzn.class, zzfl$zzn);
    }

    private zzfl$zzn() {
    }

    private final void setId(int n10) {
        int n11;
        this.zzbm = n11 = this.zzbm | 2;
        this.zzrp = n10;
    }

    private final void zza(zzfl$zzd zzfl$zzd) {
        int n10;
        zzfl$zzd.getClass();
        this.zzro = zzfl$zzd;
        this.zzbm = n10 = this.zzbm | 1;
    }

    private final void zza(zzfl$zzh zzfl$zzh) {
        int n10;
        zzfl$zzh.getClass();
        this.zzrq = zzfl$zzh;
        this.zzbm = n10 = this.zzbm | 4;
    }

    public static /* synthetic */ void zza(zzfl$zzn zzfl$zzn, int n10) {
        zzfl$zzn.setId(n10);
    }

    public static /* synthetic */ void zza(zzfl$zzn zzfl$zzn, zzfl$zzd zzfl$zzd) {
        zzfl$zzn.zza(zzfl$zzd);
    }

    public static /* synthetic */ void zza(zzfl$zzn zzfl$zzn, zzfl$zzh zzfl$zzh) {
        zzfl$zzn.zza(zzfl$zzh);
    }

    public static zzfl$zzn$zza zzea() {
        return (zzfl$zzn$zza)zzrs.zzgy();
    }

    public static /* synthetic */ zzfl$zzn zzeb() {
        return zzrs;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzn>)zzfk.zzbl;
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
                clazz = zzfl$zzn.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzrs;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzrs;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzro";
                objectArray[2] = "zzrp";
                objectArray[3] = "zzrq";
                objectArray[4] = "zzrr";
                return zzid.zza((zzjn)zzrs, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1004\u0001\u0010\u1009\u0002\u0011\u1009\u0003", objectArray);
            }
            case 2: {
                return new zzfl$zzn$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzn();
    }
}

