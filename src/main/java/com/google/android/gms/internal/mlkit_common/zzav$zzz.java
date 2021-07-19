/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzav$zzz$zza;
import com.google.android.gms.internal.mlkit_common.zzbd;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzz
extends zzfq
implements zzhd {
    private static final zzfz zzg;
    private static final zzav$zzz zzj;
    private static volatile zzhl zzk;
    private int zzc;
    private zzav$zzam zzd;
    private zzav$zzam zze;
    private zzfw zzf;
    private long zzh;
    private boolean zzi;

    static {
        Object object;
        zzg = object = new zzbd();
        zzj = object = new zzav$zzz();
        zzfq.zza(zzav$zzz.class, (zzfq)object);
    }

    private zzav$zzz() {
        zzfw zzfw2;
        this.zzf = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzav$zzz zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzz>)zzau.zza;
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
                Object object3 = zzk;
                if (object3 != null) return object3;
                clazz = zzav$zzz.class;
                synchronized (clazz) {
                    object3 = zzk;
                    if (object3 != null) return object3;
                    object2 = zzj;
                    zzk = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzj;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzbf.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                return zzfq.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u1003\u0002\u0005\u1007\u0003", objectArray);
            }
            case 2: {
                return new zzav$zzz$zza(null);
            }
            case 1: 
        }
        return new zzav$zzz();
    }
}

