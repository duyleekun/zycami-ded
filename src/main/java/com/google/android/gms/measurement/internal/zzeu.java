/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzex;

public final class zzeu {
    public final /* synthetic */ zzex zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzeu(zzex zzex2, String string2, long l10) {
        this.zza = zzex2;
        Preconditions.checkNotEmpty(string2);
        this.zzb = string2;
        this.zzc = l10;
    }

    public final long zza() {
        boolean bl2 = this.zzd;
        if (!bl2) {
            long l10;
            this.zzd = bl2 = true;
            SharedPreferences sharedPreferences = this.zza.zzd();
            String string2 = this.zzb;
            long l11 = this.zzc;
            this.zze = l10 = sharedPreferences.getLong(string2, l11);
        }
        return this.zze;
    }

    public final void zzb(long l10) {
        SharedPreferences.Editor editor = this.zza.zzd().edit();
        String string2 = this.zzb;
        editor.putLong(string2, l10);
        editor.apply();
        this.zze = l10;
    }
}

