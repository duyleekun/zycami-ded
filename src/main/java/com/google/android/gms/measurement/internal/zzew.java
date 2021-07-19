/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 */
package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzex;

public final class zzew {
    public final /* synthetic */ zzex zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzew(zzex zzex2, String string2, String string3) {
        this.zza = zzex2;
        Preconditions.checkNotEmpty(string2);
        this.zzb = string2;
    }

    public final String zza() {
        boolean bl2 = this.zzc;
        if (!bl2) {
            this.zzc = bl2 = true;
            Object object = this.zza.zzd();
            String string2 = this.zzb;
            object = object.getString(string2, null);
            this.zzd = object;
        }
        return this.zzd;
    }

    public final void zzb(String string2) {
        SharedPreferences.Editor editor = this.zza.zzd().edit();
        String string3 = this.zzb;
        editor.putString(string3, string2);
        editor.apply();
        this.zzd = string2;
    }
}

