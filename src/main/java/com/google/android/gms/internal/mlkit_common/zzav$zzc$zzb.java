/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzae;
import com.google.android.gms.internal.mlkit_common.zzav$zzao$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzao$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzc$zzb$zza;
import com.google.android.gms.internal.mlkit_common.zzaw;
import com.google.android.gms.internal.mlkit_common.zzax;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzdf$zza;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzc$zzb
extends zzfq
implements zzhd {
    private static final zzfz zzj;
    private static final zzfz zzl;
    private static final zzav$zzc$zzb zzm;
    private static volatile zzhl zzn;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private zzav$zzae zzg;
    private zzdf$zza zzh;
    private zzfw zzi;
    private zzfw zzk;

    static {
        Object object;
        zzj = object = new zzaw();
        zzl = object = new zzax();
        zzm = object = new zzav$zzc$zzb();
        zzfq.zza(zzav$zzc$zzb.class, (zzfq)object);
    }

    private zzav$zzc$zzb() {
        zzfw zzfw2;
        this.zzi = zzfw2 = zzfq.zzk();
        this.zzk = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzav$zzc$zzb zza() {
        return zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzc$zzb>)zzau.zza;
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
                Object object3 = zzn;
                if (object3 != null) return object3;
                clazz = zzav$zzc$zzb.class;
                synchronized (clazz) {
                    object3 = zzn;
                    if (object3 != null) return object3;
                    object2 = zzm;
                    zzn = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzm;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzbf.zzb();
                objectArray[3] = "zze";
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = object2 = zzav$zzao$zza.zzb();
                objectArray[9] = "zzk";
                objectArray[10] = object2 = zzav$zzao$zzb.zzb();
                return zzfq.zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u100c\u0000\u0002\u1007\u0001\u0003\u1007\u0002\u0004\u1009\u0003\u0005\u1009\u0004\u0006\u001e\u0007\u001e", objectArray);
            }
            case 2: {
                return new zzav$zzc$zzb$zza(null);
            }
            case 1: 
        }
        return new zzav$zzc$zzb();
    }
}

