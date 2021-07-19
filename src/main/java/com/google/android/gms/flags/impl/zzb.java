/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.util.Log
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.flags.impl.zzc;
import com.google.android.gms.internal.flags.zze;

public final class zzb
extends zza {
    public static Boolean zza(SharedPreferences object, String string2, Boolean bl2) {
        try {
            zzc zzc2 = new zzc((SharedPreferences)object, string2, bl2);
            object = zze.zza(zzc2);
        }
        catch (Exception exception) {
            string2 = "Flag value not available, returning default: ";
            String string3 = String.valueOf(exception.getMessage());
            int n10 = string3.length();
            string3 = n10 != 0 ? string2.concat(string3) : new String(string2);
            Log.w((String)"FlagDataUtils", (String)string3);
            return bl2;
        }
        return (Boolean)object;
    }
}

