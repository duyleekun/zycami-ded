/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzac;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzaf
extends zzej
implements zzft {
    private static final zzr$zzaf zzl;
    private static volatile zzgb zzm;
    private int zzc;
    private long zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private zzes zzk;

    static {
        zzr$zzaf zzr$zzaf;
        zzl = zzr$zzaf = new zzr$zzaf();
        zzej.zza(zzr$zzaf.class, zzr$zzaf);
    }

    private zzr$zzaf() {
        zzes zzes2;
        this.zzk = zzes2 = zzej.zzl();
    }

    public static /* synthetic */ zzr$zzaf zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzaf>)zzt.zza;
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
                clazz = zzr$zzaf.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzl;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzac.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = "zzj";
                objectArray[9] = "zzk";
                objectArray[10] = zzr.zzbf.class;
                return zzej.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u1003\u0000\u0002\u100c\u0001\u0003\u1007\u0002\u0004\u1007\u0003\u0005\u1007\u0004\u0006\u1007\u0005\u0007\u100b\u0006\b\u001b", objectArray);
            }
            case 2: {
                return new zzr$zzaf$zza(null);
            }
            case 1: 
        }
        return new zzr$zzaf();
    }
}

