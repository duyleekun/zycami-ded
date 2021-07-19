/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjw;
import com.google.android.gms.internal.measurement.zzjx;

public final class zzjb
implements zzji {
    private final zzix zza;
    private final zzjw zzb;
    private final boolean zzc;
    private final zzhf zzd;

    private zzjb(zzjw zzjw2, zzhf zzhf2, zzix zzix2) {
        boolean bl2;
        this.zzb = zzjw2;
        this.zzc = bl2 = zzhf2.zza(zzix2);
        this.zzd = zzhf2;
        this.zza = zzix2;
    }

    public static zzjb zzf(zzjw zzjw2, zzhf zzhf2, zzix zzix2) {
        zzjb zzjb2 = new zzjb(zzjw2, zzhf2, zzix2);
        return zzjb2;
    }

    public final Object zza() {
        return this.zza.zzbH().zzaD();
    }

    public final boolean zzb(Object object, Object object2) {
        Object object3;
        Object object4 = this.zzb.zzd(object);
        boolean bl2 = object4.equals(object3 = this.zzb.zzd(object2));
        if (!bl2) {
            return false;
        }
        bl2 = this.zzc;
        if (!bl2) {
            return true;
        }
        this.zzd.zzb(object);
        this.zzd.zzb(object2);
        throw null;
    }

    public final int zzc(Object object) {
        Object object2 = this.zzb.zzd(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.zzc;
        if (!bl2) {
            return n10;
        }
        this.zzd.zzb(object);
        throw null;
    }

    public final void zzd(Object object, Object object2) {
        Object object3 = this.zzb;
        zzjk.zzF((zzjw)object3, object, object2);
        boolean bl2 = this.zzc;
        if (bl2) {
            object3 = this.zzd;
            zzjk.zzE((zzhf)object3, object, object2);
        }
    }

    public final int zze(Object object) {
        zzjw zzjw2 = this.zzb;
        Object object2 = zzjw2.zzd(object);
        int n10 = zzjw2.zzg(object2);
        boolean bl2 = this.zzc;
        if (!bl2) {
            return n10;
        }
        this.zzd.zzb(object);
        throw null;
    }

    public final void zzh(Object object, byte[] object2, int n10, int n11, zzge zzge2) {
        object2 = object;
        object2 = (zzhs)object;
        zzjx zzjx2 = object2.zzc;
        zzjx zzjx3 = zzjx.zza();
        if (zzjx2 == zzjx3) {
            object2.zzc = zzjx2 = zzjx.zzb();
        }
        object = (zzhp)object;
        throw null;
    }

    public final void zzi(Object object) {
        this.zzb.zze(object);
        this.zzd.zzc(object);
    }

    public final boolean zzj(Object object) {
        this.zzd.zzb(object);
        throw null;
    }

    public final void zzm(Object object, zzha zzha2) {
        this.zzd.zzb(object);
        throw null;
    }
}

