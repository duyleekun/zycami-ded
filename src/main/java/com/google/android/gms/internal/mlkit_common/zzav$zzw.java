/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzae;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf;
import com.google.android.gms.internal.mlkit_common.zzav$zzn;
import com.google.android.gms.internal.mlkit_common.zzav$zzw$zza;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzw
extends zzfq
implements zzhd {
    private static final zzav$zzw zzg;
    private static volatile zzhl zzh;
    private int zzc;
    private zzav$zzaf zzd;
    private zzav$zzn zze;
    private zzav$zzae zzf;

    static {
        zzav$zzw zzav$zzw;
        zzg = zzav$zzw = new zzav$zzw();
        zzfq.zza(zzav$zzw.class, zzav$zzw);
    }

    private zzav$zzw() {
    }

    public static /* synthetic */ zzav$zzw zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzw>)zzau.zza;
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
                Object object3 = zzh;
                if (object3 != null) return object3;
                clazz = zzav$zzw.class;
                synchronized (clazz) {
                    object3 = zzh;
                    if (object3 != null) return object3;
                    object2 = zzg;
                    zzh = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzg;
            }
            case 3: {
                Object[] objectArray = new Object[4];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                return zzfq.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzw$zza(null);
            }
            case 1: 
        }
        return new zzav$zzw();
    }
}

