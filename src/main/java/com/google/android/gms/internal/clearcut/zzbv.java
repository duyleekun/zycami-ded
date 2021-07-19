/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbu;
import com.google.android.gms.internal.clearcut.zzbw;
import com.google.android.gms.internal.clearcut.zzby;
import com.google.android.gms.internal.clearcut.zzcg$zzd;
import com.google.android.gms.internal.clearcut.zzcg$zze;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzea;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzfr;
import java.util.Map;

public final class zzbv
extends zzbu {
    public final int zza(Map.Entry entry) {
        return ((zzcg$zze)entry.getKey()).number;
    }

    public final zzby zza(Object object) {
        return ((zzcg$zzd)object).zzjv;
    }

    public final void zza(zzfr zzfr2, Map.Entry object) {
        zzcg$zze zzcg$zze = (zzcg$zze)object.getKey();
        Object object2 = zzbw.zzgq;
        Object object3 = zzcg$zze.zzjx;
        int n10 = ((Enum)object3).ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                break;
            }
            case 18: {
                int n12 = zzcg$zze.number;
                object2 = object.getValue();
                object3 = zzea.zzcm();
                object = object.getValue().getClass();
                object = ((zzea)object3).zze((Class)object);
                zzfr2.zza(n12, object2, (zzef)object);
                break;
            }
            case 17: {
                int n13 = zzcg$zze.number;
                object2 = object.getValue();
                object3 = zzea.zzcm();
                object = object.getValue().getClass();
                object = ((zzea)object3).zze((Class)object);
                zzfr2.zzb(n13, object2, (zzef)object);
                return;
            }
            case 16: {
                int n14 = zzcg$zze.number;
                object = (String)object.getValue();
                zzfr2.zza(n14, (String)object);
                return;
            }
            case 15: {
                int n15 = zzcg$zze.number;
                object = (zzbb)object.getValue();
                zzfr2.zza(n15, (zzbb)object);
                return;
            }
            case 14: {
                int n16 = zzcg$zze.number;
                int n17 = (Integer)object.getValue();
                zzfr2.zzc(n16, n17);
                return;
            }
            case 13: {
                int n18 = zzcg$zze.number;
                long l10 = (Long)object.getValue();
                zzfr2.zzb(n18, l10);
                return;
            }
            case 12: {
                int n19 = zzcg$zze.number;
                int n20 = (Integer)object.getValue();
                zzfr2.zze(n19, n20);
                return;
            }
            case 11: {
                int n21 = zzcg$zze.number;
                long l11 = (Long)object.getValue();
                zzfr2.zzj(n21, l11);
                return;
            }
            case 10: {
                int n22 = zzcg$zze.number;
                int n23 = (Integer)object.getValue();
                zzfr2.zzm(n22, n23);
                return;
            }
            case 9: {
                int n24 = zzcg$zze.number;
                int n25 = (Integer)object.getValue();
                zzfr2.zzd(n24, n25);
                return;
            }
            case 8: {
                int n26 = zzcg$zze.number;
                boolean bl2 = (Boolean)object.getValue();
                zzfr2.zzb(n26, bl2);
                return;
            }
            case 7: {
                int n27 = zzcg$zze.number;
                int n28 = (Integer)object.getValue();
                zzfr2.zzf(n27, n28);
                return;
            }
            case 6: {
                int n29 = zzcg$zze.number;
                long l12 = (Long)object.getValue();
                zzfr2.zzc(n29, l12);
                return;
            }
            case 5: {
                int n30 = zzcg$zze.number;
                int n31 = (Integer)object.getValue();
                zzfr2.zzc(n30, n31);
                return;
            }
            case 4: {
                int n32 = zzcg$zze.number;
                long l13 = (Long)object.getValue();
                zzfr2.zza(n32, l13);
                return;
            }
            case 3: {
                int n33 = zzcg$zze.number;
                long l14 = (Long)object.getValue();
                zzfr2.zzi(n33, l14);
                return;
            }
            case 2: {
                int n34 = zzcg$zze.number;
                float f10 = ((Float)object.getValue()).floatValue();
                zzfr2.zza(n34, f10);
                return;
            }
            case 1: {
                int n35 = zzcg$zze.number;
                object = (Double)object.getValue();
                double d10 = (Double)object;
                zzfr2.zza(n35, d10);
            }
        }
    }

    public final void zza(Object object, zzby zzby2) {
        ((zzcg$zzd)object).zzjv = zzby2;
    }

    public final zzby zzb(Object object) {
        zzby zzby2 = ((zzbu)this).zza(object);
        boolean bl2 = zzby2.isImmutable();
        if (bl2) {
            zzby2 = (zzby)zzby2.clone();
            ((zzbu)this).zza(object, zzby2);
        }
        return zzby2;
    }

    public final void zzc(Object object) {
        ((zzbu)this).zza(object).zzv();
    }

    public final boolean zze(zzdo zzdo2) {
        return zzdo2 instanceof zzcg$zzd;
    }
}

