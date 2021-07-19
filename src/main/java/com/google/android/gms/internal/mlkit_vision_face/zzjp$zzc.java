/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzc$zze;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzg;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzc
extends zzgd
implements zzhn {
    private static final zzjp$zzc zzm;
    private static volatile zzhv zzn;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf;
    private String zzg;
    private zzjp$zza zzh;
    private zzjp$zzc$zzd zzi;
    private int zzj;
    private zzgm zzk;
    private int zzl;

    static {
        zzjp$zzc zzjp$zzc;
        zzm = zzjp$zzc = new zzjp$zzc();
        zzgd.zza(zzjp$zzc.class, zzjp$zzc);
    }

    private zzjp$zzc() {
        Object object = "";
        this.zzf = object;
        this.zzg = object;
        this.zzk = object = zzgd.zzl();
    }

    public static /* synthetic */ zzjp$zzc zza() {
        return zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzc>)zzjr.zza;
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
                clazz = zzjp$zzc.class;
                synchronized (clazz) {
                    object3 = zzn;
                    if (object3 != null) return object3;
                    object2 = zzm;
                    zzn = object3 = new zzgd$zzc((zzgd)object2);
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
                objectArray[2] = object2 = zzjp$zzc$zza.zzb();
                objectArray[3] = "zze";
                objectArray[4] = object2 = zzjp$zzc$zze.zzb();
                objectArray[5] = "zzf";
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                objectArray[10] = "zzk";
                objectArray[11] = zzjp.zzg.class;
                objectArray[12] = "zzl";
                return zzgd.zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u100c\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1009\u0004\u0006\u1009\u0005\u0007\u1004\u0006\b\u001b\t\u1004\u0007", objectArray);
            }
            case 2: {
                return new zzjp$zzc$zzc(null);
            }
            case 1: 
        }
        return new zzjp$zzc();
    }
}

