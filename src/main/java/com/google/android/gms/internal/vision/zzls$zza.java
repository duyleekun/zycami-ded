/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzls$zza$zza;
import com.google.android.gms.internal.vision.zzls$zza$zzb;
import com.google.android.gms.internal.vision.zzlu;

public final class zzls$zza
extends zzid
implements zzjp {
    private static final zzls$zza zzafb;
    private static volatile zzjw zzbk;
    private float zzaem;
    private float zzafa;
    private int zzbm;
    private int zzjo;
    private String zzpd = "";

    static {
        zzls$zza zzls$zza;
        zzafb = zzls$zza = new zzls$zza();
        zzid.zza(zzls$zza.class, zzls$zza);
    }

    private zzls$zza() {
    }

    public static /* synthetic */ zzls$zza zzjw() {
        return zzafb;
    }

    public final float getConfidence() {
        return this.zzaem;
    }

    public final String getName() {
        return this.zzpd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzls$zza>)zzlu.zzbl;
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
                clazz = zzls$zza.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzafb;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzafb;
            }
            case 3: {
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzjo";
                objectArray[2] = object2 = zzls$zza$zza.zzal();
                objectArray[3] = "zzpd";
                objectArray[4] = "zzaem";
                objectArray[5] = "zzafa";
                return zzid.zza((zzjn)zzafb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1008\u0001\u0003\u1001\u0002\u0004\u1001\u0003", objectArray);
            }
            case 2: {
                return new zzls$zza$zzb(null);
            }
            case 1: 
        }
        return new zzls$zza();
    }
}

