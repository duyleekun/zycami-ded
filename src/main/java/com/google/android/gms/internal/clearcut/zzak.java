/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.clearcut.zzae;
import com.google.android.gms.internal.clearcut.zzao;

public final class zzak
extends zzae {
    public zzak(zzao zzao2, String string2, String string3) {
        super(zzao2, string2, string3, null);
    }

    private final String zzc(SharedPreferences sharedPreferences) {
        String string2;
        try {
            string2 = this.zzds;
        }
        catch (ClassCastException classCastException) {
            string2 = "Invalid string value in SharedPreferences for ";
            String string3 = String.valueOf(this.zzds);
            int n10 = string3.length();
            string2 = n10 != 0 ? string2.concat(string3) : (string3 = new String(string2));
            Log.e((String)"PhenotypeFlag", (String)string2, (Throwable)classCastException);
            return null;
        }
        return sharedPreferences.getString(string2, null);
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return this.zzc(sharedPreferences);
    }

    public final /* synthetic */ Object zzb(String string2) {
        return string2;
    }
}

