/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzak$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzak$zzb;
import com.google.android.gms.internal.mlkit_common.zzav$zzam;
import com.google.android.gms.internal.mlkit_common.zzbf;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzak
extends zzfq
implements zzhd {
    private static final zzav$zzak zzk;
    private static volatile zzhl zzl;
    private int zzc;
    private zzav$zzam zzd;
    private long zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private zzfw zzj;

    static {
        zzav$zzak zzav$zzak;
        zzk = zzav$zzak = new zzav$zzak();
        zzfq.zza(zzav$zzak.class, zzav$zzak);
    }

    private zzav$zzak() {
        zzfw zzfw2;
        this.zzj = zzfw2 = zzfq.zzk();
    }

    public static zzav$zzak$zzb zza() {
        return (zzav$zzak$zzb)zzk.zzh();
    }

    private final void zza(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 2;
        this.zze = l10;
    }

    private final void zza(zzav$zzak$zza zzav$zzak$zza) {
        int n10;
        this.zzh = n10 = zzav$zzak$zza.zza();
        this.zzc = n10 = this.zzc | 0x10;
    }

    public static /* synthetic */ void zza(zzav$zzak zzav$zzak, long l10) {
        zzav$zzak.zza(l10);
    }

    public static /* synthetic */ void zza(zzav$zzak zzav$zzak, zzav$zzak$zza zzav$zzak$zza) {
        zzav$zzak.zza(zzav$zzak$zza);
    }

    public static /* synthetic */ void zza(zzav$zzak zzav$zzak, zzav$zzam zzav$zzam) {
        zzav$zzak.zza(zzav$zzam);
    }

    public static /* synthetic */ void zza(zzav$zzak zzav$zzak, zzbf zzbf2) {
        zzav$zzak.zza(zzbf2);
    }

    private final void zza(zzav$zzam zzav$zzam) {
        int n10;
        zzav$zzam.getClass();
        this.zzd = zzav$zzam;
        this.zzc = n10 = this.zzc | 1;
    }

    private final void zza(zzbf zzbf2) {
        int n10;
        this.zzf = n10 = zzbf2.zza();
        this.zzc = n10 = this.zzc | 4;
    }

    public static /* synthetic */ zzav$zzak zzb() {
        return zzk;
    }

    private final void zzb(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 8;
        this.zzg = l10;
    }

    public static /* synthetic */ void zzb(zzav$zzak zzav$zzak, long l10) {
        zzav$zzak.zzb(l10);
    }

    private final void zzc(long l10) {
        int n10;
        this.zzc = n10 = this.zzc | 0x20;
        this.zzi = l10;
    }

    public static /* synthetic */ void zzc(zzav$zzak zzav$zzak, long l10) {
        zzav$zzak.zzc(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzak>)zzau.zza;
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
                clazz = zzav$zzak.class;
                synchronized (clazz) {
                    object3 = zzl;
                    if (object3 != null) return object3;
                    object2 = zzk;
                    zzl = object3 = new zzfq$zza((zzfq)object2);
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
                objectArray[3] = "zzf";
                objectArray[4] = object2 = zzbf.zzb();
                objectArray[5] = "zzg";
                objectArray[6] = "zzh";
                objectArray[7] = object2 = zzav$zzak$zza.zzb();
                objectArray[8] = "zzi";
                objectArray[9] = "zzj";
                return zzfq.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u1003\u0001\u0003\u100c\u0002\u0004\u1003\u0003\u0005\u100c\u0004\u0006\u1002\u0005\u0007\u0016", objectArray);
            }
            case 2: {
                return new zzav$zzak$zzb(null);
            }
            case 1: 
        }
        return new zzav$zzak();
    }
}

