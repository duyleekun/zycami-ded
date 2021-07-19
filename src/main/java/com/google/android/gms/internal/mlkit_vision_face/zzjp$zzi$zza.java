/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;
import com.google.android.gms.internal.mlkit_vision_face.zzjp$zzi$zza$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;

public final class zzjp$zzi$zza
extends zzgd
implements zzhn {
    private static final zzjp$zzi$zza zzh;
    private static volatile zzhv zzi;
    private int zzc;
    private String zzd;
    private int zze;
    private String zzf;
    private long zzg;

    static {
        zzjp$zzi$zza zzjp$zzi$zza;
        zzh = zzjp$zzi$zza = new zzjp$zzi$zza();
        zzgd.zza(zzjp$zzi$zza.class, zzjp$zzi$zza);
    }

    private zzjp$zzi$zza() {
        String string2;
        this.zzd = string2 = "";
        this.zzf = string2;
    }

    public static /* synthetic */ zzjp$zzi$zza zza() {
        return zzh;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzjp$zzi$zza>)zzjr.zza;
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
                Object object3 = zzi;
                if (object3 != null) return object3;
                clazz = zzjp$zzi$zza.class;
                synchronized (clazz) {
                    object3 = zzi;
                    if (object3 != null) return object3;
                    object2 = zzh;
                    zzi = object3 = new zzgd$zzc((zzgd)object2);
                    return object3;
                }
            }
            case 4: {
                return zzh;
            }
            case 3: {
                Object[] objectArray = new Object[5];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = "zzf";
                objectArray[4] = "zzg";
                return zzgd.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1004\u0001\u0003\u1008\u0002\u0004\u1002\u0003", objectArray);
            }
            case 2: {
                return new zzjp$zzi$zza$zza(null);
            }
            case 1: 
        }
        return new zzjp$zzi$zza();
    }
}

