/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzci$zzb$zzb$zza;
import com.google.android.gms.internal.vision.zzcj;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzci$zzb$zzb
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzci$zzb$zzb zzju;
    private int zzbm;
    private float zzjr;
    private float zzjs;
    private float zzjt;

    static {
        zzci$zzb$zzb zzci$zzb$zzb;
        zzju = zzci$zzb$zzb = new zzci$zzb$zzb();
        zzid.zza(zzci$zzb$zzb.class, zzci$zzb$zzb);
    }

    private zzci$zzb$zzb() {
    }

    public static /* synthetic */ zzci$zzb$zzb zzbo() {
        return zzju;
    }

    public final float getX() {
        return this.zzjr;
    }

    public final float getY() {
        return this.zzjs;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzci$zzb$zzb>)zzcj.zzbl;
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
                clazz = zzci$zzb$zzb.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzju;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzju;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzjr";
                objectArray[2] = "zzjs";
                objectArray[3] = "zzjt";
                return zzid.zza((zzjn)zzju, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1001\u0000\u0002\u1001\u0001\u0003\u1001\u0002", objectArray);
            }
            case 2: {
                return new zzci$zzb$zzb$zza(null);
            }
            case 1: 
        }
        return new zzci$zzb$zzb();
    }
}

