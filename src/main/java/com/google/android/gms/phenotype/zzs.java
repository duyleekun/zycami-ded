/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.util.Log
 */
package com.google.android.gms.phenotype;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.phenotype.PhenotypeFlag;
import com.google.android.gms.phenotype.PhenotypeFlag$Factory;

public final class zzs
extends PhenotypeFlag {
    public zzs(PhenotypeFlag$Factory phenotypeFlag$Factory, String string2, String string3) {
        super(phenotypeFlag$Factory, string2, string3, null);
    }

    private final String zzb(SharedPreferences sharedPreferences) {
        String string2;
        try {
            string2 = this.zzap;
        }
        catch (ClassCastException classCastException) {
            string2 = "Invalid string value in SharedPreferences for ";
            String string3 = String.valueOf(this.zzap);
            int n10 = string3.length();
            string2 = n10 != 0 ? string2.concat(string3) : (string3 = new String(string2));
            Log.e((String)"PhenotypeFlag", (String)string2, (Throwable)classCastException);
            return null;
        }
        return sharedPreferences.getString(string2, null);
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return this.zzb(sharedPreferences);
    }

    public final /* synthetic */ Object zza(String string2) {
        return string2;
    }
}

