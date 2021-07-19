/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzf$zza;
import com.google.android.gms.internal.vision.zzfl$zzf$zzb;
import com.google.android.gms.internal.vision.zzfl$zzn;
import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzc;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzjw;

public final class zzfl$zzf
extends zzid
implements zzjp {
    private static volatile zzjw zzbk;
    private static final zzfl$zzf zzpl;
    private int zzbm;
    private String zzpd;
    private String zzpe;
    private zzik zzpf;
    private int zzpg;
    private String zzph;
    private long zzpi;
    private long zzpj;
    private zzik zzpk;

    static {
        zzfl$zzf zzfl$zzf;
        zzpl = zzfl$zzf = new zzfl$zzf();
        zzid.zza(zzfl$zzf.class, zzfl$zzf);
    }

    private zzfl$zzf() {
        zzik zzik2;
        Object object = "";
        this.zzpd = object;
        this.zzpe = object;
        this.zzpf = zzik2 = zzid.zzhb();
        this.zzph = object;
        this.zzpk = object = zzid.zzhb();
    }

    private final void setName(String string2) {
        int n10;
        string2.getClass();
        this.zzbm = n10 = this.zzbm | 1;
        this.zzpd = string2;
    }

    public static /* synthetic */ void zza(zzfl$zzf zzfl$zzf, long l10) {
        zzfl$zzf.zzf(l10);
    }

    public static /* synthetic */ void zza(zzfl$zzf zzfl$zzf, Iterable iterable) {
        zzfl$zzf.zzd(iterable);
    }

    public static /* synthetic */ void zza(zzfl$zzf zzfl$zzf, String string2) {
        zzfl$zzf.setName(string2);
    }

    public static /* synthetic */ void zzb(zzfl$zzf zzfl$zzf, long l10) {
        zzfl$zzf.zzg(l10);
    }

    private final void zzd(Iterable iterable) {
        zzik zzik2 = this.zzpk;
        boolean bl2 = zzik2.zzei();
        if (!bl2) {
            this.zzpk = zzik2 = zzid.zza(zzik2);
        }
        zzik2 = this.zzpk;
        zzge.zza(iterable, zzik2);
    }

    public static zzfl$zzf$zza zzdk() {
        return (zzfl$zzf$zza)zzpl.zzgy();
    }

    public static /* synthetic */ zzfl$zzf zzdl() {
        return zzpl;
    }

    private final void zzf(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x10;
        this.zzpi = l10;
    }

    private final void zzg(long l10) {
        int n10;
        this.zzbm = n10 = this.zzbm | 0x20;
        this.zzpj = l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zza(int object, Object clazz, Object object2) {
        clazz = (Class<zzfl$zzf>)zzfk.zzbl;
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
                clazz = zzfl$zzf.class;
                synchronized (clazz) {
                    object3 = zzbk;
                    if (object3 != null) return object3;
                    object2 = zzpl;
                    zzbk = object3 = new zzid$zzc((zzid)object2);
                    return object3;
                }
            }
            case 4: {
                return zzpl;
            }
            case 3: {
                Object[] objectArray = new Object[11];
                objectArray[0] = "zzbm";
                objectArray[by2] = "zzpd";
                objectArray[2] = "zzpe";
                objectArray[3] = "zzpf";
                objectArray[4] = "zzpg";
                objectArray[5] = object2 = zzfl$zzf$zzb.zzal();
                objectArray[6] = "zzph";
                objectArray[7] = "zzpi";
                objectArray[8] = "zzpj";
                objectArray[9] = "zzpk";
                objectArray[10] = zzfl$zzn.class;
                return zzid.zza((zzjn)zzpl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u001a\u0004\u100c\u0002\u0005\u1008\u0003\u0006\u1002\u0004\u0007\u1002\u0005\b\u001b", objectArray);
            }
            case 2: {
                return new zzfl$zzf$zza(null);
            }
            case 1: 
        }
        return new zzfl$zzf();
    }
}

