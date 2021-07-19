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

public final class zzes {
    public final /* synthetic */ zzex zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzes(zzex zzex2, String string2, boolean bl2) {
        this.zza = zzex2;
        Preconditions.checkNotEmpty(string2);
        this.zzb = string2;
        this.zzc = bl2;
    }

    public final boolean zza() {
        boolean bl2 = this.zzd;
        if (!bl2) {
            this.zzd = true;
            SharedPreferences sharedPreferences = this.zza.zzd();
            String string2 = this.zzb;
            boolean bl3 = this.zzc;
            this.zze = bl2 = sharedPreferences.getBoolean(string2, bl3);
        }
        return this.zze;
    }

    public final void zzb(boolean bl2) {
        SharedPreferences.Editor editor = this.zza.zzd().edit();
        String string2 = this.zzb;
        editor.putBoolean(string2, bl2);
        editor.apply();
        this.zze = bl2;
    }
}

