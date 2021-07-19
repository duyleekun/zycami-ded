/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzbg$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzbg$zzb;
import com.google.android.gms.internal.mlkit_common.zzcz;
import com.google.android.gms.internal.mlkit_common.zzda;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzbg
extends zzfq
implements zzhd {
    private static final zzfz zzf;
    private static final zzfz zzh;
    private static final zzfz zzj;
    private static final zzav$zzbg zzl;
    private static volatile zzhl zzm;
    private int zzc;
    private long zzd;
    private zzfw zze;
    private zzfw zzg;
    private zzfw zzi;
    private int zzk;

    static {
        Object object;
        zzf = object = new zzcz();
        zzh = object = new zzdb();
        zzj = object = new zzda();
        zzl = object = new zzav$zzbg();
        zzfq.zza(zzav$zzbg.class, (zzfq)object);
    }

    private zzav$zzbg() {
        zzfw zzfw2;
        this.zze = zzfw2 = zzfq.zzk();
        this.zzg = zzfw2 = zzfq.zzk();
        this.zzi = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzav$zzbg zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzbg>)zzau.zza;
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
                Object object3 = zzm;
                if (object3 != null) return object3;
                clazz = zzav$zzbg.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzl;
            }
            case 3: {
                Object[] objectArray = new Object[9];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzav$zzbg$zza.zzb();
                objectArray[4] = "zzg";
                objectArray[5] = object2 = zzav$zzbg$zza.zzb();
                objectArray[6] = "zzi";
                objectArray[7] = object2 = zzav$zzbg$zza.zzb();
                objectArray[8] = "zzk";
                return zzfq.zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u1003\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005\u1004\u0001", objectArray);
            }
            case 2: {
                return new zzav$zzbg$zzb(null);
            }
            case 1: 
        }
        return new zzav$zzbg();
    }
}

