/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zza;
import com.google.android.gms.internal.vision.zzfl$zzb;
import com.google.android.gms.internal.vision.zzfl$zzg;
import com.google.android.gms.internal.vision.zzfl$zzk$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzk
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzk zzrj;
    private int zzbm;
    private String zzov;
    private String zzpd;
    private long zzrf;
    private zzfl$zza zzrg;
    private zzfl$zzg zzrh;
    private zzfl$zzb zzri;

    static {
        zzfl$zzk zzfl$zzk;
        zzrj = zzfl$zzk = new zzfl$zzk();
        zzid.zza(zzfl$zzk.class, zzfl$zzk);
    }

    private zzfl$zzk() {
        String string2;
        this.zzpd = string2 = "";
        this.zzov = string2;
    }

    private final void setName(String string2) {
        int n10;
        string2.getClass();
        this.zzbm = n10 = this.zzbm | 1;
        this.zzpd = string2;
    }

    private final void zza(zzfl$zza zzfl$zza) {
        int n10;
        zzfl$zza.getClass();
        this.zzrg = zzfl$zza;
        this.zzbm = n10 = this.zzbm | 4;
    }

    private final void zza(zzfl$zzg zzfl$zzg) {
        int n10;
        zzfl$zzg.getClass();
        this.zzrh = zzfl$zzg;
        this.zzbm = n10 = this.zzbm | 0x10;
    }

    public static /* synthetic */ void zza(zzfl$zzk zzfl$zzk, long l10) {
        zzfl$zzk.zzp(l10);
    }

    public static /* synthetic */ void zza(zzfl$zzk zzfl$zzk, zzfl$zza zzfl$zza) {
        zzfl$zzk.zza(zzfl$zza);
    }

    public static /* synthetic */ void zza(zzfl$zzk zzfl$zzk, zzfl$zzg zzfl$zzg) {
        zzfl$zzk.zza(zzfl$zzg);
    }

    public static /* synthetic */ void zza(zzfl$zzk zzfl$zzk, String string2) {
        zzfl$zzk.setName(string2);
    }

    public static /* synthetic */ void zzb(zzfl$zzk zzfl$zzk, String string2) {
        zzfl$zzk.zzr(string2);
    }

    public static zzfl$zzk$zza zzdv() {
        return (zzfl$zzk$zza)zzrj.zzgy();
    }

    public static /* synthetic */ zzfl$zzk zzdw() {
        return zzrj;
    }

    private final void zzp(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 2;
        this.zzrf = l10;
    }

    private final void zzr(String string2) {
        int n10;
        string2.getClass();
        this.zzbm = n10 = this.zzbm | 8;
        this.zzov = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzk>)zzfk.zzbl;
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
                Object object3 = zzbk;
                if (object3 != null) return object3;
                clazz = zzfl$zzk.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzrj;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzrj;
            }
            case 3: {
                Object[] objectArray = new Object[7];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzpd";
                objectArray[2] = "zzrf";
                objectArray[3] = "zzrg";
                objectArray[4] = "zzov";
                objectArray[5] = "zzrh";
                objectArray[6] = "zzri";
                return zzid.zza((zzjn)zzrj, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1002\u0001\u0003\u1009\u0002\u0006\u1008\u0003\u0010\u1009\u0004\u0011\u1009\u0005", objectArray);
            }
            case 2: {
                return new zzfl$zzk$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzk();
    }
}

