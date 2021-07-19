/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zze$zza;
import com.google.android.gms.internal.vision.zzfl$zze$zzb;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zze
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zze zzox;
    private int zzbm;
    private String zzop;
    private boolean zzoq;
    private int zzor;
    private long zzos;
    private long zzot;
    private long zzou;
    private String zzov;
    private boolean zzow;

    static {
        zzfl$zze zzfl$zze;
        zzox = zzfl$zze = new zzfl$zze();
        zzid.zza(zzfl$zze.class, zzfl$zze);
    }

    private zzfl$zze() {
        String string2;
        this.zzop = string2 = "";
        this.zzov = string2;
    }

    public static /* synthetic */ zzfl$zze zzdj() {
        return zzox;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zze>)zzfk.zzbl;
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
                clazz = zzfl$zze.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzox;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzox;
            }
            case 3: {
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzop";
                objectArray[2] = "zzoq";
                objectArray[3] = "zzor";
                objectArray[4] = object2 = zzfl$zze$zza.zzal();
                objectArray[5] = "zzos";
                objectArray[6] = "zzot";
                objectArray[7] = "zzou";
                objectArray[8] = "zzov";
                objectArray[9] = "zzow";
                return zzid.zza((zzjn)zzox, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1007\u0001\u0003\u100c\u0002\u0004\u1002\u0003\u0005\u1002\u0004\u0006\u1002\u0005\u0007\u1008\u0006\b\u1007\u0007", objectArray);
            }
            case 2: {
                return new zzfl$zze$zzb(null);
            }
            case 1: 
        }
        return new zzfl$zze();
    }
}

