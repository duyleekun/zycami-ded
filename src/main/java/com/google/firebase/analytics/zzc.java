/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzgl;
import com.google.android.gms.measurement.internal.zzgm;
import com.google.android.gms.measurement.internal.zzho;
import java.util.List;
import java.util.Map;

public final class zzc
implements zzho {
    public final /* synthetic */ zzbr zza;

    public zzc(zzbr zzbr2) {
        this.zza = zzbr2;
    }

    public final void zza(String string2, String string3, Bundle bundle) {
        this.zza.zzh(string2, string3, bundle);
    }

    public final void zzb(String string2, String string3, Bundle bundle, long l10) {
        this.zza.zzi(string2, string3, bundle, l10);
    }

    public final Map zzc(String string2, String string3, boolean bl2) {
        return this.zza.zzB(string2, string3, bl2);
    }

    public final void zzd(zzgl zzgl2) {
        this.zza.zzd(zzgl2);
    }

    public final void zze(zzgm zzgm2) {
        this.zza.zze(zzgm2);
    }

    public final void zzf(zzgm zzgm2) {
        this.zza.zzf(zzgm2);
    }

    public final String zzg() {
        return this.zza.zzz();
    }

    public final String zzh() {
        return this.zza.zzA();
    }

    public final String zzi() {
        return this.zza.zzx();
    }

    public final String zzj() {
        return this.zza.zzw();
    }

    public final long zzk() {
        return this.zza.zzy();
    }

    public final void zzl(String string2) {
        this.zza.zzu(string2);
    }

    public final void zzm(String string2) {
        this.zza.zzv(string2);
    }

    public final void zzn(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public final void zzo(String string2, String string3, Bundle bundle) {
        this.zza.zzl(string2, string3, bundle);
    }

    public final List zzp(String string2, String string3) {
        return this.zza.zzm(string2, string3);
    }

    public final int zzq(String string2) {
        return this.zza.zzE(string2);
    }

    public final Object zzr(int n10) {
        return this.zza.zzH(n10);
    }
}

