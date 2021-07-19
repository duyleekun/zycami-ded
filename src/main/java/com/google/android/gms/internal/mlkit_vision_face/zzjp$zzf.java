/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzf$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzl;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;
import com.google.android.gms.internal.mlkit_vision_face.zzjz;

public final class zzjp$zzf
extends zzgd
implements zzhn {
    private static final zzjp$zzf zzo;
    private static volatile zzhv zzp;
    private int zzc;
    private zzjp$zzb zzd;
    private zzjp.zzi zze;
    private zzjp$zzd zzf;
    private int zzg;
    private zzjp$zzc zzh;
    private zzjp.zzl zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private byte zzn = (byte)2;

    static {
        zzjp$zzf zzjp$zzf;
        zzo = zzjp$zzf = new zzjp$zzf();
        zzgd.zza(zzjp$zzf.class, zzjp$zzf);
    }

    private zzjp$zzf() {
    }

    public static /* synthetic */ zzjp$zzf zza() {
        return zzo;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        object2 = zzjr.zza;
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
                clazz = zzjp$zzf.class;
                synchronized (clazz) {
                    object3 = zzp;
                    if (object3 != null) return object3;
                    object2 = zzo;
                    zzp = object3 = new zzgd$zzc((zzgd)object2);
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
                objectArray[4] = object2 = zzjz.zzb();
                objectArray[5] = "zzh";
                objectArray[6] = "zzi";
                objectArray[7] = "zzj";
                objectArray[8] = "zzk";
                objectArray[9] = "zzl";
                objectArray[10] = "zzm";
                objectArray[11] = "zzf";
                return zzgd.zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001\u1009\u0000\u0002\u1009\u0001\u0003\u100c\u0003\u0004\u1009\u0004\u0005\u1409\u0005\u0006\u1002\u0006\u0007\u1002\u0007\b\u1007\b\t\u1004\t\n\u1009\u0002", objectArray);
            }
            case 2: {
                return new zzjp$zzf$zza(null);
            }
            case 1: 
        }
        return new zzjp$zzf();
    }
}

