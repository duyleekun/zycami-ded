/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zzb$zza;
import com.google.android.gms.internal.vision.zzci$zzb$zzb;
import com.google.android.gms.internal.vision.zzci$zzb$zzc;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import java.util.List;

public final class zzci$zzb
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zzb zzjq;
    private int zzbm;
    private int zzjo;
    private zzik zzjp;

    static {
        zzci$zzb zzci$zzb;
        zzjq = zzci$zzb = new zzci$zzb();
        zzid.zza(zzci$zzb.class, zzci$zzb);
    }

    private zzci$zzb() {
        zzik zzik2;
        this.zzjp = zzik2 = zzid.zzhb();
    }

    public static zzci$zzb zzbm() {
        return zzjq;
    }

    public static /* synthetic */ zzci$zzb zzbn() {
        return zzjq;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zzb>)zzcj.zzbl;
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
                clazz = zzci$zzb.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzjq;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzjq;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzjo";
                objectArray[2] = object2 = zzci$zzb$zzc.zzal();
                objectArray[3] = "zzjp";
                objectArray[4] = zzci$zzb$zzb.class;
                return zzid.zza((zzjn)zzjq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u001b", objectArray);
            }
            case 2: {
                return new zzci$zzb$zza(null);
            }
            case 1: 
        }
        return new zzci$zzb();
    }

    public final zzci$zzb$zzc zzbj() {
        int n10 = this.zzjo;
        zzci$zzb$zzc zzci$zzb$zzc = zzci$zzb$zzc.zzp(n10);
        if (zzci$zzb$zzc == null) {
            zzci$zzb$zzc = zzci$zzb$zzc.zzjv;
        }
        return zzci$zzb$zzc;
    }

    public final List zzbk() {
        return this.zzjp;
    }

    public final int zzbl() {
        return this.zzjp.size();
    }
}

