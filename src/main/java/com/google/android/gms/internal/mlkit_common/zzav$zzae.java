/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzae$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzae$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzae
extends zzfq
implements zzhd {
    private static final zzav$zzae zzg;
    private static volatile zzhl zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzav$zzae zzav$zzae;
        zzg = zzav$zzae = new zzav$zzae();
        zzfq.zza(zzav$zzae.class, zzav$zzae);
    }

    private zzav$zzae() {
    }

    public static /* synthetic */ zzav$zzae zza() {
        return zzg;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzae>)zzau.zza;
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
                clazz = zzav$zzae.class;
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
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzav$zzae$zzb.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                return zzfq.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100b\u0001\u0003\u100b\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzae$zza(null);
            }
            case 1: 
        }
        return new zzav$zzae();
    }
}

