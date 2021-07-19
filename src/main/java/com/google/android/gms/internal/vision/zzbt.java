/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 */
package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;
import com.google.android.gms.internal.vision.zzbq;

public final class zzbt
implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzbq zzhg;

    public zzbt(zzbq zzbq2) {
        this.zzhg = zzbq2;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string2) {
        this.zzhg.zza(sharedPreferences, string2);
    }
}

