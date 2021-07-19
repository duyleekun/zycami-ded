/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

public final class zzc
implements Callable {
    private final /* synthetic */ SharedPreferences zzo;
    private final /* synthetic */ String zzp;
    private final /* synthetic */ Boolean zzq;

    public zzc(SharedPreferences sharedPreferences, String string2, Boolean bl2) {
        this.zzo = sharedPreferences;
        this.zzp = string2;
        this.zzq = bl2;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences sharedPreferences = this.zzo;
        String string2 = this.zzp;
        boolean bl2 = this.zzq;
        return sharedPreferences.getBoolean(string2, bl2);
    }
}

