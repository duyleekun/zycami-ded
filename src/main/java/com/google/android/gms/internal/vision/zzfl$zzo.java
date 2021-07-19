/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zze;
import com.google.android.gms.internal.vision.zzfl$zzi;
import com.google.android.gms.internal.vision.zzfl$zzk;
import com.google.android.gms.internal.vision.zzfl$zzo$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzo
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzo zzrx;
    private int zzbm;
    private zzfl$zze zzrt;
    private zzfl$zzk zzru;
    private zzfl$zzi zzrv;
    private int zzrw;

    static {
        zzfl$zzo zzfl$zzo;
        zzrx = zzfl$zzo = new zzfl$zzo();
        zzid.zza(zzfl$zzo.class, zzfl$zzo);
    }

    private zzfl$zzo() {
    }

    private final void zza(zzfl$zzi zzfl$zzi) {
        int n10;
        zzfl$zzi.getClass();
        this.zzrv = zzfl$zzi;
        this.zzbm = n10 = this.zzbm | 4;
    }

    private final void zza(zzfl$zzk zzfl$zzk) {
        int n10;
        zzfl$zzk.getClass();
        this.zzru = zzfl$zzk;
        this.zzbm = n10 = this.zzbm | 2;
    }

    public static /* synthetic */ void zza(zzfl$zzo zzfl$zzo, zzfl$zzi zzfl$zzi) {
        zzfl$zzo.zza(zzfl$zzi);
    }

    public static /* synthetic */ void zza(zzfl$zzo zzfl$zzo, zzfl$zzk zzfl$zzk) {
        zzfl$zzo.zza(zzfl$zzk);
    }

    public static zzfl$zzo$zza zzec() {
        return (zzfl$zzo$zza)zzrx.zzgy();
    }

    public static /* synthetic */ zzfl$zzo zzed() {
        return zzrx;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzo>)zzfk.zzbl;
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
                clazz = zzfl$zzo.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzrx;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzrx;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzrt";
                objectArray[2] = "zzru";
                objectArray[3] = "zzrv";
                objectArray[4] = "zzrw";
                return zzid.zza((zzjn)zzrx, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1004\u0003", objectArray);
            }
            case 2: {
                return new zzfl$zzo$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzo();
    }
}

