/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjn;
import com.google.android.gms.measurement.internal.zzjq;

public final class zzjo {
    public long zza;
    public long zzb;
    public final /* synthetic */ zzjq zzc;
    private final zzal zzd;

    public zzjo(zzjq zzjq2) {
        long l10;
        this.zzc = zzjq2;
        zzfl zzfl2 = zzjq2.zzx;
        zzjn zzjn2 = new zzjn(this, zzfl2);
        this.zzd = zzjn2;
        this.zza = l10 = zzjq2.zzx.zzax().elapsedRealtime();
        this.zzb = l10;
    }

    public final void zza(long l10) {
        ((zzge)this.zzc).zzg();
        this.zzd.zzd();
        this.zza = l10;
        this.zzb = l10;
    }

    public final void zzb(long l10) {
        this.zzd.zzd();
    }

    public final void zzc() {
        long l10;
        this.zzd.zzd();
        this.zza = l10 = 0L;
        this.zzb = l10;
    }

    public final boolean zzd(boolean n10, boolean bl2, long l10) {
        long l11;
        long l12;
        ((zzge)this.zzc).zzg();
        this.zzc.zzb();
        zzlx.zzb();
        Object object = this.zzc.zzx.zzc();
        Object object2 = zzdw.zzao;
        boolean bl3 = ((zzae)object).zzn(null, (zzdv)object2);
        if (bl3) {
            object = this.zzc.zzx;
            bl3 = ((zzfl)object).zzF();
            if (bl3) {
                object = this.zzc.zzx.zzd().zzo;
                object2 = this.zzc.zzx.zzax();
                l12 = object2.currentTimeMillis();
                ((zzeu)object).zzb(l12);
            }
        } else {
            object = this.zzc.zzx.zzd().zzo;
            object2 = this.zzc.zzx.zzax();
            l12 = object2.currentTimeMillis();
            ((zzeu)object).zzb(l12);
        }
        long l13 = this.zza;
        l13 = l10 - l13;
        if (n10 == 0 && (n10 = (l11 = l13 - (l12 = 1000L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            zzeg zzeg2 = this.zzc.zzx.zzat().zzk();
            Long l14 = l13;
            zzeg2.zzb("Screen exposed for less than 1000 ms. Event not sent. time", l14);
            return false;
        }
        if (!bl2) {
            l13 = this.zzb;
            l13 = l10 - l13;
            this.zzb = l10;
        }
        zzeg zzeg3 = this.zzc.zzx.zzat().zzk();
        Object object3 = l13;
        String string2 = "Recording user engagement, ms";
        zzeg3.zzb(string2, object3);
        zzeg3 = new Bundle();
        object3 = "_et";
        zzeg3.putLong((String)object3, l13);
        bl3 = this.zzc.zzx.zzc().zzt();
        object2 = this.zzc.zzx.zzx();
        boolean bl4 = true;
        zzib.zzm(((zzib)object2).zzh(bl3 ^= bl4), (Bundle)zzeg3, bl4);
        object = this.zzc.zzx.zzc();
        object2 = zzdw.zzT;
        bl3 = ((zzae)object).zzn(null, (zzdv)object2);
        if (!bl3 && bl2) {
            long l15 = 1L;
            object = "_fr";
            zzeg3.putLong((String)object, l15);
        }
        if (!(bl3 = ((zzae)(object = this.zzc.zzx.zzc())).zzn(null, (zzdv)object2)) || !bl2) {
            zzhn zzhn2 = this.zzc.zzx.zzk();
            object = "auto";
            object2 = "_e";
            zzhn2.zzs((String)object, (String)object2, (Bundle)zzeg3);
        }
        this.zza = l10;
        this.zzd.zzd();
        this.zzd.zzb(3600000L);
        return bl4;
    }
}

