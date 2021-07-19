/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc$zze;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzg;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzc
extends zzej
implements zzft {
    private static final zzhv$zzc zzm;
    private static volatile zzgb zzn;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf;
    private String zzg;
    private zzhv$zza zzh;
    private zzhv$zzc$zzd zzi;
    private int zzj;
    private zzes zzk;
    private int zzl;

    static {
        zzhv$zzc zzhv$zzc;
        zzm = zzhv$zzc = new zzhv$zzc();
        zzej.zza(zzhv$zzc.class, zzhv$zzc);
    }

    private zzhv$zzc() {
        Object object = "";
        this.zzf = object;
        this.zzg = object;
        this.zzk = object = zzej.zzl();
    }

    public static /* synthetic */ zzhv$zzc zza() {
        return zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzc>)zzhx.zza;
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
                clazz = zzhv$zzc.class;
                synchronized (clazz) {
                    object3 = zzn;
                    if (object3 != null) return object3;
                    object2 = zzm;
                    zzn = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzm;
            }
            case 3: {
                Object[] objectArray = new Object[13];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = object2 = zzhv$zzc$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzhv$zzc$zze.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                objectArray[10] = "zzk";
                objectArray[11] = zzhv.zzg.class;
                objectArray[12] = "zzl";
                return zzej.zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1009\u0004\u0006\u1009\u0005\u0007\u1004\u0006\b\u001b\t\u1004\u0007", objectArray);
            }
            case 2: {
                return new zzhv$zzc$zzc(null);
            }
            case 1: 
        }
        return new zzhv$zzc();
    }
}

