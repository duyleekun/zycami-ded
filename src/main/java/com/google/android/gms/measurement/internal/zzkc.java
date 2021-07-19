/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzjw;
import com.google.android.gms.measurement.internal.zzkd;
import java.util.ArrayList;
import java.util.List;

public final class zzkc {
    public zzdj zza;
    public List zzb;
    public List zzc;
    public long zzd;
    public final /* synthetic */ zzkd zze;

    public /* synthetic */ zzkc(zzkd zzkd2, zzjw zzjw2) {
        this.zze = zzkd2;
    }

    private static final long zzb(zzdb zzdb2) {
        long l10 = zzdb2.zzf() / 1000L;
        long l11 = 60;
        return l10 / l11 / l11;
    }

    public final boolean zza(long l10, zzdb object) {
        long l11;
        long l12;
        long l13;
        int n10;
        Preconditions.checkNotNull(object);
        Object object2 = this.zzc;
        if (object2 == null) {
            object2 = new ArrayList();
            this.zzc = object2;
        }
        if ((object2 = this.zzb) == null) {
            object2 = new ArrayList();
            this.zzb = object2;
        }
        if ((n10 = (object2 = this.zzc).size()) > 0 && (n10 = (int)((l13 = (l12 = zzkc.zzb((zzdb)(object2 = (zzdb)this.zzc.get(0)))) - (l11 = zzkc.zzb((zzdb)object))) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            return false;
        }
        l12 = this.zzd;
        l11 = ((zzhs)object).zzbw();
        this.zze.zzd();
        object2 = (Integer)zzdw.zzh.zzb(null);
        n10 = (Integer)object2;
        long l14 = Math.max(0, n10);
        long l15 = (l12 += l11) - l14;
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 >= 0) {
            return false;
        }
        this.zzd = l12;
        object2 = this.zzc;
        object2.add(object);
        object = this.zzb;
        Object object3 = l10;
        object.add(object3);
        object3 = this.zzc;
        int n11 = object3.size();
        this.zze.zzd();
        Integer n12 = (Integer)zzdw.zzi.zzb(null);
        int n13 = n12;
        boolean bl2 = true;
        n13 = Math.max((int)(bl2 ? 1 : 0), n13);
        if (n11 >= n13) {
            return false;
        }
        return bl2;
    }
}

