/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzde;
import com.google.android.gms.internal.mlkit_common.zzdf$zza$zza;
import com.google.android.gms.internal.mlkit_common.zzdg;
import com.google.android.gms.internal.mlkit_common.zzef;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzdf$zza
extends zzfq
implements zzhd {
    private static final zzfz zzd;
    private static final zzdf$zza zze;
    private static volatile zzhl zzf;
    private zzfw zzc;

    static {
        Object object;
        zzd = object = new zzdg();
        zze = object = new zzdf$zza();
        zzfq.zza(zzdf$zza.class, (zzfq)object);
    }

    private zzdf$zza() {
        zzfw zzfw2;
        this.zzc = zzfw2 = zzfq.zzk();
    }

    public static /* synthetic */ zzdf$zza zza() {
        return zze;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object object2, Object object3) {
        object2 = zzde.zza;
        byte by2 = 1;
        object -= by2;
        object = object2[object];
        object2 = null;
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
                Object object4 = zzf;
                if (object4 != null) return object4;
                object2 = zzdf$zza.class;
                synchronized (object2) {
                    object4 = zzf;
                    if (object4 != null) return object4;
                    object3 = zze;
                    zzf = object4 = new zzfq$zza((zzfq)object3);
                    return object4;
                }
            }
            case 4: {
                return zze;
            }
            case 3: {
                Object[] objectArray = new Object[2];
                objectArray[0] = "zzc";
                objectArray[by2] = object2 = zzef.zzb();
                return zzfq.zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", objectArray);
            }
            case 2: {
                return new zzdf$zza$zza(null);
            }
            case 1: 
        }
        return new zzdf$zza();
    }
}

