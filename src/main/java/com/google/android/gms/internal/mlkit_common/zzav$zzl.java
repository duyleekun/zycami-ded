/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzav$zzl$zza;
import com.google.android.gms.internal.mlkit_common.zzay;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzl
extends zzfq
implements zzhd {
    private static final zzfz zzg;
    private static final zzav$zzl zzi;
    private static volatile zzhl zzj;
    private int zzc;
    private zzav$zzam zzd;
    private zzav$zzam zze;
    private zzfw zzf;
    private long zzh;

    static {
        Object object;
        zzg = object = new zzay();
        zzi = object = new zzav$zzl();
        zzfq.zza(zzav$zzl.class, (zzfq)object);
    }

    private zzav$zzl() {
        zzfw zzfw2;
        this.zzf = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzav$zzl zza() {
        return zzi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzl>)zzau.zza;
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
                Object object3 = zzj;
                if (object3 != null) return object3;
                clazz = zzav$zzl.class;
                synchronized (clazz) {
                    object3 = zzj;
                    if (object3 != null) return object3;
                    object2 = zzi;
                    zzj = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzi;
            }
            case 3: {
                Object[] objectArray = new Object[6];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzbf.zzb();
                objectArray[5] = "zzh";
                return zzfq.zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u1003\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzl$zza(null);
            }
            case 1: 
        }
        return new zzav$zzl();
    }
}

