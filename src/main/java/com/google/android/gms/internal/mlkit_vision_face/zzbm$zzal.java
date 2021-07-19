/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zzbm$zzal$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzbo;
import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zzhv;

public final class zzbm$zzal
extends zzgd
implements zzhn {
    private static final zzbm$zzal zzl;
    private static volatile zzhv zzm;
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
        zzbm$zzal zzbm$zzal;
        zzl = zzbm$zzal = new zzbm$zzal();
        zzgd.zza(zzbm$zzal.class, zzbm$zzal);
    }

    private zzbm$zzal() {
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzg = string2;
        this.zzh = string2;
    }

    public static /* synthetic */ zzbm$zzal zza() {
        return zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzbm$zzal>)zzbo.zza;
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
                clazz = zzbm$zzal.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzgd$zzc((zzgd)object2);
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
                objectArray[4] = object2 = zzbm$zzal$zzc.zzb();
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = object2 = zzbm$zzal$zza.zzb();
                objectArray[9] = "zzj";
                objectArray[10] = "zzk";
                return zzgd.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u100c\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u100c\u0005\u0007\u1003\u0006\b\u1007\u0007", objectArray);
            }
            case 2: {
                return new zzbm$zzal$zzb(null);
            }
            case 1: 
        }
        return new zzbm$zzal();
    }
}

