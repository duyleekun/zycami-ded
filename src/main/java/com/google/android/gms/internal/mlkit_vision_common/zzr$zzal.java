/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzal
extends zzej
implements zzft {
    private static final zzr$zzal zzl;
    private static volatile zzgb zzm;
    private int zzc;
    private String zzd;
    private String zze;
    private int zzf;
    private String zzg;
    private String zzh;
    private int zzi;
    private long zzj;
    private boolean zzk;

    static {
        zzr$zzal zzr$zzal;
        zzl = zzr$zzal = new zzr$zzal();
        zzej.zza(zzr$zzal.class, zzr$zzal);
    }

    private zzr$zzal() {
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzg = string2;
        this.zzh = string2;
    }

    public static /* synthetic */ zzr$zzal zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzal>)zzt.zza;
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
                clazz = zzr$zzal.class;
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
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzr$zzal$zzc.zzb();
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = object2 = zzr$zzal$zza.zzb();
                objectArray[9] = "zzj";
                objectArray[10] = "zzk";
                return zzej.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u100c\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u100c\u0005\u0007\u1003\u0006\b\u1007\u0007", objectArray);
            }
            case 2: {
                return new zzr$zzal$zzb(null);
            }
            case 1: 
        }
        return new zzr$zzal();
    }
}

