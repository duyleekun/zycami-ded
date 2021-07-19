/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzf;
import com.google.android.gms.internal.vision.zzfl$zzi$zza;
import com.google.android.gms.internal.vision.zzfl$zzj;
import com.google.android.gms.internal.vision.zzfl$zzl;
import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzi
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzi zzqu;
    private int zzbm;
    private zzfl$zzj zzqr;
    private zzfl.zzl zzqs;
    private zzik zzqt;

    static {
        zzfl$zzi zzfl$zzi;
        zzqu = zzfl$zzi = new zzfl$zzi();
        zzid.zza(zzfl$zzi.class, zzfl$zzi);
    }

    private zzfl$zzi() {
        zzik zzik2;
        this.zzqt = zzik2 = zzid.zzhb();
    }

    private final void zza(zzfl$zzf zzfl$zzf) {
        zzfl$zzf.getClass();
        this.zzdq();
        this.zzqt.add(zzfl$zzf);
    }

    public static /* synthetic */ void zza(zzfl$zzi zzfl$zzi, zzfl$zzf zzfl$zzf) {
        zzfl$zzi.zza(zzfl$zzf);
    }

    public static /* synthetic */ void zza(zzfl$zzi zzfl$zzi, zzfl$zzj zzfl$zzj) {
        zzfl$zzi.zzb(zzfl$zzj);
    }

    public static /* synthetic */ void zza(zzfl$zzi zzfl$zzi, Iterable iterable) {
        zzfl$zzi.zzf(iterable);
    }

    private final void zzb(zzfl$zzj zzfl$zzj) {
        int n10;
        zzfl$zzj.getClass();
        this.zzqr = zzfl$zzj;
        this.zzbm = n10 = this.zzbm | 1;
    }

    private final void zzdq() {
        zzik zzik2 = this.zzqt;
        boolean bl2 = zzik2.zzei();
        if (!bl2) {
            this.zzqt = zzik2 = zzid.zza(zzik2);
        }
    }

    public static zzfl$zzi$zza zzdr() {
        return (zzfl$zzi$zza)zzqu.zzgy();
    }

    public static /* synthetic */ zzfl$zzi zzds() {
        return zzqu;
    }

    private final void zzf(Iterable iterable) {
        this.zzdq();
        zzik zzik2 = this.zzqt;
        zzge.zza(iterable, zzik2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzi>)zzfk.zzbl;
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
                clazz = zzfl$zzi.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzqu;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzqu;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzqr";
                objectArray[2] = "zzqs";
                objectArray[3] = "zzqt";
                objectArray[4] = zzfl$zzf.class;
                return zzid.zza((zzjn)zzqu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001b", objectArray);
            }
            case 2: {
                return new zzfl$zzi$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzi();
    }
}

