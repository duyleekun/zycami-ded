/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzas$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzat;
import com.google.android.gms.internal.mlkit_common.zzav$zzbf;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzcm;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzas
extends zzfq
implements zzhd {
    private static final zzfz zzf;
    private static final zzav$zzas zzj;
    private static volatile zzhl zzk;
    private int zzc;
    private zzav$zzat zzd;
    private zzfw zze;
    private long zzg;
    private long zzh;
    private zzfy zzi;

    static {
        Object object;
        zzf = object = new zzcm();
        zzj = object = new zzav$zzas();
        zzfq.zza(zzav$zzas.class, (zzfq)object);
    }

    private zzav$zzas() {
        zzfy zzfy2;
        this.zze = zzfy2 = zzfq.zzk();
        zzfy2 = zzfq.zzl();
        this.zzi = zzfy2;
    }

    public static /* synthetic */ zzav$zzas zza() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzas>)zzau.zza;
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
                clazz = zzav$zzas.class;
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
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzbf.zzb();
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = zzav$zzbf.class;
                return zzfq.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u001e\u0003\u1003\u0001\u0004\u1003\u0002\u0005\u001b", objectArray);
            }
            case 2: {
                return new zzav$zzas$zza(null);
            }
            case 1: 
        }
        return new zzav$zzas();
    }
}

