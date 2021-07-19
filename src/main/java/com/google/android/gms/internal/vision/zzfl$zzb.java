/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzb$zza;
import com.google.android.gms.internal.vision.zzfm;
import com.google.android.gms.internal.vision.zzfz;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzii;
import com.google.android.gms.internal.vision.zzil;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzb
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzil zzoh;
    private static final zzfl$zzb zzoi;
    private zzii zzog;

    static {
        Object object;
        zzoh = object = new zzfm();
        zzoi = object = new zzfl$zzb();
        zzid.zza(zzfl$zzb.class, (zzid)object);
    }

    private zzfl$zzb() {
        zzii zzii2;
        this.zzog = zzii2 = zzid.zzha();
    }

    public static /* synthetic */ zzfl$zzb zzdf() {
        return zzoi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object object2, Object object3) {
        object2 = zzfk.zzbl;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                Object object4 = zzbk;
                if (object4 != null) return object4;
                object2 = zzfl$zzb.class;
                synchronized (object2) {
                    object4 = zzbk;
                    if (object4 != null) return object4;
                    object3 = zzoi;
                    zzbk = object4 = new zzid$zzc((zzid)object3);
                    return object4;
                }
            }
            case 4: {
                return zzoi;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzog";
                objectArray[by2] = object2 = zzfz.zzal();
                return zzid.zza((zzjn)zzoi, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", objectArray);
            }
            case 2: {
                return new zzfl$zzb$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzb();
    }
}

