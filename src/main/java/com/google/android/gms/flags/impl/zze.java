/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class zze
implements Callable {
    private final /* synthetic */ SharedPreferences zzo;
    private final /* synthetic */ String zzp;
    private final /* synthetic */ Integer zzr;

    public zze(SharedPreferences sharedPreferences, String string2, Integer n10) {
        this.zzo = sharedPreferences;
        this.zzp = string2;
        this.zzr = n10;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences = this.zzo;
        String string2 = this.zzp;
        int n10 = this.zzr;
        return sharedPreferences.getInt(string2, n10);
    }
}

