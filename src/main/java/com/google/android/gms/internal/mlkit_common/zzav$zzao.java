/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzae;
import com.google.android.gms.internal.mlkit_common.zzav$zzaf;
import com.google.android.gms.internal.mlkit_common.zzav$zzao$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzao$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzao$zzc;
import com.google.android.gms.internal.mlkit_common.zzcg;
import com.google.android.gms.internal.mlkit_common.zzch;
import com.google.android.gms.internal.mlkit_common.zzdf$zza;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzao
extends zzfq
implements zzhd {
    private static final zzfz zzg;
    private static final zzfz zzi;
    private static final zzav$zzao zzk;
    private static volatile zzhl zzl;
    private int zzc;
    private zzav$zzaf zzd;
    private zzdf.zza zze;
    private zzfw zzf;
    private zzfw zzh;
    private zzav$zzae zzj;

    static {
        Object object;
        zzg = object = new zzch();
        zzi = object = new zzcg();
        zzk = object = new zzav$zzao();
        zzfq.zza(zzav$zzao.class, (zzfq)object);
    }

    private zzav$zzao() {
        zzfw zzfw2;
        this.zzf = zzfw2 = zzfq.zzk();
        this.zzh = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzav$zzao zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzao>)zzau.zza;
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
                Object object3 = zzl;
                if (object3 != null) return object3;
                clazz = zzav$zzao.class;
                synchronized (clazz) {
                    object3 = zzl;
                    if (object3 != null) return object3;
                    object2 = zzk;
                    zzl = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzk;
            }
            case 3: {
                Object[] objectArray = new Object[8];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzav$zzao$zza.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = object2 = zzav$zzao$zzb.zzb();
                objectArray[7] = "zzj";
                return zzfq.zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u001e\u0004\u001e\u0005\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzav$zzao$zzc(null);
            }
            case 1: 
        }
        return new zzav$zzao();
    }
}

