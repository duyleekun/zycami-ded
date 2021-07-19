/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.util.Log
 */
package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzb {
    private SharedPreferences zzs;

    public zzb(Context context) {
        block5: {
            String string2;
            try {
                context = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (context == null) {
                    context = null;
                    break block5;
                }
                string2 = "google_ads_flags";
            }
            catch (Throwable throwable) {
                Log.w((String)"GmscoreFlag", (String)"Error while getting SharedPreferences ", (Throwable)throwable);
                this.zzs = null;
                return;
            }
            context = context.getSharedPreferences(string2, 0);
        }
        this.zzs = context;
    }

    public final boolean getBoolean(String string2, boolean bl2) {
        SharedPreferences sharedPreferences;
        block3: {
            try {
                sharedPreferences = this.zzs;
                if (sharedPreferences != null) break block3;
                return false;
            }
            catch (Throwable throwable) {
                Log.w((String)"GmscoreFlag", (String)"Error while reading from SharedPreferences ", (Throwable)throwable);
                return false;
            }
        }
        return sharedPreferences.getBoolean(string2, false);
    }

    public final float getFloat(String string2, float f10) {
        SharedPreferences sharedPreferences;
        block3: {
            try {
                sharedPreferences = this.zzs;
                if (sharedPreferences != null) break block3;
                return 0.0f;
            }
            catch (Throwable throwable) {
                Log.w((String)"GmscoreFlag", (String)"Error while reading from SharedPreferences ", (Throwable)throwable);
                return 0.0f;
            }
        }
        return sharedPreferences.getFloat(string2, 0.0f);
    }

    public final String getString(String string2, String string3) {
        SharedPreferences sharedPreferences;
        block3: {
            try {
                sharedPreferences = this.zzs;
                if (sharedPreferences != null) break block3;
                return string3;
            }
            catch (Throwable throwable) {
                Log.w((String)"GmscoreFlag", (String)"Error while reading from SharedPreferences ", (Throwable)throwable);
                return string3;
            }
        }
        return sharedPreferences.getString(string2, string3);
    }
}

