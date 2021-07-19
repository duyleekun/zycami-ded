/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;

public final class zzhv$zzb
extends zzej
implements zzft {
    private static final zzhv$zzb zzn;
    private static volatile zzgb zzo;
    private int zzc;
    private int zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private String zzm;

    static {
        zzhv$zzb zzhv$zzb;
        zzn = zzhv$zzb = new zzhv$zzb();
        zzej.zza(zzhv$zzb.class, zzhv$zzb);
    }

    private zzhv$zzb() {
        String string2;
        this.zze = string2 = "";
        this.zzf = string2;
        this.zzg = string2;
        this.zzh = string2;
        this.zzi = string2;
        this.zzj = string2;
        this.zzk = string2;
        this.zzl = string2;
        this.zzm = string2;
    }

    public static /* synthetic */ zzhv$zzb zza() {
        return zzn;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzhv$zzb>)zzhx.zza;
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
                Object object3 = zzo;
                if (object3 != null) return object3;
                clazz = zzhv$zzb.class;
                synchronized (clazz) {
                    object3 = zzo;
                    if (object3 != null) return object3;
                    object2 = zzn;
                    zzo = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzn;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                objectArray[8] = "zzk";
                objectArray[9] = "zzl";
                objectArray[10] = "zzm";
                return zzej.zza(zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u1008\u0005\u0007\u1008\u0006\b\u1008\u0007\t\u1008\b\n\u1008\t", objectArray);
            }
            case 2: {
                return new zzhv$zzb$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzb();
    }
}

