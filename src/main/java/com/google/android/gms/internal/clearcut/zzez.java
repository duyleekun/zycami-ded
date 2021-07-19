/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzex;
import com.google.android.gms.internal.clearcut.zzey;
import com.google.android.gms.internal.clearcut.zzfr;

public final class zzez
extends zzex {
    private static void zza(Object object, zzey zzey2) {
        ((zzcg)object).zzjp = zzey2;
    }

    public final /* synthetic */ void zza(Object object, int n10, long l10) {
        object = (zzey)object;
        Long l11 = l10;
        ((zzey)object).zzb(n10 <<= 3, l11);
    }

    public final /* synthetic */ void zza(Object object, int n10, zzbb zzbb2) {
        object = (zzey)object;
        n10 = n10 << 3 | 2;
        ((zzey)object).zzb(n10, zzbb2);
    }

    public final /* synthetic */ void zza(Object object, zzfr zzfr2) {
        ((zzey)object).zzb(zzfr2);
    }

    public final void zzc(Object object) {
        ((zzcg)object).zzjp.zzv();
    }

    public final /* synthetic */ void zzc(Object object, zzfr zzfr2) {
        ((zzey)object).zza(zzfr2);
    }

    public final /* synthetic */ Object zzdz() {
        return zzey.zzeb();
    }

    public final /* synthetic */ void zze(Object object, Object object2) {
        object2 = (zzey)object2;
        zzez.zza(object, (zzey)object2);
    }

    public final /* synthetic */ void zzf(Object object, Object object2) {
        object2 = (zzey)object2;
        zzez.zza(object, (zzey)object2);
    }

    public final /* synthetic */ Object zzg(Object object, Object object2) {
        object = (zzey)object;
        zzey zzey2 = zzey.zzea();
        boolean bl2 = ((zzey)(object2 = (zzey)object2)).equals(zzey2);
        if (bl2) {
            return object;
        }
        return zzey.zza((zzey)object, (zzey)object2);
    }

    public final /* synthetic */ int zzm(Object object) {
        return ((zzey)object).zzas();
    }

    public final /* synthetic */ Object zzq(Object object) {
        return ((zzcg)object).zzjp;
    }

    public final /* synthetic */ int zzr(Object object) {
        return ((zzey)object).zzec();
    }
}

