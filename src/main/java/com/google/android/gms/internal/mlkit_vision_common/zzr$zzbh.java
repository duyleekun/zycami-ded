/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzc;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzft;
import com.google.android.gms.internal.mlkit_vision_common.zzgb;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzt;

public final class zzr$zzbh
extends zzej
implements zzft {
    private static final zzr$zzbh zzo;
    private static volatile zzgb zzp;
    private int zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private zzes zzk;
    private String zzl;
    private boolean zzm;
    private boolean zzn;

    static {
        zzr$zzbh zzr$zzbh;
        zzo = zzr$zzbh = new zzr$zzbh();
        zzej.zza(zzr$zzbh.class, zzr$zzbh);
    }

    private zzr$zzbh() {
        zzes zzes2;
        String string2;
        this.zzd = string2 = "";
        this.zze = string2;
        this.zzf = string2;
        this.zzg = string2;
        this.zzh = string2;
        this.zzi = string2;
        this.zzj = string2;
        this.zzk = zzes2 = zzej.zzl();
        this.zzl = string2;
    }

    public static zzr$zzbh$zza zza(zzr$zzbh zzr$zzbh) {
        return (zzr$zzbh$zza)zzo.zza(zzr$zzbh);
    }

    public static /* synthetic */ void zza(zzr$zzbh zzr$zzbh, Iterable iterable) {
        zzr$zzbh.zza(iterable);
    }

    public static /* synthetic */ void zza(zzr$zzbh zzr$zzbh, String string2) {
        zzr$zzbh.zza(string2);
    }

    public static /* synthetic */ void zza(zzr$zzbh zzr$zzbh, boolean bl2) {
        zzr$zzbh.zza(true);
    }

    private final void zza(Iterable iterable) {
        zzes zzes2 = this.zzk;
        int n10 = zzes2.zza();
        if (n10 == 0) {
            n10 = zzes2.size();
            n10 = n10 == 0 ? 10 : (n10 <<= 1);
            this.zzk = zzes2 = zzes2.zzb(n10);
        }
        zzes2 = this.zzk;
        zzda.zza(iterable, zzes2);
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

    public static zzr$zzbh$zza zzb() {
        return (zzr$zzbh$zza)zzo.zzh();
    }

    public static /* synthetic */ void zzb(zzr$zzbh zzr$zzbh, String string2) {
        zzr$zzbh.zzb(string2);
    }

    public static /* synthetic */ void zzb(zzr$zzbh zzr$zzbh, boolean bl2) {
        zzr$zzbh.zzb(true);
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

    public static zzr$zzbh zzc() {
        return zzo;
    }

    public static /* synthetic */ void zzc(zzr$zzbh zzr$zzbh, String string2) {
        zzr$zzbh.zzc(string2);
    }

    private final void zzc(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 8;
        this.zzg = string2;
    }

    public static /* synthetic */ zzr$zzbh zzd() {
        return zzo;
    }

    public static /* synthetic */ void zzd(zzr$zzbh zzr$zzbh, String string2) {
        zzr$zzbh.zzd(string2);
    }

    private final void zzd(String string2) {
        int n10;
        string2.getClass();
        this.zzc = n10 = this.zzc | 0x10;
        this.zzh = string2;
    }

    public static /* synthetic */ void zze(zzr$zzbh zzr$zzbh, String string2) {
        zzr$zzbh.zze(string2);
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
        clazz = (Class<zzr$zzbh>)zzt.zza;
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
                clazz = zzr$zzbh.class;
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
                return zzej.zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u1008\u0005\u0007\u1008\u0006\b\u001a\t\u1008\u0007\n\u1007\b\u000b\u1007\t", objectArray);
            }
            case 2: {
                return new zzr$zzbh$zza(null);
            }
            case 1: 
        }
        return new zzr$zzbh();
    }

    public final String zza() {
        return this.zzh;
    }
}

