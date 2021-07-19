/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzh$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzh
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzh zzqq;
    private int zzbm;
    private float zzqk;
    private float zzql;
    private float zzqm;
    private float zzqn;
    private float zzqo;
    private float zzqp;

    static {
        zzfl$zzh zzfl$zzh;
        zzqq = zzfl$zzh = new zzfl$zzh();
        zzid.zza(zzfl$zzh.class, zzfl$zzh);
    }

    private zzfl$zzh() {
    }

    public static /* synthetic */ void zza(zzfl$zzh zzfl$zzh, float f10) {
        zzfl$zzh.zzm(f10);
    }

    public static /* synthetic */ void zzb(zzfl$zzh zzfl$zzh, float f10) {
        zzfl$zzh.zzn(f10);
    }

    public static /* synthetic */ void zzc(zzfl$zzh zzfl$zzh, float f10) {
        zzfl$zzh.zzo(f10);
    }

    public static /* synthetic */ void zzd(zzfl$zzh zzfl$zzh, float f10) {
        zzfl$zzh.zzp(f10);
    }

    public static zzfl$zzh$zza zzdo() {
        return (zzfl$zzh$zza)zzqq.zzgy();
    }

    public static /* synthetic */ zzfl$zzh zzdp() {
        return zzqq;
    }

    public static /* synthetic */ void zze(zzfl$zzh zzfl$zzh, float f10) {
        zzfl$zzh.zzq(f10);
    }

    public static /* synthetic */ void zzf(zzfl$zzh zzfl$zzh, float f10) {
        zzfl$zzh.zzr(f10);
    }

    private final void zzm(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 1;
        this.zzqk = f10;
    }

    private final void zzn(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 2;
        this.zzql = f10;
    }

    private final void zzo(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 4;
        this.zzqm = f10;
    }

    private final void zzp(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 8;
        this.zzqn = f10;
    }

    private final void zzq(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x10;
        this.zzqo = f10;
    }

    private final void zzr(float f10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x20;
        this.zzqp = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzh>)zzfk.zzbl;
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
                clazz = zzfl$zzh.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzqq;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzqq;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzqk";
                objectArray[2] = "zzql";
                objectArray[3] = "zzqm";
                objectArray[4] = "zzqn";
                objectArray[5] = "zzqo";
                objectArray[6] = "zzqp";
                return zzid.zza((zzjn)zzqq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1001\u0000\u0002\u1001\u0001\u0003\u1001\u0002\u0004\u1001\u0003\u0005\u1001\u0004\u0006\u1001\u0005", objectArray);
            }
            case 2: {
                return new zzfl$zzh$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzh();
    }
}

