/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzal$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzal$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzal$zzc;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzal
extends zzfq
implements zzhd {
    private static final zzav$zzal zzl;
    private static volatile zzhl zzm;
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
        zzav$zzal zzav$zzal;
        zzl = zzav$zzal = new zzav$zzal();
        zzfq.zza(zzav$zzal.class, zzav$zzal);
    }

    private zzav$zzal() {
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzg = string2;
        this.zzh = string2;
    }

    public static zzav$zzal$zza zza() {
        return (zzav$zzal$zza)zzl.zzh();
    }

    private final void zza(zzav$zzal$zzb zzav$zzal$zzb) {
        int n10;
        this.zzi = n10 = zzav$zzal$zzb.zza();
        this.zzc = n10 = this.zzc | 0x20;
    }

    private final void zza(zzav$zzal$zzc zzav$zzal$zzc) {
        int n10;
        this.zzf = n10 = zzav$zzal$zzc.zza();
        this.zzc = n10 = this.zzc | 4;
    }

    public static /* synthetic */ void zza(zzav$zzal zzav$zzal, zzav$zzal$zzb zzav$zzal$zzb) {
        zzav$zzal.zza(zzav$zzal$zzb);
    }

    public static /* synthetic */ void zza(zzav$zzal zzav$zzal, zzav$zzal$zzc zzav$zzal$zzc) {
        zzav$zzal.zza(zzav$zzal$zzc);
    }

    public static /* synthetic */ void zza(zzav$zzal zzav$zzal, String string2) {
        zzav$zzal.zza(string2);
    }

    private final void zza(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 1;
        this.zzd = string2;
    }

    public static /* synthetic */ zzav$zzal zzb() {
        return zzl;
    }

    public static /* synthetic */ void zzb(zzav$zzal zzav$zzal, String string2) {
        zzav$zzal.zzb(string2);
    }

    private final void zzb(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 0x10;
        this.zzh = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzal>)zzau.zza;
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
                clazz = zzav$zzal.class;
                synchronized (clazz) {
                    object3 = zzm;
                    if (object3 != null) return object3;
                    object2 = zzl;
                    zzm = object3 = new zzfq$zza((zzfq)object2);
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
                objectArray[4] = object2 = zzav$zzal$zzc.zzb();
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = "zzi";
                objectArray[8] = object2 = zzav$zzal$zzb.zzb();
                objectArray[9] = "zzj";
                objectArray[10] = "zzk";
                return zzfq.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u100c\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u100c\u0005\u0007\u1003\u0006\b\u1007\u0007", objectArray);
            }
            case 2: {
                return new zzav$zzal$zza(null);
            }
            case 1: 
        }
        return new zzav$zzal();
    }
}

