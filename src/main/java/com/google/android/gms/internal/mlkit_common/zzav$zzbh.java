/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.internal.mlkit_common.zzav$zzbh$zza;
import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zza;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhl;

public final class zzav$zzbh
extends zzfq
implements zzhd {
    private static final zzav$zzbh zzo;
    private static volatile zzhl zzp;
    private int zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private zzfy zzk;
    private String zzl;
    private boolean zzm;
    private boolean zzn;

    static {
        zzav$zzbh zzav$zzbh;
        zzo = zzav$zzbh = new zzav$zzbh();
        zzfq.zza(zzav$zzbh.class, zzav$zzbh);
    }

    private zzav$zzbh() {
        zzfy zzfy2;
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzf = string2;
        this.zzg = string2;
        this.zzh = string2;
        this.zzi = string2;
        this.zzj = string2;
        this.zzk = zzfy2 = zzfq.zzl();
        this.zzl = string2;
    }

    public static zzav$zzbh$zza zza(zzav$zzbh zzav$zzbh) {
        return (zzav$zzbh$zza)zzo.zza(zzav$zzbh);
    }

    public static /* synthetic */ void zza(zzav$zzbh zzav$zzbh, Iterable iterable) {
        zzav$zzbh.zza(iterable);
    }

    public static /* synthetic */ void zza(zzav$zzbh zzav$zzbh, String string2) {
        zzav$zzbh.zza(string2);
    }

    public static /* synthetic */ void zza(zzav$zzbh zzav$zzbh, boolean bl2) {
        zzav$zzbh.zza(true);
    }

    private final void zza(Iterable iterable) {
        zzfy zzfy2 = this.zzk;
        int n10 = zzfy2.zza();
        if (n10 == 0) {
            n10 = zzfy2.size();
            n10 = n10 == 0 ? 10 : (n10 <<= 1);
            this.zzk = zzfy2 = zzfy2.zzb(n10);
        }
        zzfy2 = this.zzk;
        zzeg.zza(iterable, zzfy2);
    }

    private final void zza(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 1;
        this.zzd = string2;
    }

    private final void zza(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 0x100;
        this.zzm = true;
    }

    public static zzav$zzbh$zza zzb() {
        return (zzav$zzbh$zza)zzo.zzh();
    }

    public static /* synthetic */ void zzb(zzav$zzbh zzav$zzbh, String string2) {
        zzav$zzbh.zzb(string2);
    }

    public static /* synthetic */ void zzb(zzav$zzbh zzav$zzbh, boolean bl2) {
        zzav$zzbh.zzb(true);
    }

    private final void zzb(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 2;
        this.zze = string2;
    }

    private final void zzb(boolean bl2) {
        int n10;
        this.zzc = n10 = this.zzc | 0x200;
        this.zzn = true;
    }

    public static zzav$zzbh zzc() {
        return zzo;
    }

    public static /* synthetic */ void zzc(zzav$zzbh zzav$zzbh, String string2) {
        zzav$zzbh.zzc(string2);
    }

    private final void zzc(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 8;
        this.zzg = string2;
    }

    public static /* synthetic */ zzav$zzbh zzd() {
        return zzo;
    }

    public static /* synthetic */ void zzd(zzav$zzbh zzav$zzbh, String string2) {
        zzav$zzbh.zzd(string2);
    }

    private final void zzd(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 0x10;
        this.zzh = string2;
    }

    public static /* synthetic */ void zze(zzav$zzbh zzav$zzbh, String string2) {
        zzav$zzbh.zze(string2);
    }

    private final void zze(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 0x80;
        this.zzl = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzav$zzbh>)zzau.zza;
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
                Object object3 = zzp;
                if (object3 != null) return object3;
                clazz = zzav$zzbh.class;
                synchronized (clazz) {
                    object3 = zzp;
                    if (object3 != null) return object3;
                    object2 = zzo;
                    zzp = object3 = new zzfq$zza((zzfq)object2);
                    return object3;
                }
            }
            case 4: {
                return zzo;
            }
            case 3: {
                Object[] objectArray = new Object[12];
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
                objectArray[11] = "zzn";
                return zzfq.zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u1008\u0005\u0007\u1008\u0006\b\u001a\t\u1008\u0007\n\u1007\b\u000b\u1007\t", objectArray);
            }
            case 2: {
                return new zzav$zzbh$zza(null);
            }
            case 1: 
        }
        return new zzav$zzbh();
    }

    public final String zza() {
        return this.zzh;
    }
}

