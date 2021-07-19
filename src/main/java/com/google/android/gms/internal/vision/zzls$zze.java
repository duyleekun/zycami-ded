/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;
import com.google.android.gms.internal.vision.zzls$zze$zza;
import com.google.android.gms.internal.vision.zzls$zze$zzb;
import com.google.android.gms.internal.vision.zzls$zze$zzc;
import com.google.android.gms.internal.vision.zzlu;

public final class zzls$zze
extends zzid
implements zzjp {
    private static final zzls$zze zzagm;
    private static volatile zzjw zzbk;
    private float zzaem;
    private int zzagl;
    private int zzbm;
    private int zzjo = 15000;
    private float zzjr;
    private float zzjs;
    private float zzjt;

    static {
        zzls$zze zzls$zze;
        zzagm = zzls$zze = new zzls$zze();
        zzid.zza(zzls$zze.class, zzls$zze);
    }

    private zzls$zze() {
    }

    public static /* synthetic */ zzls$zze zzkf() {
        return zzagm;
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
        clazz = (Class<zzls$zze>)zzlu.zzbl;
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
                clazz = zzls$zze.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzagm;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzagm;
            }
            case 3: {
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzjr";
                objectArray[2] = "zzjs";
                objectArray[3] = "zzjt";
                objectArray[4] = "zzjo";
                objectArray[5] = object2 = zzls$zze$zza.zzal();
                objectArray[6] = "zzagl";
                objectArray[7] = object2 = zzls$zze$zzc.zzal();
                objectArray[8] = "zzaem";
                return zzid.zza((zzjn)zzagm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1001\u0000\u0002\u1001\u0001\u0003\u1001\u0002\u0004\u100c\u0003\u0005\u100c\u0004\u0006\u1001\u0005", objectArray);
            }
            case 2: {
                return new zzls$zze$zzb(null);
            }
            case 1: 
        }
        return new zzls$zze();
    }

    public final zzls$zze$zza zzke() {
        int n10 = this.zzjo;
        zzls$zze$zza zzls$zze$zza = zzls$zze$zza.zzch(n10);
        if (zzls$zze$zza == null) {
            zzls$zze$zza = zzls$zze$zza.zzahz;
        }
        return zzls$zze$zza;
    }
}

