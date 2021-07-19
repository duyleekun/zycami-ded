/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzm$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzm
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzm zzrn;
    private int zzbm;
    private int zzrl;
    private int zzrm;

    static {
        zzfl$zzm zzfl$zzm;
        zzrn = zzfl$zzm = new zzfl$zzm();
        zzid.zza(zzfl$zzm.class, zzfl$zzm);
    }

    private zzfl$zzm() {
    }

    private final void setX(int n10) {
        int n11;
        this.zzbm = n11 = this.zzbm | 1;
        this.zzrl = n10;
    }

    private final void setY(int n10) {
        int n11;
        this.zzbm = n11 = this.zzbm | 2;
        this.zzrm = n10;
    }

    public static /* synthetic */ void zza(zzfl$zzm zzfl$zzm, int n10) {
        zzfl$zzm.setX(n10);
    }

    public static /* synthetic */ void zzb(zzfl$zzm zzfl$zzm, int n10) {
        zzfl$zzm.setY(n10);
    }

    public static zzfl$zzm$zza zzdy() {
        return (zzfl$zzm$zza)zzrn.zzgy();
    }

    public static /* synthetic */ zzfl$zzm zzdz() {
        return zzrn;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzm>)zzfk.zzbl;
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
                clazz = zzfl$zzm.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzrn;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzrn;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzrl";
                objectArray[2] = "zzrm";
                return zzid.zza((zzjn)zzrn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzfl$zzm$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzm();
    }
}

