/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class zzg
implements Callable {
    private final /* synthetic */ SharedPreferences zzo;
    private final /* synthetic */ String zzp;
    private final /* synthetic */ Long zzs;

    public zzg(SharedPreferences sharedPreferences, String string2, Long l10) {
        this.zzo = sharedPreferences;
        this.zzp = string2;
        this.zzs = l10;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences = this.zzo;
        String string2 = this.zzp;
        long l10 = this.zzs;
        return sharedPreferences.getLong(string2, l10);
    }
}

