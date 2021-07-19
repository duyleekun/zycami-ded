/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzae$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzag$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzag$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzag
extends zzej
implements zzft {
    private static final zzr$zzag zzk;
    private static volatile zzgb zzl;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzr$zzag zzr$zzag;
        zzk = zzr$zzag = new zzr$zzag();
        zzej.zza(zzr$zzag.class, zzr$zzag);
    }

    private zzr$zzag() {
    }

    public static zzr$zzag$zza zza() {
        return (zzr$zzag$zza)zzk.zzh();
    }

    private final void zza(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 1;
        this.zzd = l10;
    }

    private final void zza(zzr$zzae$zza zzr$zzae$zza) {
        int n10;
        this.zzf = n10 = zzr$zzae$zza.zza();
        this.zzc = n10 = this.zzc | 4;
    }

    private final void zza(zzr$zzag$zzb zzr$zzag$zzb) {
        int n10;
        this.zze = n10 = zzr$zzag$zzb.zza();
        this.zzc = n10 = this.zzc | 2;
    }

    public static /* synthetic */ void zza(zzr$zzag zzr$zzag, int n10) {
        zzr$zzag.zzb(n10);
    }

    public static /* synthetic */ void zza(zzr$zzag zzr$zzag, long l10) {
        zzr$zzag.zza(l10);
    }

    public static /* synthetic */ void zza(zzr$zzag zzr$zzag, zzr$zzae$zza zzr$zzae$zza) {
        zzr$zzag.zza(zzr$zzae$zza);
    }

    public static /* synthetic */ void zza(zzr$zzag zzr$zzag, zzr$zzag$zzb zzr$zzag$zzb) {
        zzr$zzag.zza(zzr$zzag$zzb);
    }

    public static /* synthetic */ zzr$zzag zzb() {
        return zzk;
    }

    private final void zzb(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 8;
        this.zzg = n10;
    }

    public static /* synthetic */ void zzb(zzr$zzag zzr$zzag, int n10) {
        zzr$zzag.zzc(n10);
    }

    private final void zzc(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 0x10;
        this.zzh = n10;
    }

    public static /* synthetic */ void zzc(zzr$zzag zzr$zzag, int n10) {
        zzr$zzag.zzd(n10);
    }

    private final void zzd(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 0x20;
        this.zzi = n10;
    }

    public static /* synthetic */ void zzd(zzr$zzag zzr$zzag, int n10) {
        zzr$zzag.zze(n10);
    }

    private final void zze(int n10) {
        int n11;
        this.zzc = n11 = this.zzc | 0x40;
        this.zzj = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzr$zzag>)zzt.zza;
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
                clazz = zzr$zzag.class;
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
                Object[] objectArray = new Object[10];
                objectArray[0] = "zzc";
                objectArray[by2] = "zzd";
                objectArray[2] = "zze";
                objectArray[3] = object2 = zzr$zzag$zzb.zzb();
                objectArray[4] = "zzf";
                objectArray[5] = object2 = zzr$zzae$zza.zzb();
                objectArray[6] = "zzg";
                objectArray[7] = "zzh";
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                return zzej.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u1003\u0000\u0002\u100c\u0001\u0003\u100c\u0002\u0004\u100b\u0003\u0005\u100b\u0004\u0006\u100b\u0005\u0007\u100b\u0006", objectArray);
            }
            case 2: {
                return new zzr$zzag$zza(null);
            }
            case 1: 
        }
        return new zzr$zzag();
    }
}

