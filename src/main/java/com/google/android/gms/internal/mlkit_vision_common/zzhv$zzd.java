/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzd
extends zzej
implements zzft {
    private static final zzhv$zzd zzk;
    private static volatile zzgb zzl;
    private int zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private String zzi;
    private int zzj;

    static {
        zzhv$zzd zzhv$zzd;
        zzk = zzhv$zzd = new zzhv$zzd();
        zzej.zza(zzhv$zzd.class, zzhv$zzd);
    }

    private zzhv$zzd() {
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzf = string2;
        this.zzi = string2;
    }

    public static /* synthetic */ zzhv$zzd zza() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzd>)zzhx.zza;
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
                clazz = zzhv$zzd.class;
                synchronized (clazz) {
                    object3 = zzl;
                    if (object3 != null) return object3;
                    object2 = zzk;
                    zzl = object3 = new zzej$zzc((zzej)object2);
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
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                return zzej.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1004\u0003\u0005\u1004\u0004\u0006\u1008\u0005\u0007\u1004\u0006", objectArray);
            }
            case 2: {
                return new zzhv$zzd$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzd();
    }
}

