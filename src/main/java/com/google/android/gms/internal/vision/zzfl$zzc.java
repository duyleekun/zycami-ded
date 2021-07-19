/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzc$zza;
import com.google.android.gms.internal.vision.zzfz;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzc
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzc zzom;
    private int zzbm;
    private int zzoj;
    private int zzok;
    private String zzol = "";

    static {
        zzfl$zzc zzfl$zzc;
        zzom = zzfl$zzc = new zzfl$zzc();
        zzid.zza(zzfl$zzc.class, zzfl$zzc);
    }

    private zzfl$zzc() {
    }

    public static /* synthetic */ zzfl$zzc zzdg() {
        return zzom;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzc>)zzfk.zzbl;
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
                clazz = zzfl$zzc.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzom;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzom;
            }
            case 3: {
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzoj";
                objectArray[2] = object2 = zzfz.zzal();
                objectArray[3] = "zzok";
                objectArray[4] = object2 = zzgd.zzal();
                objectArray[5] = "zzol";
                return zzid.zza((zzjn)zzom, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u1008\u0002", objectArray);
            }
            case 2: {
                return new zzfl$zzc$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzc();
    }
}

