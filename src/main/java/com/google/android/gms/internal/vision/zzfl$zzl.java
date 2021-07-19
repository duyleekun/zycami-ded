/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzl$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzl
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzl zzrk;
    private int zzbm;
    private long zzpi;
    private long zzpj;

    static {
        zzfl$zzl zzfl$zzl;
        zzrk = zzfl$zzl = new zzfl$zzl();
        zzid.zza(zzfl$zzl.class, zzfl$zzl);
    }

    private zzfl$zzl() {
    }

    public static /* synthetic */ zzfl$zzl zzdx() {
        return zzrk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzl>)zzfk.zzbl;
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
                clazz = zzfl$zzl.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzrk;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzrk;
            }
            case 3: {
                Object[] objectArray = new Object[3];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzpi";
                objectArray[2] = "zzpj";
                return zzid.zza((zzjn)zzrk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u1002\u0001", objectArray);
            }
            case 2: {
                return new zzfl$zzl$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzl();
    }
}

