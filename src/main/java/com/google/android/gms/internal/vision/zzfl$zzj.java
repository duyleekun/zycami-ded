/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzj$zza;
import com.google.android.gms.internal.vision.zzfl$zzj$zzb;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzj
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzj zzqz;
    private int zzbm;
    private int zzoj;
    private long zzqv;
    private long zzqw;
    private long zzqx;
    private long zzqy;

    static {
        zzfl$zzj zzfl$zzj;
        zzqz = zzfl$zzj = new zzfl$zzj();
        zzid.zza(zzfl$zzj.class, zzfl$zzj);
    }

    private zzfl$zzj() {
    }

    public static /* synthetic */ void zza(zzfl$zzj zzfl$zzj, long l10) {
        zzfl$zzj.zzl(l10);
    }

    public static /* synthetic */ void zzb(zzfl$zzj zzfl$zzj, long l10) {
        zzfl$zzj.zzm(l10);
    }

    public static /* synthetic */ void zzc(zzfl$zzj zzfl$zzj, long l10) {
        zzfl$zzj.zzn(l10);
    }

    public static /* synthetic */ void zzd(zzfl$zzj zzfl$zzj, long l10) {
        zzfl$zzj.zzo(l10);
    }

    public static zzfl$zzj$zza zzdt() {
        return (zzfl$zzj$zza)zzqz.zzgy();
    }

    public static /* synthetic */ zzfl$zzj zzdu() {
        return zzqz;
    }

    private final void zzl(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 2;
        this.zzqv = l10;
    }

    private final void zzm(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 4;
        this.zzqw = l10;
    }

    private final void zzn(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 8;
        this.zzqx = l10;
    }

    private final void zzo(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x10;
        this.zzqy = l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzj>)zzfk.zzbl;
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
                clazz = zzfl$zzj.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzqz;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzqz;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzoj";
                objectArray[2] = object2 = zzfl$zzj$zzb.zzal();
                objectArray[3] = "zzqv";
                objectArray[4] = "zzqw";
                objectArray[5] = "zzqy";
                objectArray[6] = "zzqx";
                return zzid.zza((zzjn)zzqz, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1002\u0001\u0003\u1002\u0002\u0004\u1002\u0004\u0005\u1002\u0003", objectArray);
            }
            case 2: {
                return new zzfl$zzj$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzj();
    }
}

