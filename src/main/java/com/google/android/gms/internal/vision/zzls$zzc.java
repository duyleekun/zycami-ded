/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzls$zzc$zza;
import com.google.android.gms.internal.vision.zzlu;

public final class zzls$zzc
extends zzid
implements zzjp {
    private static final zzls$zzc zzagk;
    private static volatile zzjw zzbk;
    private float zzaem;
    private int zzagh;
    private zzgs zzagi;
    private String zzagj;
    private int zzbm;

    static {
        zzls$zzc zzls$zzc;
        zzagk = zzls$zzc = new zzls$zzc();
        zzid.zza(zzls$zzc.class, zzls$zzc);
    }

    private zzls$zzc() {
        zzgs zzgs2;
        this.zzagi = zzgs2 = zzgs.zztt;
        this.zzagj = "";
    }

    public static /* synthetic */ zzls$zzc zzkd() {
        return zzagk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzls$zzc>)zzlu.zzbl;
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
                clazz = zzls$zzc.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzagk;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzagk;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzagh";
                objectArray[2] = "zzagi";
                objectArray[3] = "zzagj";
                objectArray[4] = "zzaem";
                return zzid.zza((zzjn)zzagk, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u100a\u0001\u0003\u1008\u0002\u0004\u1001\u0003", objectArray);
            }
            case 2: {
                return new zzls$zzc$zza(null);
            }
            case 1: 
        }
        return new zzls$zzc();
    }
}

