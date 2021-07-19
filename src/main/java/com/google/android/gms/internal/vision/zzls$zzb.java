/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzls$zzb$zza;
import com.google.android.gms.internal.vision.zzlu;

public final class zzls$zzb
extends zzid
implements zzjp {
    private static final zzls$zzb zzagg;
    private static volatile zzjw zzbk;
    private float zzagc;
    private float zzagd;
    private float zzage;
    private float zzagf;
    private int zzbm;

    static {
        zzls$zzb zzls$zzb;
        zzagg = zzls$zzb = new zzls$zzb();
        zzid.zza(zzls$zzb.class, zzls$zzb);
    }

    private zzls$zzb() {
    }

    public static zzls$zzb zzkb() {
        return zzagg;
    }

    public static /* synthetic */ zzls$zzb zzkc() {
        return zzagg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzls$zzb>)zzlu.zzbl;
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
                clazz = zzls$zzb.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzagg;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzagg;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzagc";
                objectArray[2] = "zzagd";
                objectArray[3] = "zzage";
                objectArray[4] = "zzagf";
                return zzid.zza((zzjn)zzagg, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1001\u0000\u0002\u1001\u0001\u0003\u1001\u0002\u0004\u1001\u0003", objectArray);
            }
            case 2: {
                return new zzls$zzb$zza(null);
            }
            case 1: 
        }
        return new zzls$zzb();
    }

    public final float zzjx() {
        return this.zzagc;
    }

    public final float zzjy() {
        return this.zzagd;
    }

    public final float zzjz() {
        return this.zzage;
    }

    public final float zzka() {
        return this.zzagf;
    }
}

