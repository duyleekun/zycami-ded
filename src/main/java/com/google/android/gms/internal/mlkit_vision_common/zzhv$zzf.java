/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzd;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzf$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzi;
import com.google.android.gms.internal.mlkit_vision_common.zzhv$zzl;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;
import com.google.android.gms.internal.mlkit_vision_common.zzif;

public final class zzhv$zzf
extends zzej
implements zzft {
    private static final zzhv$zzf zzo;
    private static volatile zzgb zzp;
    private int zzc;
    private zzhv$zzb zzd;
    private zzhv.zzi zze;
    private zzhv$zzd zzf;
    private int zzg;
    private zzhv$zzc zzh;
    private zzhv.zzl zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private byte zzn = (byte)2;

    static {
        zzhv$zzf zzhv$zzf;
        zzo = zzhv$zzf = new zzhv$zzf();
        zzej.zza(zzhv$zzf.class, zzhv$zzf);
    }

    private zzhv$zzf() {
    }

    public static /* synthetic */ zzhv$zzf zza() {
        return zzo;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzhx.zza;
        int n10 = 1;
        object -= n10;
        object = object2[object];
        object2 = null;
        switch (object) {
            default: {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                throw unsupportedOperationException;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                }
                object = (byte)n10;
                this.zzn = (byte)object;
                return null;
            }
            case 6: {
                return this.zzn;
            }
            case 5: {
                Object object3 = zzp;
                if (object3 != null) return object3;
                clazz = zzhv$zzf.class;
                synchronized (clazz) {
                    object3 = zzp;
                    if (object3 != null) return object3;
                    object2 = zzo;
                    zzp = object3 = new zzej$zzc((zzej)object2);
                    return object3;
                }
            }
            case 4: {
                return zzo;
            }
            case 3: {
                Object[] objectArray = new Object[12];
                objectArray[0] = "zzc";
                objectArray[n10] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzg";
                objectArray[4] = object2 = zzif.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                objectArray[8] = "zzk";
                objectArray[9] = "zzl";
                objectArray[10] = "zzm";
                objectArray[11] = "zzf";
                return zzej.zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u100c\u0003\u0004\u1009\u0004\u0005\u1409\u0005\u0006\u1002\u0006\u0007\u1002\u0007\b\u1007\b\t\u1004\t\n\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzhv$zzf$zza(null);
            }
            case 1: 
        }
        return new zzhv$zzf();
    }
}

