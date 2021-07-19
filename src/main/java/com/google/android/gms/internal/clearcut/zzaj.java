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
import com.google.android.gms.internal.clearcut.zzy;
import java.util.regex.Matcher;

public final class zzaj
extends zzae {
    public zzaj(zzao zzao2, String string2, Boolean bl2) {
        super(zzao2, string2, bl2, null);
    }

    private final Boolean zzb(SharedPreferences sharedPreferences) {
        String string2;
        String string3;
        try {
            string3 = this.zzds;
            string2 = null;
        }
        catch (ClassCastException classCastException) {
            string3 = "Invalid boolean value in SharedPreferences for ";
            string2 = String.valueOf(this.zzds);
            int n10 = string2.length();
            string3 = n10 != 0 ? string3.concat(string2) : (string2 = new String(string3));
            Log.e((String)"PhenotypeFlag", (String)string3, (Throwable)classCastException);
            return null;
        }
        boolean bl2 = sharedPreferences.getBoolean(string3, false);
        return bl2;
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return this.zzb(sharedPreferences);
    }

    public final /* synthetic */ Object zzb(String string2) {
        Object object = zzy.zzcr.matcher(string2);
        boolean bl2 = ((Matcher)object).matches();
        if (bl2) {
            return Boolean.TRUE;
        }
        object = zzy.zzcs.matcher(string2);
        bl2 = ((Matcher)object).matches();
        if (bl2) {
            return Boolean.FALSE;
        }
        object = this.zzds;
        int n10 = String.valueOf(object).length() + 28;
        int n11 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("Invalid boolean value for ");
        stringBuilder.append((String)object);
        stringBuilder.append(": ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Log.e((String)"PhenotypeFlag", (String)string2);
        return null;
    }
}

